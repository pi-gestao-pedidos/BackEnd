package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Semana;
import br.com.pris.pris.model.repositories.SemanaRepository;

@Service
@Validated
public class SemanaService {
	@Autowired
	private SemanaRepository repository;
	

	public Semana addSemana(@Valid Semana semana) {
		return this.repository.save(semana);
	}

	public Iterable<Semana> findAllSemanas() {
		return repository.findAll();
	}

	public Semana findSemanaById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Semana não foi encontrado."));
	}

	public Semana changeSemana(@Valid Semana semana, Integer id) {
		this.findSemanaById(id);
		semana.setIdSemana(id);
		return this.addSemana(semana);
	}

	public void deleteSemana(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O Semana não foi encontrado.");
			}
	}
}
