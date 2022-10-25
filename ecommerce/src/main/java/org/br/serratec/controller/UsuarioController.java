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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
   @GetMapping
   @ApiOperation(value = "Retorna a lista de usuários", notes = "Usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um produto"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
   public ResponseEntity<List<UsuarioDto>> listar(){
	   return ResponseEntity.ok(usuarioService.lista());
   }

   @PostMapping
   @ApiOperation(value = "Insere um usuário", notes = "Cadastro de usuário")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuário cadastrado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
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