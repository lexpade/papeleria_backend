package com.fenix.papeleria.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_ventas")
public class Detalle_Ventas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="item_venta", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_venta;
	@OneToOne
	@JoinColumn(name="codigo_producto")
	private Productos producto;
	@Column(name="cantidad_vendida")
	private int cantidad_vendida;
	@Column(name="subtotal_item")
	private float subtotal_item;
	@ManyToOne
	@JoinColumn(name="numero_factura")
	private Factura factura;
	
	public Detalle_Ventas() {}

	public int getItem_venta() {
		return item_venta;
	}

	public void setItem_venta(int item_venta) {
		this.item_venta = item_venta;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public int getCantidad_vendida() {
		return cantidad_vendida;
	}

	public void setCantidad_vendida(int cantidad_vendida) {
		this.cantidad_vendida = cantidad_vendida;
	}

	public float getSubtotal_item() {
		return subtotal_item;
	}

	public void setSubtotal_item(float subtotal_item) {
		this.subtotal_item = subtotal_item;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad_vendida, factura, item_venta, producto, subtotal_item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Detalle_Ventas other = (Detalle_Ventas) obj;
		return cantidad_vendida == other.cantidad_vendida && Objects.equals(factura, other.factura)
				&& item_venta == other.item_venta && Objects.equals(producto, other.producto)
				&& Float.floatToIntBits(subtotal_item) == Float.floatToIntBits(other.subtotal_item);
	}

	@Override
	public String toString() {
		return "Detalle_Ventas [item_venta=" + item_venta + ", producto=" + producto + ", cantidad_vendida="
				+ cantidad_vendida + ", subtotal_item=" + subtotal_item + ", factura=" + factura + "]";
	}
	
}
