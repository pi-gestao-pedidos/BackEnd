package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.DespesaProduto;
import br.com.pris.pris.model.repositories.DespesaProdutoRepository;

@Service
@Validated
public class DespesaProdutoService {

	@Autowired
	private DespesaProdutoRepository repository;
	
	public DespesaProduto addDespesaProduto(@Valid DespesaProduto despesaProduto) {
		return this.repository.save(despesaProduto);
	}
	
	public Iterable<DespesaProduto> findAllDespesaProduto() {
		return repository.findAll();
	}

	public DespesaProduto findDespesaProdutoById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"A Despesa do produto não foi encontrada."));
	}

	public DespesaProduto changeDespesaProduto(@Valid DespesaProduto despesaProduto, Integer id) {
		this.findDespesaProdutoById(id);
		despesaProduto.setIdDespesaProduto(id);;
		return this.addDespesaProduto(despesaProduto);
	}

	public void deleteDespesaProduto(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"A Despesa não foi encontrada.");
			}
	}
}
