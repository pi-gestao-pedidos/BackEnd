package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Endereco;
import br.com.pris.pris.model.repositories.EnderecoRepository;

@Service
@Validated
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public Endereco addEndereco(@Valid Endereco endereco) {
		return repository.save(endereco);
	}
	
	public Iterable<Endereco> findAllEnderecos() {
		return repository.findAll();
	}

	public Endereco findEnderecoById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Endereco não foi encontrado."));
	}

	public Endereco changeEndereco(@Valid Endereco endereco, Integer id) {
		this.findEnderecoById(id);
		endereco.setIdEndereco(id);;
		return this.addEndereco(endereco);
	}

	public void deleteEndereco(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"A Endereco não foi encontrada.");
			}
	}
}
