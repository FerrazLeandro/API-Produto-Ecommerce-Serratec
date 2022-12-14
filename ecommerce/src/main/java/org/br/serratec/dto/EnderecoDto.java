package org.br.serratec.dto;

import javax.validation.constraints.NotBlank;

import org.br.serratec.domain.Endereco;

public class EnderecoDto {
	@NotBlank(message = "o CEP não pode ser nulo")
	private String cep;
	
	@NotBlank(message = "o logradouto não pode ser nulo")
	private String logradouro;
	
	@NotBlank(message = "o complemento não pode ser nulo")
	private String complemento;
	
	@NotBlank(message = "o bairro não pode ser nulo")
	private String bairro;
	
	@NotBlank(message = "A cidade não pode ser nula")
	private String localidade;
	
	@NotBlank(message = "A uf não pode ser nula")
	private String uf;

	public EnderecoDto(Endereco endereco) {
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.localidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
	}
	
	

	@Override
	public String toString() {
		return "EnderecoDto [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
				+ bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}



	public EnderecoDto() {
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}



}
