package org.br.serratec.service;

import java.util.Optional;

import org.br.serratec.domain.Endereco;
import org.br.serratec.dto.EnderecoDto;
import org.br.serratec.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoDto buscar(String cep) {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "http://viacep.com.br/ws/" + cep + "/json";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				return new EnderecoDto(enderecoViaCep.get());
			} else {
				return null;
			}
	}

	private EnderecoDto inserir(Endereco endereco) {
		return new EnderecoDto(enderecoRepository.save(endereco));
	}
}
