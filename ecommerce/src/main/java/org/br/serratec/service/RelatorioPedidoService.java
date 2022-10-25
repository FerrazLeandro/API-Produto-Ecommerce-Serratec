package org.br.serratec.service;

import java.util.List;

import org.br.serratec.config.MailConfig;
import org.br.serratec.domain.Cliente;
import org.br.serratec.domain.ItemPedido;
import org.br.serratec.domain.Pedido;
import org.br.serratec.dto.RelatorioPedidoDto;
import org.br.serratec.repository.PedidoRepository;
import org.br.serratec.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioPedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	private MailConfig mailConfig;

	public void enviarEmail(Pedido pedido, List<ItemPedido> itemPedido) {
	RelatorioPedidoDto relatorio = new RelatorioPedidoDto();
	relatorio.setId(pedido.getId());
	relatorio.setDataPedido(pedido.getDataPedido());
	relatorio.setItemPedido(itemPedido);
	relatorio.setValorTotal(pedido.getValorTotal());
	System.out.println(pedido.getCliente().getEmail());
		mailConfig.sendMail(pedido.getCliente().getEmail(), "Ecommerce - Pedido cadastrado com sucesso!",
				relatorio.toString());

	}

	
		
	
}
