package org.br.serratec.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	@ApiOperation(value="Lista todos os clientes", notes="Listagem de clientes")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna todos os clientes"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
    public ResponseEntity<List<Cliente>> buscar() {
        List<Cliente> cliente = clienteService.lista();
        return ResponseEntity.ok(cliente);
    }

	@GetMapping("/{id}")
	@ApiOperation(value="Retorna um cliente", notes="Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna um cliente"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.buscar(id);
        if (null != cliente) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }
	
	
	@PostMapping
	@ApiOperation(value="Insere os dados de um cliente", notes="Inserir Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=201, message="Cliente adicionado"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody ClienteInserirDto clienteInserirDto) {
		Cliente cliente = clienteService.salvar(clienteInserirDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).body(cliente);
	}

	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza dados de um cliente", notes="Atualizar Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Cliente atualizado"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
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
	@ApiOperation(value="Remove um cliente", notes="Remover Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Cliente removido"),
	@ApiResponse(code=204, message="Sem conteúdo"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Cliente> clienteBanco = clienteRepository.findById(id);
		if (!clienteBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	
}
