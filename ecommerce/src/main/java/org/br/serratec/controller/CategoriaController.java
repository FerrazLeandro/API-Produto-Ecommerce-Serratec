package org.br.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.br.serratec.config.MailConfig;
import org.br.serratec.domain.Categoria;
import org.br.serratec.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	private MailConfig mailConfig;

	@GetMapping
	@ApiOperation(value = "Lista todas as categorias", notes = "Listagem de categorias")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todas as categorias"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Categoria>> buscar() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma categoria pelo id", notes = "Categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma categoria"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (!categoria.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria.get());
	}

	@PostMapping
	@ApiOperation(value = "Insere os dados de uma categoria", notes = "Inserir categoria")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Categoria adicionada"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria) {
		categoria = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();
		//TODO Colocar o email do usuário
		mailConfig.sendMail("leandro_ferraz@outlook.com", 
				"Ecommerce - Categoria cadastrada com sucesso!", 
				categoria.toString());
		return ResponseEntity.created(uri).body(categoria);
	}

	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza dados de uma categoria pelo id", notes="Atualizar Categoria")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Categoria atualizada"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
		Optional<Categoria> categoriaBanco = categoriaRepository.findById(id);
		if (!categoriaBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		categoria.setId(id);
		categoria = categoriaRepository.save(categoria);
		return ResponseEntity.ok(categoria);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value="Remove uma categoria pelo id", notes="Remover Categoria")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Categoria removida"),
	@ApiResponse(code=204, message="Sem conteúdo"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Categoria> categoriaBanco = categoriaRepository.findById(id);
		if (!categoriaBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		categoriaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
