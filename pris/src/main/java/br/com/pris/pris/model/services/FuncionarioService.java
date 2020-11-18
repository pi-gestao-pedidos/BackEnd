package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Funcionario;
import br.com.pris.pris.model.repositories.FuncionarioRepository;

@Service
@Validated
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;


	public Funcionario addFuncionario(@Valid Funcionario funcionario) {
		return this.repository.save(funcionario);
	}

	public Iterable<Funcionario> findAllFuncionarios() {
		return repository.findAll();
	}

	public Funcionario findFuncionarioById(Integer id) {
		return repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O Funcionario não foi encontrado."));
	}

	public Funcionario changeFuncionario(@Valid Funcionario funcionario, Integer id) {
		this.findFuncionarioById(id);
		funcionario.setIdPessoa(id);
		return this.addFuncionario(funcionario);
	}

	public void deleteFuncionario(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O Funcionario não foi encontrado.");
		}
	}
	
	public int showCargaHorariaTotal(Integer id) {
		int horas = this.findFuncionarioById(id).getCargaHoraria();
		int dias = 0;
		if(this.findFuncionarioById(id).getSemana().getDomingo()) dias++;
		if(this.findFuncionarioById(id).getSemana().getQuarta()) dias++;
		if(this.findFuncionarioById(id).getSemana().getQuinta()) dias++;
		if(this.findFuncionarioById(id).getSemana().getSabado()) dias++;
		if(this.findFuncionarioById(id).getSemana().getSexta()) dias++;
		if(this.findFuncionarioById(id).getSemana().getTerca()) dias++;
		if(this.findFuncionarioById(id).getSemana().getSegunda()) dias++;
		
		return dias*horas*4;
	}
	
}
