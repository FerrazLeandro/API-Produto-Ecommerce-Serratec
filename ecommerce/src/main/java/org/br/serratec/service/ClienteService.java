package org.br.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.br.serratec.domain.Cliente;
import org.br.serratec.dto.ClienteDto;
import org.br.serratec.dto.ClienteInserirDto;
import org.br.serratec.dto.EnderecoDto;
import org.br.serratec.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	
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

	public Cliente salvar(ClienteInserirDto clienteInserir) {
		EnderecoDto enderecoDto = enderecoService.buscar(clienteInserir.getCep());
		Cliente cliente = new Cliente(
					clienteInserir, enderecoDto
				);
		cliente = clienteRepository.save(cliente);
		return cliente;
		
	}
	
	
}
