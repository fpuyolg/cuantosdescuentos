package com.portfolio.cuantosdescuentos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.portfolio.cuantosdescuentos.entity.Cliente;
import com.portfolio.cuantosdescuentos.service.ClienteService;

@Controller
public class ClientesController {
	
	@Autowired
	private ClienteService clienteService;
	
	public ClientesController(ClienteService thisClienteService) {
		clienteService=thisClienteService;
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
	
	@GetMapping("/clientes/nuevoCliente")
	public String nuevoCliente(Model theModel) {
		Cliente nCliente = new Cliente();
		theModel.addAttribute("nCliente", nCliente);	// Para nuevo cliente pasamos un modelo con un atributo tipo Cliente preparado para recibir los datos
		return "clientes/nuevo-cliente";
	}
	
	@PostMapping("/clientes/grabarCliente")
	public String grabarCliente(@ModelAttribute("nCliente") Cliente nCliente) {
		clienteService.save(nCliente);
		return "redirect:/clientes/verClientes";
	}
}

