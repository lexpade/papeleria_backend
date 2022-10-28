package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenix.papeleria.model.Productos;
import com.fenix.papeleria.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
	private ProductosRepository productoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Productos> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Productos> findById(int codigo_producto) {
		return productoRepository.findById(codigo_producto);
	}

	@Override
	@Transactional
	public Productos save(Productos producto) {
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(int codigo_producto) {
		productoRepository.deleteById(codigo_producto);
	}

}
