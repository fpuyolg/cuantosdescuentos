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
import com.portfolio.cuantosdescuentos.entity.Cliente;
import com.portfolio.cuantosdescuentos.entity.Usuario;
import com.portfolio.cuantosdescuentos.service.ClienteService;
import com.portfolio.cuantosdescuentos.service.UsuarioService;

@Controller
public class ClientesController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;	// Para encriptar la clave de usuario antes de grabarla en la base de datos
	
	public ClientesController(ClienteService thisClienteService, UsuarioService thisUsuarioService) {
		clienteService=thisClienteService;
		usuarioService=thisUsuarioService;
	}
	
	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
		// ACCESO A AREA CLIENTE
	
	@GetMapping("/clientes/areaCliente")
	public String areaCliente(Model theModel) {
		//List<Cliente>listaClientes = clienteService.findAll();

		//theModel.addAttribute("lista", listaClientes);
		return "clientes/area-cliente";
	}
	
		// VER TABLA CON TODOS LOS CLIENTES
	
	@GetMapping("/clientes/verClientes")
	public String verClientes(Model theModel) {
		List<Cliente>listaClientes = clienteService.findAll();

		theModel.addAttribute("lista", listaClientes);
		return "clientes/ver-clientes";
	}

		// ALTA DE CLIENTE. SE GRABAN DATOS EN TABLA CLIENTES Y TABLA USUARIOS
	
	@GetMapping("/clientes/nuevoCliente")
	public String nuevoCliente(Model modeloCliente, Model modeloUsuario) {	// Añadir un segundo modelo para guardar datos en la tabla usuario
		
		Cliente nCliente = new Cliente();
		modeloCliente.addAttribute("nCliente", nCliente);	// Para nuevo cliente pasamos un modelo con un atributo tipo Cliente preparado para recibir los datos
		
		Usuario nUsuario = new Usuario();
		modeloUsuario.addAttribute("nUsuario", nUsuario);
		
		return "clientes/nuevo-cliente";
	}

	
	@PostMapping("/clientes/grabarCliente")		// Añadir un segundo ModelAttribute para grabar los datos de la tabla usuario
	public String grabarCliente(@Valid @ModelAttribute("nCliente") Cliente nCliente, BindingResult clienteBR, 
								@Valid @ModelAttribute("nUsuario") Usuario nUsuario, BindingResult usuarioBR) {
		
		if (clienteBR.hasErrors() || usuarioBR.hasErrors()) {
			return("/clientes/nuevo-cliente");
		}
		
		clienteService.save(nCliente);
		
		nUsuario.setId_usuario(nCliente.getDni());		// Añadimos al ModelAttribute nUsuario los dos datos que faltan (id_usuario=DNI y rol "CLIENTE"
		nUsuario.setRol("CLIENTE");
		nUsuario.setClave(passwordEncoder.encode(nUsuario.getClave()));		// Encriptamos la clave con PasswordEncoder
		
		usuarioService.save(nUsuario);
		
		return "redirect:/clientes/verClientes";
	}
}

