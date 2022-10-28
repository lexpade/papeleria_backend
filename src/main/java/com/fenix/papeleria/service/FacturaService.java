package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.fenix.papeleria.model.Factura;

public interface FacturaService {
	public List<Factura> findAll();
	public Optional<Factura> findById(int numero_factura);
	public Factura save(Factura factura);
	public void deleteById(int numero_factura);

}
