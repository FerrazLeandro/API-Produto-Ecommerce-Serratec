package org.br.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.br.serratec.config.MailConfig;
import org.br.serratec.domain.Pedido;
import org.br.serratec.dto.PedidoInserirDto;
import org.br.serratec.repository.PedidoRepository;
import org.br.serratec.service.PedidoService;
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
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PedidoService pedidoService;

	@GetMapping
	@ApiOperation(value = "Lista todos os pedidos", notes = "Listagem de pedidos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Pedido>> buscar() {
		return ResponseEntity.ok(pedidoRepository.findAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um pedido", notes = "Pedido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pedido.get());
	}

	@PostMapping
	@ApiOperation(value = "Insere os dados de um pedido", notes = "Inserir pedido")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Pedido adicionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Pedido> inserir(@Valid @RequestBody PedidoInserirDto pedidoInserirDto) {
		Pedido pedido = pedidoService.salvar(pedidoInserirDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();

		return ResponseEntity.created(uri).body(pedido);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza dados de um pedido", notes = "Atualizar pedido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pedido atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
		Optional<Pedido> pedidoBanco = pedidoRepository.findById(id);
		if (!pedidoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pedido.setId(id);
		pedido = pedidoRepository.save(pedido);
		return ResponseEntity.ok(pedido);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um pedido", notes = "Remover pedido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pedido removido"),
			@ApiResponse(code = 204, message = "Sem conteúdo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Pedido> pedidoBanco = pedidoRepository.findById(id);
		if (!pedidoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pedidoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
