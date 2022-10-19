package org.br.serratec.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_endereco")
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(name = "cep", length = 8)
	private String cep;
	
	@NotNull
	@NotBlank
	@Column(name = "rua", length = 80)
	private String rua;
	
	@NotNull
	@NotBlank
	@Column(name = "bairro", length = 50)
	private String bairro;
	
	@NotNull
	@NotBlank
	@Column(name = "cidade", length = 80)
	private String cidade;
	
	@NotNull
	@NotBlank
	@Column(name = "numero", length = 20)
	private String numero;
	
	@NotNull
	@NotBlank
	@Column(name = "complemento", length = 60)
	private String complemento;
	
	@NotNull
	@NotBlank
	@Column(name = "uf", length = 2)
	private String uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
