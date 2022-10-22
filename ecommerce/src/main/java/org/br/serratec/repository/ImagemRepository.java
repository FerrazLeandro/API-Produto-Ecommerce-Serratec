package org.br.serratec.repository;

import java.util.Optional;

import org.br.serratec.domain.Imagem;
import org.br.serratec.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
	public Optional<Imagem> findByProduto(Produto produto);
}
