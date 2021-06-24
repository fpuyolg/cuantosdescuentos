package com.portfolio.cuantosdescuentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;


@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int id_cliente;
	
	@NotEmpty(message="Campo DNI obligatorio")
	@Pattern(regexp="^[0-9]{8}[A-Z]{1}", message="Si el primer dígito es 0 debe ponerlo. La letra debe ser mayúscula")
	@Column(name="dni")
	private String dni;
	
	@NotEmpty(message="Campo Nombre obligatorio")
	@Column(name="nombre")
	private String nombre;
	
	@NotEmpty(message="Campo teléfono obligatorio")
	@Pattern(regexp="^[0-9]{9}", message="Indique 9 dígitos")
	@Column(name="telefono")
	private String telefono;
	
	@Email(message="Email incorrecto")
	@Pattern(regexp=".+@.+\\..+", message="Email incorrecto")
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
