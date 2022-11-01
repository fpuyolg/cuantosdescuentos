package com.portfolio.cuantosdescuentos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.cuantosdescuentos.entity.HistoCli;
import com.portfolio.cuantosdescuentos.entity.HistoricoCliente;

public interface HistoCliRepository extends JpaRepository <HistoCli, Integer>{
	
	@Query("FROM HistoCli WHERE id_cliente = ?1")		// Desde ClientesController llamamos al método enviándole el id_cliente que se recibe en ?1
	List<HistoCli> findById_cliente(int id_cliente);
	
	// A partir del id_cliente obtenemos el nombre, la fecha y si ha usado o no cada una de las ofertas adquiridas
//	@Query("SELECT o.titulo, h.fecha, h.usado FROM HistoCli as h JOIN ofertas as o where o.id_oferta=h.id_oferta AND h.id_cliente=?1")
//	List<HistoricoCliente> findById_oferta(int id_cliente);
}


// Consulta para cargar el nombre de la oferta una vez tenemos el ID Oferta
// SELECT t.CourseId FROM Task as t INNER JOIN Courses as c ...

// SELECT t.CourseId FROM Courses as c INNER JOIN c.Tasks as t ...

// SELECT o.titulo, h.fecha, h.usado FROM 