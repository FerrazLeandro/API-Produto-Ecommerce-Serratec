package org.br.serratec.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.br.serratec.domain.Cliente;

import io.swagger.annotations.ApiModelProperty;

public class PedidoInserirDto {

	@ApiModelProperty(value = "Data do pedido")
	private LocalDate dataPedido;

	@NotNull(message = "A data da entrega não pode ser nula")
	@ApiModelProperty(value = "Data de entrega")
	private LocalDate dataEntrega;

	@NotNull(message = "A data do envio não pode ser nula")
	@ApiModelProperty(value = "Data de envio do pedido")
	private LocalDate dataEnvio;

	@NotBlank(message = "O status não pode ser em branco")
	@NotNull(message = "O status pedido não pode ser nula")
	private String status;
	
	@NotNull(message= "O cliente não pode ser nulo")
	@ApiModelProperty(value="Identificado único do cliente")
	private Cliente cliente;

	@NotNull(message = "O item pedido não pode ser nulo")
	private List<PedidoItemInserirDto> pedidoItemInserirDto;

	public PedidoInserirDto() {
	}

	public List<PedidoItemInserirDto> getPedidoItemInserirDto() {
		return pedidoItemInserirDto;
	}

	public void setPedidoItemInserirDto(List<PedidoItemInserirDto> pedidoItemInserirDto) {
		this.pedidoItemInserirDto = pedidoItemInserirDto;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
