package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenix.papeleria.model.Detalle_Compras;
import com.fenix.papeleria.repository.Detalle_ComprasRepository;

@Service
public class Detalle_ComprasServiceImpl implements Detalle_ComprasService {
	@Autowired
	private Detalle_ComprasRepository detalle_compraRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Detalle_Compras> findAll() {
		return detalle_compraRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Detalle_Compras> findById(int item_compra) {
		return detalle_compraRepository.findById(item_compra);
	}

	@Override
	@Transactional
	public Detalle_Compras save(Detalle_Compras detalle_compra) {
		return detalle_compraRepository.save(detalle_compra);
	}

	@Override
	@Transactional
	public void deleteById(int item_compra) {
		detalle_compraRepository.deleteById(item_compra);
	}

}
