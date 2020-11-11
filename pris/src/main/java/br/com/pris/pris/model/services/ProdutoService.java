package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Produto;
import br.com.pris.pris.model.repositories.ProdutoRepository;

@Service
@Validated
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public Produto addProduto(@Valid Produto produto) {
		return this.repository.save(produto);
	}

	public Iterable<Produto> findAllProdutos() {
		return repository.findAll();
	}

	public Produto findProdutoById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Produto não foi encontrado."));
	}

	public Produto changeProduto(@Valid Produto produto, Integer id) {
		this.findProdutoById(id);
		produto.setIdProduto(id);
		return this.addProduto(produto);
	}

	public void deleteProduto(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O Produto não foi encontrado.");
			}
	}
}
