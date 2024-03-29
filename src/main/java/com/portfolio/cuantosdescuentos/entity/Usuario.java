package com.portfolio.cuantosdescuentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private String id;
		
		@Column(name="id_usuario")
		private String idUsuario;
		
		@Column(name="nombre_usuario")
		@Size(min=6, max=15, message="El usuario debe tener entre 6 y 15 caracteres")
		@NotEmpty(message="Nombre de usuario obligatorio")
		private String nombre_usuario;
		
		@Column(name="clave")
		//@Size(min=6, max=15, message="La clave debe tener entre 6 y 15 caracteres")		Por la encryptación pasa a 60 caracteres y da error. Revisar
		@NotEmpty(message="Clave obligatoria")
		private String clave;
		
		@Column(name="rol")
		private String rol;
		
		public Usuario() {
		}

		public Usuario(int id, String idUsuario,
				@Min(value = 6, message = "El usuario debe tener entre 6 y 15 caracteres") @Max(value = 15, message = "El usuario debe tener entre 6 y 15 caracteres") @NotEmpty(message = "Nombre de usuario obligatorio") String nombre_usuario,
				@Min(value = 6, message = "El usuario debe tener entre 6 y 15 caracteres") @Max(value = 15, message = "El usuario debe tener entre 6 y 15 caracteres") @NotEmpty(message = "Clave obligatoria") String clave,
				String rol) {
			this.idUsuario = idUsuario;
			this.nombre_usuario = nombre_usuario;
			this.clave = clave;
			this.rol = rol;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(String id_usuario) {
			this.idUsuario = id_usuario;
		}

		public String getNombre_usuario() {
			return nombre_usuario;
		}

		public void setNombre_usuario(String nombre_usuario) {
			this.nombre_usuario = nombre_usuario;
		}

		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + "id_usuario=" + idUsuario + ", nombre_usuario=" + nombre_usuario + ", clave=" + clave
					+ ", rol=" + rol + "]";
		}
}