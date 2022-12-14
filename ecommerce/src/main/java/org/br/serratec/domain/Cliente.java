package org.br.serratec.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.br.serratec.dto.ClienteInserirDto;
import org.br.serratec.dto.EnderecoDto;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_cliente")
	@ApiModelProperty(value="Identificador único do cliente")

	private Long id;
	
	@NotBlank
	@Column(name = "nome_completo", length = 50)
	@ApiModelProperty(value="Nome completo do cliente", required = true)

	private String nomeCompleto;
	
	@NotBlank
	@Email
	@Column(name = "email", length = 80, unique = true)
	@ApiModelProperty(value="E-mail do cliente", required = true)
	private String email;
	
	@NotBlank
	@Column(name = "cpf", length = 11, unique = true)
	@ApiModelProperty(value="CPF do cliente", required = true)
	private String cpf;
	
	
	@NotBlank
	@Column(name = "telefone", length = 40)
	@ApiModelProperty(value="Telefone do cliente", required = true)
	private String telefone;
	
	
	@Column(name = "data_nascimento")
	@ApiModelProperty(value="Data de nascimento do cliente")
	private LocalDate dataNascimento;
	
	@NotNull(message = "O endereco não pode ser nulo")
	@JoinColumn(name = "id_endereco")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ApiModelProperty(value="Endereço do cliente", required = true)
	private Endereco endereco;

	
	
	@Override
	public String toString() {
		return "Nome Completo: " + nomeCompleto + "\nEmail: " + email + "\n CPF: " + cpf
				+ "\nTelefone: " + telefone + "\nData de Nascimento: " + dataNascimento + "\nEndereço: " + endereco;
	}

	public Cliente(ClienteInserirDto clienteInserir, EnderecoDto enderecoDto) {
		this.nomeCompleto = clienteInserir.getNomeCompleto();
		this.cpf = clienteInserir.getCpf();
		this.dataNascimento = clienteInserir.getDataNascimento();
		this.email = clienteInserir.getEmail();
		this.telefone = clienteInserir.getTelefone();
		this.endereco = new Endereco(enderecoDto);
		this.endereco.setNumero(clienteInserir.getNumero());
	}
	
	public Cliente() {
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(email, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}
	
	
	
	
}
