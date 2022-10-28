package com.fenix.papeleria.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedores implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="id_proveedor", length = 12, unique = true)
    private String id_proveedor;
    @Column(name="nombre_proveedor", length = 50)
    private String nombre_proveedor;
    @Column(name="telefono_proveedor", length = 10, unique = true)
    private String telefono_proveedor;
    @Column(name="email_proveedor", length = 50, unique = true)
    private String email_proveedor;
	
    public Proveedores() {}

	public String getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(String id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getEmail_proveedor() {
		return email_proveedor;
	}

	public void setEmail_proveedor(String email_proveedor) {
		this.email_proveedor = email_proveedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email_proveedor, id_proveedor, nombre_proveedor, telefono_proveedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedores other = (Proveedores) obj;
		return Objects.equals(email_proveedor, other.email_proveedor)
				&& Objects.equals(id_proveedor, other.id_proveedor)
				&& Objects.equals(nombre_proveedor, other.nombre_proveedor)
				&& Objects.equals(telefono_proveedor, other.telefono_proveedor);
	}

	@Override
	public String toString() {
		return "Proveedores [ID= " + id_proveedor + ", Nombre= " + nombre_proveedor
				+ ", teléfono= " + telefono_proveedor + ", email= " + email_proveedor + "]";
	}
    
}
