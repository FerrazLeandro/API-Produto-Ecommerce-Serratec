package org.br.serratec.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.br.serratec.config.MailConfig;
import org.br.serratec.domain.Imagem;
import org.br.serratec.domain.Produto;
import org.br.serratec.dto.ProdutoDto;
import org.br.serratec.repository.ImagemRepository;
import org.br.serratec.repository.ProdutoRepository;
import org.br.serratec.service.ImagemService;
import org.br.serratec.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ImagemRepository imagemRepository;

	@Autowired
	ImagemService imagemService;

	@Autowired
	private MailConfig mailConfig;

	@Autowired
	ProdutoService produtoService;

	@GetMapping
	@ApiOperation(value = "Lista todos os produtos", notes = "Listagem de produtos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todas os produtos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public List<ProdutoDto> listar() {
		return produtoService.listar();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um produto", notes = "produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um produto"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (!produto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto.get());
	}
	
	@GetMapping("/{id}/imagem")
	@ApiOperation(value = "Retorna a imagem de um produto", notes = "Imagem")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma imagem"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	
	public ResponseEntity<byte[]> buscarImagem(@PathVariable Long id) {
	Imagem imagem = imagemService.buscarPorIdProduto(id);
	HttpHeaders headers = new HttpHeaders();
	headers.add("Content-type", imagem.getTipo());
	headers.add("Content-length", String.valueOf(imagem.getDados().length));
	return new ResponseEntity<>(imagem.getDados(), headers, HttpStatus.OK);
	}

	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	@ApiOperation(value = "Insere os dados de um produto", notes = "Inserir produto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Produto adicionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ProdutoDto inserir(@RequestPart MultipartFile imagem, @RequestPart Produto produto) throws IOException {
		return produtoService.inserir(produto, imagem);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza dados de um produto", notes = "Atualizar produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Produto atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		Optional<Produto> produtoBanco = produtoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um produto", notes = "Remover produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Produto removido"),
			@ApiResponse(code = 204, message = "Sem conteúdo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Produto> produtoBanco = produtoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
