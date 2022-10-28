package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenix.papeleria.model.Proveedores;
import com.fenix.papeleria.repository.ProveedoresRepository;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
	@Autowired
	private ProveedoresRepository proveedorRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Proveedores> findAll() {
		return proveedorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedores> findById(String id_proveedor) {
		return proveedorRepository.findById(id_proveedor);
	}

	@Override
	@Transactional
	public Proveedores save(Proveedores proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	@Transactional
	public void deleteById(String id_proveedor) {
		proveedorRepository.deleteById(id_proveedor);
	}

}
