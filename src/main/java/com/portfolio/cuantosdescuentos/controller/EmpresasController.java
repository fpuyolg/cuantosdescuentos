package com.portfolio.cuantosdescuentos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.cuantosdescuentos.entity.Empresa;
import com.portfolio.cuantosdescuentos.service.EmpresaService;


@Controller
public class EmpresasController {
	
	@Autowired
	private EmpresaService empresaService;
	
	public EmpresasController(EmpresaService thisEmpresaService) {
		empresaService=thisEmpresaService;
	}

	@GetMapping("/empresas/verEmpresas")
	public String verEmpresas(Model theModel) {
		List<Empresa> listaEmpresas=empresaService.findAll();
		theModel.addAttribute("listaEmpresas", listaEmpresas);
		return "empresas/ver-empresas";
	}
	
	@GetMapping("/empresas/nuevaEmpresa")
	public String nuevaEmpresa(Model theModel) {
		Empresa nEmpresa = new Empresa();					// Creamos un modelo y le asignamos un objeto Empresa al que se vincularán
		theModel.addAttribute("nEmpresa", nEmpresa);		// los campos del formulario de alta de nueva empresa
		return "empresas/nueva-empresa";
	}
	
	@PostMapping("/empresas/grabarEmpresa")
	public String grabarEmpresa(@ModelAttribute("nEmpresa") Empresa nEmpresa) {
		empresaService.save(nEmpresa);
		return "redirect:/empresas/verEmpresas";
	}
	
}