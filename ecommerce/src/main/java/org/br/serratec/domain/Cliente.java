package org.br.serratec.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_cliente")
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(name = "nome_completo", length = 50)
	private String nomeCompleto;
	
	@NotNull
	@NotBlank
	@Email
	@Column(name = "email", length = 80, unique = true)
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name = "cpf", length = 11, unique = true)
	private String cpf;
	
	@NotNull
	@NotBlank
	@Column(name = "telefone", length = 40)
	private String telefone;
	
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@NotNull
	@NotBlank
	@JoinColumn(name = "id_endereco", nullable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}