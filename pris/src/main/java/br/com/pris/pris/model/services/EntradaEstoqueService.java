package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.EntradaEstoque;
import br.com.pris.pris.model.repositories.EntradaEstoqueRepository;

@Service
@Validated
public class EntradaEstoqueService {

	@Autowired
	private EntradaEstoqueRepository repository;
	
	public EntradaEstoque addEntradaEstoque(@Valid EntradaEstoque entradaEstoque) {
		return repository.save(entradaEstoque);
	}
	
	public Iterable<EntradaEstoque> findAllEntradaEstoque() {
		return repository.findAll();
	}

	public EntradaEstoque findEntradaEstoqueById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O registro não foi encontrado."));
	}

	public EntradaEstoque changeEntradaEstoque(@Valid EntradaEstoque entradaEstoque, Integer id) {
		this.findEntradaEstoqueById(id);
		entradaEstoque.setIdEntrada(id);;
		return this.addEntradaEstoque(entradaEstoque);
	}

	public void deleteEntradaEstoque(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O registro não foi encontrado.");
			}
	}

	public Iterable<EntradaEstoque> addEntradaEstoqueList(@Valid Iterable<EntradaEstoque> entradaEstoque) {
		Iterable<EntradaEstoque> entradas = entradaEstoque;
		entradas.forEach(entrada -> this.addEntradaEstoque(entrada));
		return entradas;
	}
}
