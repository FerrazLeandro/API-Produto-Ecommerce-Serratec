package org.br.serratec.service;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.br.serratec.config.MailConfig;
import org.br.serratec.domain.ItemPedido;
import org.br.serratec.domain.Pedido;
import org.br.serratec.domain.Produto;
import org.br.serratec.dto.PedidoDto;
import org.br.serratec.dto.PedidoInserirDto;
import org.br.serratec.dto.PedidoItemInserirDto;
import org.br.serratec.repository.PedidoRepository;
import org.br.serratec.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	MailConfig mailConfig;

	@Autowired
	RelatorioPedidoService relatorioPedidoService;

	public PedidoDto buscar(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			return null;
		}
		return new PedidoDto(pedido.get());
	}

	public Pedido salvar(PedidoInserirDto pedidoInserirDto) {
		Pedido pedido = new Pedido();
		pedido.setDataPedido(LocalDate.now());
		pedido.setDataEntrega(pedidoInserirDto.getDataEntrega());
		pedido.setDataEnvio(pedidoInserirDto.getDataEnvio());
		pedido.setStatus(pedidoInserirDto.getStatus());
		pedido.setCliente(pedidoInserirDto.getCliente());

		List<ItemPedido> pedidoItens = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		Double valorTotal = 0.;

		for (PedidoItemInserirDto pedidoItemInserirDto : pedidoInserirDto.getPedidoItemInserirDto()) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setPedido(pedido);
			itemPedido.setQuantidade(pedidoItemInserirDto.getQuantidade());
			itemPedido.setPercentualDesconto(pedidoItemInserirDto.getPercentualDesconto());

			Optional<Produto> produto = produtoRepository.findById(pedidoItemInserirDto.getProduto().getId());
			itemPedido.setProduto(produto.get());

			itemPedido.setPrecoVenda(produto.get().getValorUnitario());

			Double valorBruto = produto.get().getValorUnitario() * pedidoItemInserirDto.getQuantidade();
			itemPedido.setValorBruto(valorBruto);

			Double valorLiquido = valorBruto - (valorBruto * pedidoItemInserirDto.getPercentualDesconto());
			itemPedido.setValorliquido(valorLiquido);

			valorTotal += valorLiquido;

			pedidoItens.add(itemPedido);
			produtos.add(produto.get());

		}

		pedido.setValorTotal(valorTotal);

		pedido = pedidoRepository.save(pedido);

		relatorioPedidoService.enviarEmail(pedido,pedidoItens);

		return pedido;

	}
}
