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

import com.fenix.papeleria.model.Proveedores;
import com.fenix.papeleria.service.ProveedoresService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {
	
	@Autowired
	private ProveedoresService proveedorService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proveedores proveedor){
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor));
	}

	@GetMapping("/{id_proveedor}")
	public ResponseEntity<?> read(@PathVariable String id_proveedor){
		Optional<Proveedores> proveedor = proveedorService.findById(id_proveedor);
		if(!proveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(proveedor);
	}
	
	@PutMapping("/{id_proveedor}")
	public ResponseEntity<?> update(@RequestBody Proveedores proveedorDetalle, @PathVariable String id_proveedor){
		Optional<Proveedores> proveedor = proveedorService.findById(id_proveedor);
		if(!proveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(proveedorDetalle, proveedor.get());
		proveedor.get().setId_proveedor(id_proveedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor.get()));
	}
	
	@DeleteMapping("/{id_proveedor}")
	public ResponseEntity<?> delete(@PathVariable String id_proveedor){
		Optional<Proveedores> proveedor = proveedorService.findById(id_proveedor);
		if(!proveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		proveedorService.deleteById(id_proveedor);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Proveedores> readAll(){
		List<Proveedores> proveedores = StreamSupport
				.stream(proveedorService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return proveedores;
	}

}
