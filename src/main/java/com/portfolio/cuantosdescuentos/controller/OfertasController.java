package com.portfolio.cuantosdescuentos.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.portfolio.cuantosdescuentos.CuantosdescuentosApplication;
import com.portfolio.cuantosdescuentos.entity.Categoria;
import com.portfolio.cuantosdescuentos.entity.Empresa;
import com.portfolio.cuantosdescuentos.entity.Oferta;
import com.portfolio.cuantosdescuentos.service.CategoriaService;
import com.portfolio.cuantosdescuentos.service.ClienteService;
import com.portfolio.cuantosdescuentos.service.EmpresaService;
import com.portfolio.cuantosdescuentos.service.HistoCliService;
import com.portfolio.cuantosdescuentos.service.UsuarioDetails;
import com.portfolio.cuantosdescuentos.service.UsuarioService;

@Controller
public class OfertasController {
	
	Logger logger= Logger.getLogger(CuantosdescuentosApplication.class.getName());
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HistoCliService histoCliService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public OfertasController(ClienteService thisClienteService, UsuarioService thisUsuarioService, HistoCliService thisHistoCliService) {
		clienteService=thisClienteService;
		usuarioService=thisUsuarioService;
		histoCliService=thisHistoCliService;
	}
	
	@GetMapping("/ofertas/nuevaOferta")
	public String nuevaOferta(@AuthenticationPrincipal UsuarioDetails usuarioDetails, Model modeloDatosOferta) {
								// con @AuthenticationPrincipal obtenemos los destalles del usuario activo, es decir, que acaba de logarse
			
		// 1. Obtenemos el ID del usuario logado (DNI/CIF) para poder obtener los datos de la empresa
		try {
			// Localizamos los datos de la empresa logada
			Empresa empresaLogada = empresaService.findByCif(usuarioDetails.getId());
			logger.info("\n EMPRESA LOGADA: " + empresaLogada.getCif() + " / "+ empresaLogada.getNombre());		
			// 2. Obtenemos la lista de categorías
			List<Categoria> listaCategorias = categoriaService.findAll();
			
			// 3. Insertamos los atributos en el modelo que se enviará al formulario de nueva oferta
			Oferta nOferta = new Oferta();
			nOferta.setId_empresa(empresaLogada.getCif());
			modeloDatosOferta.addAttribute("nOferta", nOferta);
			modeloDatosOferta.addAttribute("listaCategorias", listaCategorias);
			logger.info("Creamos modelo con los datos necesarios y enviamos a página Nueva Oferta");
			
		}catch(Exception e) {
			logger.info("\n Error al obtener datos para crear una nueva oferta: " + e);
		}

		return "ofertas/nueva-oferta";
	}
	
}

