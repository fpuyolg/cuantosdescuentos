package com.portfolio.cuantosdescuentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.cuantosdescuentos.dao.EmpresaRepository;
import com.portfolio.cuantosdescuentos.entity.Empresa;

public class EmpresaServiceImpl implements EmpresaService {
	
	private EmpresaRepository empresaRepository;
	
	@Autowired
	public EmpresaServiceImpl (EmpresaRepository thisEmpresaRepository) {
		empresaRepository=thisEmpresaRepository;
	}

	@Override
	public List<Empresa> findAll() {
		List<Empresa> listaEmpresas = empresaRepository.findAll();
		return listaEmpresas;
	}

}
