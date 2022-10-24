package org.br.serratec.dto;

import java.time.LocalDate;
import java.util.List;

import org.br.serratec.domain.Produto;

import io.swagger.annotations.ApiModelProperty;

public class RelatorioPedidoDto {

	private Long id;
	private Double valorTotal;

	@ApiModelProperty(value = "Data do pedido", required = true)
	private LocalDate dataPedido;


	private List<Produto> produto;


	public RelatorioPedidoDto(Long id, Double valorTotal, LocalDate dataPedido, List<Produto> produto) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.dataPedido = dataPedido;
		this.produto = produto;
	}


	public RelatorioPedidoDto() {
		super();
	}


	@Override
	public String toString() {
		return "RelatorioPedidoDto [id=" + id + ", valorTotal=" + valorTotal + ", dataPedido=" + dataPedido
				+ ", produto=" + produto + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public LocalDate getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}



}