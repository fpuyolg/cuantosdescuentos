package com.portfolio.cuantosdescuentos.entity;

import java.time.LocalDate;

// Definimos esta clase para cargar en el histórico del cliente el histórico de tickets usados y de tickets pendientes, cada uno con el título de la oferta,
// la fecha de uso y si está usada o no

public class HistoricoCliente {
	String titulo;
	LocalDate fecha;
	Boolean usado;
}
