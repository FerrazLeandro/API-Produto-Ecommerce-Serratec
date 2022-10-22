package org.br.serratec.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.br.serratec.config.MailConfig;
import org.br.serratec.domain.Produto;
import org.br.serratec.dto.ProdutoDto;
import org.br.serratec.repository.ImagemRepository;
import org.br.serratec.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ImagemRepository ImagemRepository;

	@Autowired
	MailConfig mailConfig;

	@Autowired
	ImagemService imagemService;

	public ProdutoDto buscar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return adicionarImagemUri(produto.get());
	}

	public ProdutoDto inserir(Produto produto, MultipartFile file) throws IOException {
		produto = produtoRepository.save(produto);
		imagemService.inserir(produto, file);
		return adicionarImagemUri(produto);
	}

	public List<ProdutoDto> listar() {
		List<ProdutoDto> produtoDtos = produtoRepository.findAll().stream().map(f -> adicionarImagemUri(f))
				.collect(Collectors.toList());
		return produtoDtos;
	}

	public ProdutoDto adicionarImagemUri(@Valid @RequestBody Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/imagem")
				.buildAndExpand(produto.getId()).toUri();
		ProdutoDto pro = new ProdutoDto();
		pro.setNome(produto.getNome());
		pro.setDescricao(produto.getDescricao());
		pro.setQtdEstoque(produto.getQtdEstoque());
		pro.setDataCadastro(produto.getDataCadastro());
		pro.setValorUnitario(produto.getValorUnitario());
		pro.setCategoria(produto.getCategoria());
		pro.setUrl(uri.toString());

		// TODO Colocar o email do usuário
		mailConfig.sendMail("leandro_ferraz@outlook.com", "Ecommerce - Produto cadastrado com sucesso!",
				produto.toString());
		return pro;
	}
}
