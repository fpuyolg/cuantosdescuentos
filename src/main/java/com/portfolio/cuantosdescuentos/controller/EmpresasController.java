package com.portfolio.cuantosdescuentos.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.portfolio.cuantosdescuentos.entity.Empresa;
import com.portfolio.cuantosdescuentos.entity.Usuario;
import com.portfolio.cuantosdescuentos.service.EmpresaService;
import com.portfolio.cuantosdescuentos.service.UsuarioService;


@Controller
public class EmpresasController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private UsuarioService usuarioService;
	
	public EmpresasController(EmpresaService thisEmpresaService, UsuarioService thisUsuarioService) {
		empresaService=thisEmpresaService;
		usuarioService=thisUsuarioService;
	}

	@GetMapping("/empresas/verEmpresas")
	public String verEmpresas(Model theModel) {
		List<Empresa> listaEmpresas=empresaService.findAll();
		theModel.addAttribute("listaEmpresas", listaEmpresas);
		return "empresas/ver-empresas";
	}
	
	
	@GetMapping("/empresas/nuevaEmpresa")
	public String nuevaEmpresa(Model modeloEmpresa, Model modeloUsuario) {
		
		Empresa nEmpresa = new Empresa();					// Creamos un modelo y le asignamos un objeto Empresa al que se vincularán
		modeloEmpresa.addAttribute("nEmpresa", nEmpresa);	// los campos del formulario de alta de nueva empresa
		
		Usuario nUsuario = new Usuario();
		modeloUsuario.addAttribute("nUsuario", nUsuario);
		
		return "empresas/nueva-empresa";
	}
	
	@PostMapping("/empresas/grabarEmpresa")
	public String grabarEmpresa(@Valid @ModelAttribute("nEmpresa") Empresa nEmpresa, BindingResult empresaBR, 
								@Valid @ModelAttribute("nUsuario") Usuario nUsuario, BindingResult usuarioBR) {
		
		if (empresaBR.hasErrors() || usuarioBR.hasErrors()) {
			return("/empresas/nueva-empresa");
		}
		
		empresaService.save(nEmpresa);
		
		nUsuario.setIdUsuario(nEmpresa.getCif());		// Añadimos al ModelAttribute nUsuario los dos datos que faltan (id_usuario=CIF y Rol="EMPRESA")
		nUsuario.setRol("EMPRESA");
		nUsuario.setClave(passwordEncoder.encode(nUsuario.getClave()));
		
		usuarioService.save(nUsuario);		
		
		return "redirect:/empresas/verEmpresas";
	}
	
}