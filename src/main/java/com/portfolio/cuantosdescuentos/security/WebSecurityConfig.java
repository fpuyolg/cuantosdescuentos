package com.portfolio.cuantosdescuentos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.portfolio.cuantosdescuentos.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
		@Bean
		public UserDetailsService userDetailsService() {
			return new UserDetailsServiceImpl();
		}

		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
		
		// Para gestionar la autenticación
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.authenticationProvider(authenticationProvider());
		}
		
		// Para gestionar la autorización
		@Override
		protected void configure(final HttpSecurity http) throws Exception{

			try {
				http
		        .authorizeRequests()
		            .antMatchers("/").permitAll()
		            .antMatchers("/clientes/areaCliente").hasAuthority("CLIENTE")
		            .antMatchers("/clientes/verClientes").hasAuthority("CLIENTE")
		            .antMatchers("/empresas/verEmpresas").hasAuthority("EMPRESA")
	            .and()
	            	.formLogin().permitAll() 
	            .and()
		            .logout()
		            .logoutSuccessUrl("/");
				
			}catch(Exception e) {
				System.out.println(" >>>>>>>>> Error en comprobación de seguridad " + e.getStackTrace());
			}
		}
}
