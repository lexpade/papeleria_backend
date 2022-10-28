package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.fenix.papeleria.model.Proveedores;

public interface ProveedoresService {
	public List<Proveedores> findAll();
	public Optional<Proveedores> findById(String id_proveedor);
	public Proveedores save(Proveedores proveedor);
	public void deleteById(String id_proveedor);
	
}
