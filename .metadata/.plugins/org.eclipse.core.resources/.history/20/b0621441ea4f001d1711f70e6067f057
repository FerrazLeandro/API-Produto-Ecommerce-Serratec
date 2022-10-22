package org.br.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscar() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (!categoria.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria.get());
	}

	@PutMapping("/{id}")
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
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Categoria> categoriaBanco = categoriaRepository.findById(id);
		if (!categoriaBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		categoriaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria) {
		categoria = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
}
