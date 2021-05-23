package com.portfolio.cuantosdescuentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private int id_empresa;
	
	@Column(name="cif")
	private String cif;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="cp")
	private String cp;
	
	@Column(name="localidad")
	private String localidad;
	
	// Constructor vacío requerido por Spring
	public Empresa() { 	}
	
	
	// Constructor con los campos de la entidad
	
	public Empresa(String cif, String nombre, String telefono, String email, String direccion, String cp,
			String localidad) {
		this.cif = cif;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.cp = cp;
		this.localidad = localidad;
	}


	// Métodos Getter y Setter
	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	// Sobreescribimos método toString()
	@Override
	public String toString() {
		return "Empresa [id_empresa=" + id_empresa + ", cif=" + cif + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", email=" + email + ", direccion=" + direccion + ", cp=" + cp + ", localidad=" + localidad
				+ ", getId_empresa()=" + getId_empresa() + ", getCif()=" + getCif() + ", getNombre()=" + getNombre()
				+ ", getTelefono()=" + getTelefono() + ", getEmail()=" + getEmail() + ", getDireccion()="
				+ getDireccion() + ", getCp()=" + getCp() + ", getLocalidad()=" + getLocalidad() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
