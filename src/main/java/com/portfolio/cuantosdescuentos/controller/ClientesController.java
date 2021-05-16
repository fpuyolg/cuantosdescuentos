package com.portfolio.cuantosdescuentos.controller;

import java.lang.reflect.Array;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.portfolio.cuantosdescuentos.entity.Cliente;
import com.portfolio.cuantosdescuentos.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClienteService clienteService;
	
	public ClientesController(ClienteService thisClienteService) {
		clienteService=thisClienteService;
	}
	
	@GetMapping("/vertodos")
	public String principal(Model theModel) {
		List<Cliente>listaClientes = clienteService.findAll();
		
		
		/* Cliente[] clientesArray = new Cliente[listaClientes.size()];
		clientesArray = listaClientes.toArray(clientesArray);
		for (int i=0; i<clientesArray.length; i++) {			Comprobamos que recupera bien los clientes de la base de datos
			System.out.println(clientesArray[i]);
		}  */

		theModel.addAttribute("lista", listaClientes);
		return "clientes/ver-clientes";
	}
}
