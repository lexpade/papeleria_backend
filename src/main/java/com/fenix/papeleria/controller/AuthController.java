package com.fenix.papeleria.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fenix.papeleria.util.JWTUtil;
import com.fenix.papeleria.model.Usuarios;
import com.fenix.papeleria.service.UsuariosService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping
	public ResponseEntity<?> createtoken(@RequestBody Usuarios usuarioDetalle){
		List<Usuarios> usuario = usuariosService.findAdminById(usuarioDetalle.getId_usuarios());
		if(usuario!=null && usuario.size() >0) {
			String tokenJwt = jwtUtil.getJWTToken(usuario.get(0).getTelefono_usuario()+"");
            return ResponseEntity.ok(new JSONObject().put("access", tokenJwt.replace("Bearer ", "")).toString());
            	
			/* String tokenJwt = jwtUtil.getJWTToken(persona.get(0).getNumeroDocumento()+"");
            return ResponseEntity.ok(tokenJwt); -replaced by two lines before-*/
		} 
		return ResponseEntity.notFound().build();
	}
}
