package org.br.serratec.dto;

import java.util.Set;

import org.br.serratec.domain.Perfil;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioInserirDto {

	@ApiModelProperty(value = "Nome do usuário")
	private String nome;

	@ApiModelProperty(value = "E-mail do usuário")
	private String email;

	@ApiModelProperty(value = "Senha do usuário")
	private String senha;

	@ApiModelProperty(value = "Confirmação de senha do usuário")
	private String confirmaSenha;

	@ApiModelProperty(value = "Perfis do usuário")
	private Set<Perfil> perfis;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfils(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
}
