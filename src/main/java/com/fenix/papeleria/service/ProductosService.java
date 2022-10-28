package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.fenix.papeleria.model.Productos;

public interface ProductosService {
	public List<Productos> findAll();
	public Optional<Productos> findById(int codigo_producto);
	public Productos save(Productos producto);
	public void deleteById(int codigo_producto);

}
