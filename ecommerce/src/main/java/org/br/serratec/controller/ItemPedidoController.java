package org.br.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.br.serratec.domain.ItemPedido;
import org.br.serratec.repository.ItemPedidoRepository;
import org.br.serratec.repository.ItemPedidoRepository;
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
@RequestMapping("/api/itempedido")
public class ItemPedidoController {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@GetMapping
	public ResponseEntity<List<ItemPedido>> buscar() {
		return ResponseEntity.ok(itemPedidoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Long id) {
		Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
		if (!itemPedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(itemPedido.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> atualizar(@PathVariable Long id, @Valid @RequestBody ItemPedido itemPedido) {
		Optional<ItemPedido> itemPedidoBanco = itemPedidoRepository.findById(id);
		if (!itemPedidoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		itemPedido.setId(id);
		itemPedido = itemPedidoRepository.save(itemPedido);
		return ResponseEntity.ok(itemPedido);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<ItemPedido> itemPedidoBanco = itemPedidoRepository.findById(id);
		if (!itemPedidoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		itemPedidoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<ItemPedido> inserir(@Valid @RequestBody ItemPedido itemPedido) {
		itemPedido = itemPedidoRepository.save(itemPedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(itemPedido.getId())
				.toUri();
		return ResponseEntity.created(uri).body(itemPedido);
	}
}