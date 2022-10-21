package org.br.serratec.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.br.serratec.domain.Cliente;
import org.br.serratec.dto.ClienteDto;
import org.br.serratec.dto.ClienteInserirDto;
import org.br.serratec.repository.ClienteRepository;
import org.br.serratec.service.ClienteService;
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

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> buscar() {
		return ResponseEntity.ok(clienteService.lista());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscar(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Optional<Cliente> clienteBanco = clienteRepository.findById(id);
		if (!clienteBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Cliente> clienteBanco = clienteRepository.findById(id);
		if (!clienteBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<ResponseEntity<Cliente>> inserir(@Valid @RequestBody ClienteInserirDto clienteInserirDto) {
		return ResponseEntity.ok(clienteService.salvar(clienteInserirDto));
	}
}
