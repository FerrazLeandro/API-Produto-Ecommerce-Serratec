package org.br.serratec.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.br.serratec.domain.Imagem;
import org.br.serratec.domain.Produto;
import org.br.serratec.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {
	@Autowired
	private ImagemRepository imagemRepository;

	public Imagem inserir(Produto produto, MultipartFile file) throws IOException {
		Imagem imagem = new Imagem();
		imagem.setNome(file.getName());
		imagem.setTipo(file.getContentType());
		imagem.setDados(file.getBytes());
		imagem.setProduto(produto);
		return imagemRepository.save(imagem);
	}

	@Transactional
	public Imagem buscarPorIdProduto(Long id) {
		Produto produto = new Produto();
		produto.setId(id);
		Optional<Imagem> imagem = imagemRepository.findByProduto(produto);
		if (!imagem.isPresent()) {
			return null;
		}
		return imagem.get();
	}
}