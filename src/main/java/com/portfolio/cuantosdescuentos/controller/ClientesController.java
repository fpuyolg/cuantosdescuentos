package com.portfolio.cuantosdescuentos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public ClientesController(ClienteService thisClienteService, UsuarioService thisUsuarioService) {
		clienteService=thisClienteService;
		usuarioService=thisUsuarioService;
	}
	
	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
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
		
		nUsuario.setId_usuario(nCliente.getDni());		// Añadimos al ModelAttribute nUsuario los dos datos que faltan
		nUsuario.setRol("CLIENTE");						// el id_usuario que será el DNI del cliente y el rol que será "CLIENTE"
		usuarioService.save(nUsuario);
		
		return "redirect:/clientes/verClientes";
	}
}

