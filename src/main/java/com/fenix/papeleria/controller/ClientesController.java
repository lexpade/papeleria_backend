package com.fenix.papeleria.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fenix.papeleria.model.Clientes;
import com.fenix.papeleria.service.ClientesService;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesService clienteService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Clientes cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

	@GetMapping("/{id_cliente}")
	public ResponseEntity<?> read(@PathVariable int id_cliente){
		Optional<Clientes> cliente = clienteService.findById(id_cliente);
		if(!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/{id_cliente}")
	public ResponseEntity<?> update(@RequestBody Clientes clienteDetalle, @PathVariable int id_cliente){
		Optional<Clientes> cliente = clienteService.findById(id_cliente);
		if(!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(clienteDetalle, cliente.get());
		cliente.get().setId_cliente(id_cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));
	}
	
	@DeleteMapping("/{id_cliente}")
	public ResponseEntity<?> delete(@PathVariable int id_cliente){
		Optional<Clientes> cliente = clienteService.findById(id_cliente);
		if(!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		clienteService.deleteById(id_cliente);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Clientes> readAll(){
		List<Clientes> clientes = StreamSupport
				.stream(clienteService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return clientes;
	}

}
