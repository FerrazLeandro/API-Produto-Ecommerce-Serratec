package org.br.serratec.domain;

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

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_produto")
	@ApiModelProperty(value="Identificador único do prodto")
	private Long id;
	
	@NotBlank
	@Column(name = "nome", length = 30, unique = true)
	@ApiModelProperty(value="Nome do produto", required = true)
	private String nome;
	
	@Column(name = "descricao", length = 200)
	@ApiModelProperty(value="Descrição do produto")
	private String descricao;
	
	@Column(name = "qtd_estoque")
	@ApiModelProperty(value="Quantidade em estoque do produto")
	private Integer qtdEstoque;
	
	@Column(name = "data_cadastro")
	@ApiModelProperty(value="Data de cadastro do prodto")
	private LocalDate dataCadastro;
	
	@NotNull
	@Column(name = "valor_unitario")
	@ApiModelProperty(value="Valor unitário do produto", required = true)
	private Double valorUnitario;
	
	@NotNull(message = "A categoria não pode ser nula")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria", nullable = false)
	@ApiModelProperty(value="Identificador único da categoria", required = true)
	private Categoria categoria;

	
	
	@Override
	public String toString() {
		return "Produto Id: " + id + "\nNome:" + nome ;
			
	}

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
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}
	
	
	
}

