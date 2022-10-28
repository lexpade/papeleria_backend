package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenix.papeleria.model.Clientes;
import com.fenix.papeleria.repository.ClientesRepository;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	private ClientesRepository clienteRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Clientes> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Clientes> findById(int id_cliente) {
		return clienteRepository.findById(id_cliente);
	}

	@Override
	@Transactional
	public Clientes save(Clientes cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(int id_cliente) {
		clienteRepository.deleteById(id_cliente);
	}

}
