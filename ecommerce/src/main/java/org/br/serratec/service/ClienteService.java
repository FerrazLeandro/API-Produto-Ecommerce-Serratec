package org.br.serratec.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.br.serratec.domain.Cliente;
import org.br.serratec.dto.ClienteDto;
import org.br.serratec.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<ClienteDto> lista() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDto> clientesDto = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            clientesDto.add(new ClienteDto(cliente));

        }
        return clientesDto;
    }

	public ClienteDto buscar(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return null;
		}
		return new ClienteDto(cliente.get());
	}

	public ResponseEntity<Cliente> salvar(Cliente cliente) {
		cliente = clienteRepository.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	
}