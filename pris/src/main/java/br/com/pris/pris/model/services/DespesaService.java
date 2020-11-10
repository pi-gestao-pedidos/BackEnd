package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Despesa;
import br.com.pris.pris.model.repositories.DespesaRepository;

@Service
@Validated
public class DespesaService {

	@Autowired
	private DespesaRepository repository;
	
	public Despesa addDespesa(@Valid Despesa despesa) {
		return this.repository.save(despesa);
	}
	
	public Iterable<Despesa> findAllDespesas() {
		return repository.findAll();
	}

	public Despesa findDespesaById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"A Despesa não foi encontrada."));
	}

	public Despesa changeDespesa(@Valid Despesa despesa, Integer id) {
		this.findDespesaById(id);
		despesa.setIdDespesa(id);;
		return this.addDespesa(despesa);
	}

	public void deleteDespesa(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"A Despesa não foi encontrada.");
			}
	}
}
