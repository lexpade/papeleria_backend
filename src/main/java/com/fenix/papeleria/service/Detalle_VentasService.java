package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.fenix.papeleria.model.Detalle_Ventas;

public interface Detalle_VentasService {
	public List<Detalle_Ventas> findAll();
	public Optional<Detalle_Ventas> findById(int item_venta);
	public Detalle_Ventas save(Detalle_Ventas detalle_venta);
	public void deleteById(int item_venta);

}
