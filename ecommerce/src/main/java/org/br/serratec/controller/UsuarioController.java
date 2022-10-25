package org.br.serratec.controller;

import java.net.URI;
import java.util.List;

import org.br.serratec.dto.UsuarioDto;
import org.br.serratec.dto.UsuarioInserirDto;
import org.br.serratec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
   @GetMapping
   public ResponseEntity<List<UsuarioDto>> listar(){
	   return ResponseEntity.ok(usuarioService.lista());
   }

   @PostMapping
   public ResponseEntity<UsuarioDto> inserir(@RequestBody UsuarioInserirDto usuarioInserirDto) {
       UsuarioDto usuario = usuarioService.inserir(usuarioInserirDto);
       URI uri = ServletUriComponentsBuilder
           .fromCurrentRequest()
           .path("/{id}")
           .buildAndExpand(usuario.getId())
           .toUri();
       return ResponseEntity.created(uri).body(usuario);
   }

}