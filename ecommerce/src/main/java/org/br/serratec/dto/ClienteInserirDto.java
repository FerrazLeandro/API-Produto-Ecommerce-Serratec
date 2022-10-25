package org.br.serratec.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

public class ClienteInserirDto {
	@ApiModelProperty(value="Identificador único do cliente")
	private Long id;
	@ApiModelProperty(value="Nome completo do cliente")
	private String nomeCompleto;
	@ApiModelProperty(value="E-mail do cliente")
	private String email;
	@ApiModelProperty(value="CPF do cliente")
	private String cpf;
	@ApiModelProperty(value="Telefone do cliente")
	private String telefone;
	@ApiModelProperty(value="Data de nascimento do cliente")
	private LocalDate dataNascimento;
	@ApiModelProperty(value="CEP do cliente")
	private String cep;
	@ApiModelProperty(value="Número do endereço do cliente")
	private String numero;
	
	public ClienteInserirDto() {
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Long getId() {
		return id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public String getCep() {
		return cep;
	}
	public String getNumero() {
		return numero;
	}
	
	
}
