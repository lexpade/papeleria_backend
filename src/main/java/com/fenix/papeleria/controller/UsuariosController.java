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

import com.fenix.papeleria.model.Usuarios;
import com.fenix.papeleria.service.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuarios usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<?> read(@PathVariable int id_usuario){
		Optional<Usuarios> usuario = usuarioService.findById(id_usuario);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id_usuario}")
	public ResponseEntity<?> update(@RequestBody Usuarios usuarioDetalle, @PathVariable int id_usuario){
		Optional<Usuarios> usuario = usuarioService.findById(id_usuario);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(usuarioDetalle, usuario.get());
		usuario.get().setId_usuarios(id_usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
	}
	
	@DeleteMapping("/{id_usuario}")
	public ResponseEntity<?> delete(@PathVariable int id_usuario){
		Optional<Usuarios> usuario = usuarioService.findById(id_usuario);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		usuarioService.deleteById(id_usuario);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Usuarios> readAll(){
		List<Usuarios> usuarios = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return usuarios;
	}

}
