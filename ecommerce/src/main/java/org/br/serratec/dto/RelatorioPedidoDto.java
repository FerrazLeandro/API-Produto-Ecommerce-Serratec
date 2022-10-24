package org.br.serratec.dto;

import java.time.LocalDate;
import java.util.List;

import org.br.serratec.domain.ItemPedido;

import io.swagger.annotations.ApiModelProperty;

public class RelatorioPedidoDto {

	private Long id;
	private Double valorTotal;

	@ApiModelProperty(value = "Data do pedido", required = true)
	private LocalDate dataPedido;

	private List<ItemPedido> itemPedido;

	private Double precoVenda;
	private Integer quantidade;
	private Double valorBruto;
	private Double percentualDesconto;
	private Double valorLiquido;

	public RelatorioPedidoDto(Long id, Double valorTotal, LocalDate dataPedido, List<ItemPedido> itemPedido,
			Double precoVenda, Integer quantidade, Double valorBruto, Double percentualDesconto, Double valorLiquido) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.dataPedido = dataPedido;
		this.itemPedido = itemPedido;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.valorBruto = valorBruto;
		this.percentualDesconto = percentualDesconto;
		this.valorLiquido = valorLiquido;
	}

	public RelatorioPedidoDto() {
		super();
	}

	@Override
	public String toString() {
		return "Pedido:\nId: " + id + "\nValor Total: " + valorTotal + "\nData Pedido: " + dataPedido + "\n" + itemPedido;
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

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public void setProduto(List<ItemPedido> itemPedido2) {
		// TODO Auto-generated method stub
		
	}
}