package com.fenix.papeleria.service;

import com.fenix.papeleria.model.Clientes;
import java.util.List;
import java.util.Optional;

public interface ClientesService {
	public List<Clientes> findAll();
	public Optional<Clientes> findById(int id_cliente);
	public Clientes save(Clientes cliente);
	public void deleteById(int id_cliente);

}
