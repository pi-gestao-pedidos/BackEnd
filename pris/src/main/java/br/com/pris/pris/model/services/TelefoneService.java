package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Telefone;
import br.com.pris.pris.model.repositories.TelefoneRepository;

@Service
@Validated
public class TelefoneService {
	@Autowired
	private TelefoneRepository repository;

	public Telefone addTelefone(@Valid Telefone telefone) {
		return this.repository.save(telefone);
	}

	public Iterable<Telefone> findAllTelefones() {
		return repository.findAll();
	}

	public Telefone findTelefoneById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Telefone não foi encontrado."));
	}

	public Telefone changeTelefone(@Valid Telefone telefone, Integer id) {
		this.findTelefoneById(id);
		telefone.setIdTelefone(id);
		return this.addTelefone(telefone);
	}

	public void deleteTelefone(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O Telefone não foi encontrado.");
			}
	}
	
}
