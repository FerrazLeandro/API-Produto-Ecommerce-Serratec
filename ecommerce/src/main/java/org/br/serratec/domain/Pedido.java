package org.br.serratec.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	@ApiModelProperty(value = "Identificador único do pedido")
	private Long id;

	@NotNull(message = "A data do pedido não pode ser nula")
	@Column(name = "data_pedido")
	@ApiModelProperty(value = "Data do pedido", required = true)
	private LocalDate dataPedido;

	@NotNull(message = "A data da entrega não pode ser nula")
	@Column(name = "data_entrega")
	@ApiModelProperty(value = "Data de entrega")
	private LocalDate dataEntrega;

	@NotNull(message = "A data do envio não pode ser nula")
	@Column(name = "data_envio")
	@ApiModelProperty(value = "Data do envio do pedido")
	private LocalDate dataEnvio;

	@NotBlank(message = "O status não pode ser em branco")
	@NotNull(message = "O status pedido não pode ser nula")
	@Column(name = "status", length = 1)
	private String status;

	@NotNull(message = "A valor total não pode ser nulo")
	@Column(name = "valor_total")
	@ApiModelProperty(value = "Valor total do pedido", required = true)
	private Double valorTotal;

	@NotNull(message = "O cliente não pode ser nulo")
	@JoinColumn(name = "id_cliente", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@ApiModelProperty(value = "Identificado único do cliente")
	private Cliente cliente;

	@Override
	public String toString() {
		return "Pedido: " + id + "\nData do Pedido: " + dataPedido + "\nData da Entrega: " + dataEntrega
				+ "\nData do Envio: " + dataEnvio + "\nStatus: " + status + "\nValor Total: " + valorTotal
				+ "\nCliente: " + cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
