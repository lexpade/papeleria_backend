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

import com.fenix.papeleria.model.Detalle_Compras;
import com.fenix.papeleria.service.Detalle_ComprasService;

@RestController
@RequestMapping("/api/detalle_compras")
public class Detalle_ComprasController {
	
	@Autowired
	private Detalle_ComprasService detalle_compraService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Detalle_Compras detalle_compra){
		return ResponseEntity.status(HttpStatus.CREATED).body(detalle_compraService.save(detalle_compra));
	}

	@GetMapping("/{item_compra}")
	public ResponseEntity<?> read(@PathVariable int item_compra){
		Optional<Detalle_Compras> detalle_compra = detalle_compraService.findById(item_compra);
		if(!detalle_compra.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(detalle_compra);
	}
	
	@PutMapping("/{item_compra}")
	public ResponseEntity<?> update(@RequestBody Detalle_Compras detalle_compraDetalle, @PathVariable int item_compra){
		Optional<Detalle_Compras> detalle_compra = detalle_compraService.findById(item_compra);
		if(!detalle_compra.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(detalle_compraDetalle, detalle_compra.get());
		detalle_compra.get().setItem_compra(item_compra);
		return ResponseEntity.status(HttpStatus.CREATED).body(detalle_compraService.save(detalle_compra.get()));
	}
	
	@DeleteMapping("/{item_compra}")
	public ResponseEntity<?> delete(@PathVariable int item_compra){
		Optional<Detalle_Compras> detalle_compra = detalle_compraService.findById(item_compra);
		if(!detalle_compra.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		detalle_compraService.deleteById(item_compra);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Detalle_Compras> readAll(){
		List<Detalle_Compras> detalles_compra = StreamSupport
				.stream(detalle_compraService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return detalles_compra;
	}

}
