package com.portfolio.cuantosdescuentos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.cuantosdescuentos.CuantosdescuentosApplication;
import com.portfolio.cuantosdescuentos.entity.Cliente;
import com.portfolio.cuantosdescuentos.entity.HistoCli;
import com.portfolio.cuantosdescuentos.entity.Oferta;
import com.portfolio.cuantosdescuentos.entity.Usuario;
import com.portfolio.cuantosdescuentos.entity.nuevaClave;
import com.portfolio.cuantosdescuentos.service.ClienteService;
import com.portfolio.cuantosdescuentos.service.HistoCliService;
import com.portfolio.cuantosdescuentos.service.UsuarioDetails;
import com.portfolio.cuantosdescuentos.service.UsuarioService;
import com.sun.tools.sjavac.Log;

@Controller
public class ClientesController {
	
	Logger logger= Logger.getLogger(CuantosdescuentosApplication.class.getName());
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HistoCliService histoCliService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;	// Para encriptar la clave de usuario antes de grabarla en la base de datos
	
	public ClientesController(ClienteService thisClienteService, UsuarioService thisUsuarioService, HistoCliService thisHistoCliService) {
		clienteService=thisClienteService;
		usuarioService=thisUsuarioService;
		histoCliService=thisHistoCliService;
	}
	
	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
	@RequestMapping("/403")
	public String accessDenied() {
	    return "errores/403";
	}
	
		// ACCESO A AREA CLIENTE
	
	@GetMapping("/clientes/areaCliente")
	public String areaCliente(@AuthenticationPrincipal UsuarioDetails usuarioDetails, Model modeloAreaClientes, Model modeloHistoricoCliente,
			Model modeloDatosOferta) {
				// con @AuthenticationPrincipal obtenemos los destalles del usuario activo, es decir, que acaba de logarse
			
		// Obtenemos el ID del usuario logado (DNI), buscamos en la tabla Clientes por DNI y pasamos los datos al área clientes con modeloAreaClientes
		String idUsuario = usuarioDetails.getId();
		
		try {
		Cliente clienteLogado = clienteService.findByDni(idUsuario);
			//logger.info("\n CLIENTE LOGADO: " + clienteLogado.getDni() + " / "+ clienteLogado.getNombre());
			logger.info("\n CLIENTE LOGADO: " + clienteLogado.getDni() + " / "+ clienteLogado.getNombre());
			modeloAreaClientes.addAttribute("clienteLogado", clienteLogado);
		
		// Recuperamos los tickets del cliente (usados o no) de la tabla histocli con el id_cliente (DNI)
			logger.info("\n Buscamos los tickets del cliente en HistoCli");
			
//		NUEVA CARGA DE HISTÓRICO (CON EL TÍTULO DE LOS TICKETS EN LUGAR DEL CÓDIGO)
		List <HistoCli> histoCli= new ArrayList<HistoCli>();
		List <Oferta> datosOferta = new ArrayList<Oferta>();
		
		// List<Object[]> historicoUsuario = histoCliService.findById_cliente(clienteLogado.getId_cliente());
		List<Object[]> historicoUsuario = histoCliService.findById_cliente(clienteLogado.getId_cliente());
		for (Object[] datosHistorico : historicoUsuario) {
		    histoCli.add((HistoCli) datosHistorico[0]);
		    datosOferta.add((Oferta) datosHistorico[1]);
		}
		
		modeloHistoricoCliente.addAttribute("historicoCliente", histoCli);
		modeloDatosOferta.addAttribute("datosOferta", datosOferta);
		
		}catch(Exception e) {
			logger.info("\n Cliente no existe: " + e);
		}
		
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

	
	@PostMapping("/clientes/grabarCliente")		// Usamos 2 ModelAttribute, uno para grabar los datos en tabla Clientes y otro para la tabla Usuarios
	public String grabarCliente(@Valid @ModelAttribute("nCliente") Cliente nCliente, BindingResult clienteBR, 
								@Valid @ModelAttribute("nUsuario") Usuario nUsuario, BindingResult usuarioBR,
								Model modeloCliente) {
		
		if (clienteBR.hasErrors() || usuarioBR.hasErrors()) {
			return("/clientes/nuevo-cliente");
		}
		
		clienteService.save(nCliente);
		
		// Añadimos al ModelAttribute nUsuario los dos datos que faltan (id_usuario=DNI y rol "CLIENTE") y encriptamos la clave
		nUsuario.setIdUsuario(nCliente.getDni());
		nUsuario.setRol("CLIENTE");
		nUsuario.setClave(passwordEncoder.encode(nUsuario.getClave()));		// Encriptamos la clave con PasswordEncoder
		
		usuarioService.save(nUsuario);
		modeloCliente.addAttribute("clienteLogado", nCliente);	// Enviamos los datos del nuevo cliente para cargar área cliente
		
		return "clientes/area-cliente";
	}
	
	@GetMapping("/clientes/actualizaCliente")
	public String actualizaEmpleado(@RequestParam("clienteId") String dni, Model theModel) {
		
		// Recuperamos los datos del empleado para volcarlos en el modelo
		Cliente clienteActualizando = clienteService.findByDni(dni);
		
		logger.info("\n >>>>>>>>>> DATOS USUARIO: " + clienteActualizando.getId_cliente()
		 + " / "+ clienteActualizando.getDni() + " / "+ clienteActualizando.getNombre() + " / "+ clienteActualizando.getTelefono()
		 + " / " + clienteActualizando.getEmail() + "\n\n");
	
		theModel.addAttribute("clienteActualizar", clienteActualizando);

		return "clientes/actualiza-datos-cliente";
	}
	
	@PostMapping("/clientes/actualizarCliente")
	public String ActualizarCliente(@AuthenticationPrincipal UsuarioDetails usuarioDetails,		// Para acceder a los datos del usuario logado
									@Valid @ModelAttribute("nCliente") Cliente nCliente, BindingResult clienteBR,	// Contiene los nuevos datos del Cliente
									Model modeloCliente){		// Se envía para poder cargar el área de cliente
		
		if (clienteBR.hasErrors()) {
			return("/clientes/actualiza-datos-cliente");
		}
		
		// Obtenemos el ID del usuario logado (DNI) y lo comparamos con el DNI del cliente por si lo han actualizado
		// y si ha cambiado actualizamos el usuario
		String idUsuario = usuarioDetails.getId();
		
		if (!idUsuario.equals(nCliente.getDni())) {
			Usuario usuarioActualizar = usuarioService.findByIdUsuario(idUsuario);

			 try { 
				 
				 usuarioActualizar.setIdUsuario(nCliente.getDni());
				 usuarioService.save(usuarioActualizar); 
				 
			 }catch (Exception e){
				 logger.info(" >>>>>>>>> Error: " + e.getStackTrace()); 
		     }	
		}
		
		// Guardamos los nuevos datos del cliente y actualizamos también el DNI en la tabla de usuarios
		
		 logger.info("\n >>>>>>>>> INICIO ACTUALIZAR CLIENTE"); 
		clienteService.save(nCliente);
		 logger.info(" >>>>>>>>> FIN ACTUALIZAR CLIENTE"); 
		usuarioDetails.setId(nCliente.getDni());
		
		// Enviamos los nuevos datos para que se pueda cargar de nuevo el área de cliente
		modeloCliente.addAttribute("clienteLogado", nCliente);
		
		this.areaCliente(usuarioDetails, modeloCliente, modeloCliente, modeloCliente);
		
        return "clientes/area-cliente";
	}
	
	@GetMapping("/clientes/actualizarClave")
	public String actualizaClave(@RequestParam("dniUsuario") String dni, Model datosActualizaClave) {
		
		nuevaClave nuevaClave = new nuevaClave();
		nuevaClave.setDni(dni);
		datosActualizaClave.addAttribute("datosActualizaClave", nuevaClave);
		
		return "clientes/actualiza-clave-usuario";
	}
	
	@PostMapping("/clientes/GrabarNuevaClave")
	public String ActualizarClave( @AuthenticationPrincipal UsuarioDetails usuarioDetails,		// Para acceder a los datos del usuario logado
									@Valid @ModelAttribute("datosActualizaClave") nuevaClave nuevaClave, BindingResult usuarioBR,
									Model modelo) {
											// Se envía para poder cargar el formulario de cambio de clave
		
		if (usuarioBR.hasErrors()) {
			return("/clientes/actualiza-clave-usuario");
		}
		
		if(nuevaClave.getNuevaClave().equals(nuevaClave.getNuevaClaveRep())) {
			Usuario tempUsuario = new Usuario();
			tempUsuario=usuarioService.findByIdUsuario(nuevaClave.getDni());
			tempUsuario.setClave(passwordEncoder.encode(nuevaClave.getNuevaClave()));
			usuarioService.save(tempUsuario);
		}
		
		this.areaCliente(usuarioDetails, modelo, modelo, modelo);
		
        return "clientes/area-cliente";
	}
	
}

