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

import com.fenix.papeleria.model.Detalle_Ventas;
import com.fenix.papeleria.service.Detalle_VentasService;

@RestController
@RequestMapping("/api/detalle_ventas")
public class Detalle_VentasController {
	
	@Autowired
	private Detalle_VentasService detalle_ventaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Detalle_Ventas detalle_venta){
		return ResponseEntity.status(HttpStatus.CREATED).body(detalle_ventaService.save(detalle_venta));
	}

	@GetMapping("/{item_venta}")
	public ResponseEntity<?> read(@PathVariable int item_venta){
		Optional<Detalle_Ventas> detalle_venta = detalle_ventaService.findById(item_venta);
		if(!detalle_venta.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(detalle_venta);
	}
	
	@PutMapping("/{item_venta}")
	public ResponseEntity<?> update(@RequestBody Detalle_Ventas detalle_ventaDetalle, @PathVariable int item_venta){
		Optional<Detalle_Ventas> detalle_venta = detalle_ventaService.findById(item_venta);
		if(!detalle_venta.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(detalle_ventaDetalle, detalle_venta.get());
		detalle_venta.get().setItem_venta(item_venta);
		return ResponseEntity.status(HttpStatus.CREATED).body(detalle_ventaService.save(detalle_venta.get()));
	}
	
	@DeleteMapping("/{item_venta}")
	public ResponseEntity<?> delete(@PathVariable int item_venta){
		Optional<Detalle_Ventas> detalle_venta = detalle_ventaService.findById(item_venta);
		if(!detalle_venta.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		detalle_ventaService.deleteById(item_venta);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Detalle_Ventas> readAll(){
		List<Detalle_Ventas> detalles_venta = StreamSupport
				.stream(detalle_ventaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return detalles_venta;
	}

}
