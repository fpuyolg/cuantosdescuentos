package com.portfolio.cuantosdescuentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int id_cliente;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	public Cliente() {    // Constructor vacío requerido por Hibernate
		
	}
	
	public Cliente(int id_cliente, String dni, String nombre, String telefono, String email) {
		this.id_cliente=id_cliente;
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}


	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}
	
}
