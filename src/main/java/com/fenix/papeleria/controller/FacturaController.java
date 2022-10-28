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

import com.fenix.papeleria.model.Factura;
import com.fenix.papeleria.service.FacturaService;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {
	
	@Autowired
	private FacturaService facturaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Factura factura){
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
	}

	@GetMapping("/{numero_factura}")
	public ResponseEntity<?> read(@PathVariable int numero_factura){
		Optional<Factura> factura = facturaService.findById(numero_factura);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(factura);
	}
	
	@PutMapping("/{numero_factura}")
	public ResponseEntity<?> update(@RequestBody Factura facturaDetalle, @PathVariable int numero_factura){
		Optional<Factura> factura = facturaService.findById(numero_factura);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(facturaDetalle, factura.get());
		factura.get().setNumero_factura(numero_factura);
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura.get()));
	}
	
	@DeleteMapping("/{numero_factura}")
	public ResponseEntity<?> delete(@PathVariable int numero_factura){
		Optional<Factura> factura = facturaService.findById(numero_factura);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		facturaService.deleteById(numero_factura);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Factura> readAll(){
		List<Factura> facturas = StreamSupport
				.stream(facturaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return facturas;
	}

}
