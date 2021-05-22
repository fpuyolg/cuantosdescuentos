package com.portfolio.cuantosdescuentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String prueba(Model theModel) {
		List<Empresa> listaEmpresas=empresaService.findAll();
		theModel.addAttribute("listaEmpresas", listaEmpresas);
		return "empresas/ver-empresas";
	}
}
