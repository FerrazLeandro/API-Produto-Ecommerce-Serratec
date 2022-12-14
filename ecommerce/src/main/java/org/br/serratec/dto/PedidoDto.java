package org.br.serratec.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.br.serratec.domain.Cliente;
import org.br.serratec.domain.ItemPedido;
import org.br.serratec.domain.Pedido;

import io.swagger.annotations.ApiModelProperty;

public class PedidoDto {
	
	@NotNull
	@ApiModelProperty(value="Data do pedido", required = true)
	private LocalDate dataPedido;
	
	@ApiModelProperty(value="Data de entrega")
	private LocalDate dataEntrega;
	
	@ApiModelProperty(value="Data do pedido")
	private LocalDate dataEnvio;
	
	@NotBlank
	private String status;
	
	@NotNull
	@ApiModelProperty(value="Identificador único do cliente")
	private Cliente cliente;
	
	@NotNull
	private ItemPedido itemPedido;
	
	
	public PedidoDto(Pedido pedido) {
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.cliente = cliente;
		this.itemPedido = itemPedido;
	}
	
	public PedidoDto() {
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	
}
