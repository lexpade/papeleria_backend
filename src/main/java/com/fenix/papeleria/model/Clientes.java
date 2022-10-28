package com.fenix.papeleria.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_cliente", unique=true)
	private int id_cliente;
	@Column(name="nombre_cliente", length = 25)
	private String nombre_cliente;
	@Column(name="apellidos_cliente", length = 30)
	private String apellidos_cliente;
	@Column(name="direccion_cliente", length = 100)
	private String direccion_cliente;
	@Column(name="telefono_cliente", unique=true, length = 10)
	private String telefono_cliente;
	@Column(name="email_cliente", unique=true, length = 50)
	private String email_cliente;
	
	public Clientes() {}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellidos_cliente() {
		return apellidos_cliente;
	}

	public void setApellidos_cliente(String apellidos_cliente) {
		this.apellidos_cliente = apellidos_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos_cliente, direccion_cliente, email_cliente, id_cliente, nombre_cliente,
				telefono_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		return Objects.equals(apellidos_cliente, other.apellidos_cliente)
				&& Objects.equals(direccion_cliente, other.direccion_cliente)
				&& Objects.equals(email_cliente, other.email_cliente) && id_cliente == other.id_cliente
				&& Objects.equals(nombre_cliente, other.nombre_cliente)
				&& Objects.equals(telefono_cliente, other.telefono_cliente);
	}

	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + ", apellidos_cliente="
				+ apellidos_cliente + ", direccion_cliente=" + direccion_cliente + ", telefono_cliente="
				+ telefono_cliente + ", email_cliente=" + email_cliente + "]";
	}
	
}
