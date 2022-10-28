package com.fenix.papeleria.model;

import java.sql.Timestamp;
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
@Table(name="detalle_compras")
public class Detalle_Compras {
	
	@Id
	@Column(name="item_compra", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_compra;
	@Column(name="fecha_ingreso")
	private Timestamp fecha_ingreso;
	@Column(name="cantidad_comprada")
	private int cantidad_comprada;
	@Column(name="valor_compra_item")
	private float valor_compra_item;
	@OneToOne
	@JoinColumn(name="codigo_producto")
	private Productos producto;
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedores proveedor;
	@Column(name="numero_factura_proveedor")
	private int numero_factura_proveedor;
	
	public Detalle_Compras() {}

	public int getItem_compra() {
		return item_compra;
	}

	public void setItem_compra(int item_compra) {
		this.item_compra = item_compra;
	}

	public Timestamp getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Timestamp fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public int getCantidad_comprada() {
		return cantidad_comprada;
	}

	public void setCantidad_comprada(int cantidad_comprada) {
		this.cantidad_comprada = cantidad_comprada;
	}

	public float getValor_compra_item() {
		return valor_compra_item;
	}

	public void setValor_compra_item(float valor_compra_item) {
		this.valor_compra_item = valor_compra_item;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Proveedores getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}

	public int getNumero_factura_proveedor() {
		return numero_factura_proveedor;
	}

	public void setNumero_factura_proveedor(int numero_factura_proveedor) {
		this.numero_factura_proveedor = numero_factura_proveedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad_comprada, fecha_ingreso, item_compra, numero_factura_proveedor, producto,
				proveedor, valor_compra_item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Detalle_Compras other = (Detalle_Compras) obj;
		return cantidad_comprada == other.cantidad_comprada && Objects.equals(fecha_ingreso, other.fecha_ingreso)
				&& item_compra == other.item_compra && numero_factura_proveedor == other.numero_factura_proveedor
				&& Objects.equals(producto, other.producto) && Objects.equals(proveedor, other.proveedor)
				&& Float.floatToIntBits(valor_compra_item) == Float.floatToIntBits(other.valor_compra_item);
	}

	@Override
	public String toString() {
		return "Detalle_Compras [item_compra=" + item_compra + ", fecha_ingreso=" + fecha_ingreso
				+ ", cantidad_comprada=" + cantidad_comprada + ", valor_compra_item=" + valor_compra_item
				+ ", producto=" + producto + ", proveedor=" + proveedor + ", numero_factura_proveedor="
				+ numero_factura_proveedor + "]";
	}
	
}
