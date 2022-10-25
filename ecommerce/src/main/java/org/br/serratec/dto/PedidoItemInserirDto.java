package org.br.serratec.dto;

import javax.validation.constraints.NotNull;

import org.br.serratec.domain.Produto;

import io.swagger.annotations.ApiModelProperty;

public class PedidoItemInserirDto {
	
	@NotNull(message= "A quantidade não pode ser nula")
	@ApiModelProperty(value="Quantidade item pedido")
	private Integer quantidade;
	
	@NotNull(message= "A percentual não pode ser nula")
	@ApiModelProperty(value="Percentual de desconto do pedido")
	private Double percentualDesconto;
	
	@NotNull(message= "O Produto não pode ser nula")
	private Produto produto;
	
	
	public PedidoItemInserirDto() {
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPercentualDesconto() {
		return percentualDesconto;
	}
	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
