package org.br.serratec.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.br.serratec.domain.Categoria;

import io.swagger.annotations.ApiModelProperty;

public class ProdutoDto {

	@ApiModelProperty(value = "Identificador único do produto")
	private Long id;

	@ApiModelProperty(value = "Nome do produto", required = true)
	private String nome;


	@ApiModelProperty(value = "Descrição do produto")
	private String descricao;


	@ApiModelProperty(value = "Quantidade em estoque do produto")
	private Integer qtdEstoque;


	@ApiModelProperty(value = "Data de cadastro do prodto")
	private LocalDate dataCadastro;


	@ApiModelProperty(value = "Valor unitário do produto", required = true)
	private Double valorUnitario;


	@ApiModelProperty(value = "Identificador único da categoria", required = true)
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDto other = (ProdutoDto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

}
