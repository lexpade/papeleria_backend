package com.fenix.papeleria.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero_factura", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero_factura;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Clientes cliente;
	@Column(name="subtotal_venta")
	private float subtotal_venta;
	@Column(name="valor_iva")
	private float valor_iva;
	@Column(name="total_venta")
	private float total_venta;
	@Column(name="fecha_venta")
	private Timestamp fecha_venta;
	@ManyToOne
	@JoinColumn(name="id_usuarios")
	private Usuarios usuario;
	
	public Factura() {}

	public int getNumero_factura() {
		return numero_factura;
	}

	public void setNumero_factura(int numero_factura) {
		this.numero_factura = numero_factura;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public float getSubtotal_venta() {
		return subtotal_venta;
	}

	public void setSubtotal_venta(float subtotal_venta) {
		this.subtotal_venta = subtotal_venta;
	}

	public float getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(float valor_iva) {
		this.valor_iva = valor_iva;
	}

	public float getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(float total_venta) {
		this.total_venta = total_venta;
	}

	public Timestamp getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Timestamp fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fecha_venta, numero_factura, subtotal_venta, total_venta, usuario, valor_iva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fecha_venta, other.fecha_venta)
				&& numero_factura == other.numero_factura
				&& Float.floatToIntBits(subtotal_venta) == Float.floatToIntBits(other.subtotal_venta)
				&& Float.floatToIntBits(total_venta) == Float.floatToIntBits(other.total_venta)
				&& Objects.equals(usuario, other.usuario)
				&& Float.floatToIntBits(valor_iva) == Float.floatToIntBits(other.valor_iva);
	}

	@Override
	public String toString() {
		return "Factura [numero_factura=" + numero_factura + ", cliente=" + cliente + ", subtotal_venta="
				+ subtotal_venta + ", valor_iva=" + valor_iva + ", total_venta=" + total_venta + ", fecha_venta="
				+ fecha_venta + ", usuario=" + usuario + "]";
	}
	
}
