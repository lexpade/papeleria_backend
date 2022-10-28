package com.fenix.papeleria.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuarios", unique = true)
	private int id_usuarios;
	@Column(name="nombre_usuario", length = 25)
	private String nombre_usuario;
	@Column(name="apellidos_usuario", length = 30)
	private String apellidos_usuario;
	@Column(name="direccion_usuario", length = 100)
	private String direccion_usuario;
	@Column(name="telefono_usuario", length = 10, unique = true)
	private String telefono_usuario;
	@Column(name="email_usuario", length = 50, unique = true)
	private String email_usuario;
	@Column(name="tipo_usuario", length = 13)
	private String tipo_usuario;
	@Column(name="contrasenia_usuario", length = 50)
	private String contrasenia_usuario;
	@Column(name="fecha_ingreso")
	private Timestamp fecha_ingreso;
	@Column(name="token_usuario", length = 255)
	private String token_usuario;
	
	public Usuarios() {}

	public int getId_usuarios() {
		return id_usuarios;
	}

	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellidos_usuario() {
		return apellidos_usuario;
	}

	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}

	public String getDireccion_usuario() {
		return direccion_usuario;
	}

	public void setDireccion_usuario(String direccion_usuario) {
		this.direccion_usuario = direccion_usuario;
	}

	public String getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getContrasenia_usuario() {
		return contrasenia_usuario;
	}

	public void setContrasenia_usuario(String contrasenia_usuario) {
		this.contrasenia_usuario = contrasenia_usuario;
	}

	public Timestamp getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Timestamp fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	
	public String getToken_usuario() {
		return token_usuario;
	}

	public void setToken_usuario(String token_usuario) {
		this.token_usuario = token_usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos_usuario, contrasenia_usuario, direccion_usuario, email_usuario, fecha_ingreso,
				id_usuarios, nombre_usuario, telefono_usuario, tipo_usuario, token_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(apellidos_usuario, other.apellidos_usuario)
				&& Objects.equals(contrasenia_usuario, other.contrasenia_usuario)
				&& Objects.equals(direccion_usuario, other.direccion_usuario)
				&& Objects.equals(email_usuario, other.email_usuario)
				&& Objects.equals(fecha_ingreso, other.fecha_ingreso) && id_usuarios == other.id_usuarios
				&& Objects.equals(nombre_usuario, other.nombre_usuario)
				&& Objects.equals(telefono_usuario, other.telefono_usuario)
				&& Objects.equals(tipo_usuario, other.tipo_usuario)
				&& Objects.equals(token_usuario, other.token_usuario);
	}

	@Override
	public String toString() {
		return "Usuarios [ID= " + id_usuarios + ", Nombre= " + nombre_usuario + ", Apellidos= "
				+ apellidos_usuario + ", direccion= " + direccion_usuario + ", teléfono= "
				+ telefono_usuario + ", email= " + email_usuario + ", rol= " + tipo_usuario
				+ ", fecha de ingreso= " + fecha_ingreso + ",token= "+ token_usuario +"]";
	}	
}