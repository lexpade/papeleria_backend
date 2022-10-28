package com.fenix.papeleria.model;

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
@Table(name="productos")
public class Productos {
	
	@Id
	@Column(name="codigo_producto", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_producto;
	@Column(name="nombre_producto", length = 25)
	private String nombre_producto;
	@Column(name="descripcion_producto", length = 30)
	private String descripcion_producto;
	@Column(name="costo_producto")
	private float costo_producto;
	@Column(name="cantidades_presentacion")
	private int cantidades_presentacion;
	@Column(name="costo_unitario")
	private float costo_unitario;
	@Column(name="precio_venta")
	private float precio_venta;
	@Column(name="cantidad_stock")
	private int cantidad_stock;
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedores proveedor;
	
	public Productos() {}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public float getCosto_producto() {
		return costo_producto;
	}

	public void setCosto_producto(float costo_producto) {
		this.costo_producto = costo_producto;
	}

	public int getCantidades_presentacion() {
		return cantidades_presentacion;
	}

	public void setCantidades_presentacion(int cantidades_presentacion) {
		this.cantidades_presentacion = cantidades_presentacion;
	}

	public float getCosto_unitario() {
		return costo_unitario;
	}

	public void setCosto_unitario(float costo_unitario) {
		this.costo_unitario = costo_unitario;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	public int getCantidad_stock() {
		return cantidad_stock;
	}

	public void setCantidad_stock(int cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}

	public Proveedores getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad_stock, cantidades_presentacion, codigo_producto, costo_producto, costo_unitario,
				descripcion_producto, nombre_producto, precio_venta, proveedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return cantidad_stock == other.cantidad_stock && cantidades_presentacion == other.cantidades_presentacion
				&& codigo_producto == other.codigo_producto
				&& Float.floatToIntBits(costo_producto) == Float.floatToIntBits(other.costo_producto)
				&& Float.floatToIntBits(costo_unitario) == Float.floatToIntBits(other.costo_unitario)
				&& Objects.equals(descripcion_producto, other.descripcion_producto)
				&& Objects.equals(nombre_producto, other.nombre_producto)
				&& Float.floatToIntBits(precio_venta) == Float.floatToIntBits(other.precio_venta)
				&& Objects.equals(proveedor, other.proveedor);
	}

	@Override
	public String toString() {
		return "Productos [Código= " + codigo_producto + ", Nombre= " + nombre_producto
				+ ", Descripción= " + descripcion_producto + ", Costo= " + costo_producto
				+ ", cantidades de la presentación= " + cantidades_presentacion + ", costo unitario= " + costo_unitario
				+ ", precio de venta= " + precio_venta + ", cantidad en stock= " + cantidad_stock + ","
				+ "proveedor= " + proveedor + "]";
	}
	
}
