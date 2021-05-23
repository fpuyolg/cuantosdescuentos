package com.portfolio.cuantosdescuentos.service;

import java.util.List;
import com.portfolio.cuantosdescuentos.entity.Empresa;

public interface EmpresaService {

		public List<Empresa> findAll();
		
		public void save(Empresa nEmpresa);
}
