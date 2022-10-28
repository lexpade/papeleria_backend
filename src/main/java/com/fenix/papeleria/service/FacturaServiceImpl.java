package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenix.papeleria.model.Factura;
import com.fenix.papeleria.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Factura> findById(int numero_factura) {
		return facturaRepository.findById(numero_factura);
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	@Transactional
	public void deleteById(int numero_factura) {
		facturaRepository.deleteById(numero_factura);
	}

}
