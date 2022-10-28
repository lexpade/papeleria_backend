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

import com.fenix.papeleria.model.Productos;
import com.fenix.papeleria.service.ProductosService;
@RestController
@RequestMapping("/api/productos")
public class ProductosController {
	
	@Autowired
	private ProductosService productoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Productos producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
	}

	@GetMapping("/{codigo_producto}")
	public ResponseEntity<?> read(@PathVariable int codigo_producto){
		Optional<Productos> producto = productoService.findById(codigo_producto);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/{codigo_producto}")
	public ResponseEntity<?> update(@RequestBody Productos productoDetalle, @PathVariable int codigo_producto){
		Optional<Productos> producto = productoService.findById(codigo_producto);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(productoDetalle, producto.get());
		producto.get().setCodigo_producto(codigo_producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
	}
	
	@DeleteMapping("/{codigo_producto}")
	public ResponseEntity<?> delete(@PathVariable int codigo_producto){
		Optional<Productos> producto = productoService.findById(codigo_producto);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		productoService.deleteById(codigo_producto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Productos> readAll(){
		List<Productos> productos = StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return productos;
	}

}
