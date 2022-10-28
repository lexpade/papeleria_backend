package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenix.papeleria.model.Detalle_Ventas;
import com.fenix.papeleria.repository.Detalle_VentasRepository;

@Service
public class Detalle_VentasServiceImpl implements Detalle_VentasService {
	@Autowired
	private Detalle_VentasRepository detalle_ventaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Detalle_Ventas> findAll() {
		return detalle_ventaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Detalle_Ventas> findById(int item_venta) {
		return detalle_ventaRepository.findById(item_venta);
	}

	@Override
	@Transactional
	public Detalle_Ventas save(Detalle_Ventas detalle_venta) {
		return detalle_ventaRepository.save(detalle_venta);
	}

	@Override
	@Transactional
	public void deleteById(int item_venta) {
		detalle_ventaRepository.deleteById(item_venta);
	}

}
