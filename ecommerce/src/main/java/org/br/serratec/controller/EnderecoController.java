package org.br.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.br.serratec.domain.Endereco;
import org.br.serratec.repository.EnderecoRepository;
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
@RequestMapping("/api/endereco")
public class EnderecoController {

	@Autowired
	EnderecoRepository enderecoRepository;

	@GetMapping
	public ResponseEntity<List<Endereco>> buscar() {
		return ResponseEntity.ok(enderecoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if (!endereco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(endereco.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @Valid @RequestBody Endereco endereco) {
		Optional<Endereco> enderecoBanco = enderecoRepository.findById(id);
		if (!enderecoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		endereco.setId(id);
		endereco = enderecoRepository.save(endereco);
		return ResponseEntity.ok(endereco);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Endereco> enderecoBanco = enderecoRepository.findById(id);
		if (!enderecoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		enderecoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Endereco> inserir(@Valid @RequestBody Endereco endereco) {
		endereco = enderecoRepository.save(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId())
				.toUri();
		return ResponseEntity.created(uri).body(endereco);
	}
}