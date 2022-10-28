package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.fenix.papeleria.model.Detalle_Compras;

public interface Detalle_ComprasService {
	public List<Detalle_Compras> findAll();
	public Optional<Detalle_Compras> findById(int item_compra);
	public Detalle_Compras save(Detalle_Compras detalle_compra);
	public void deleteById(int item_compra);

}
