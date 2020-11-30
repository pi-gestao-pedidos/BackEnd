package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Empreendedor;
import br.com.pris.pris.model.repositories.EmpreendedorRepository;

@Service
@Validated
public class EmpreendedorService {

	@Autowired
	private EmpreendedorRepository repository;

	
	public Empreendedor addEmpreendedor(@Valid Empreendedor empreendedor) {
		return this.repository.save(empreendedor);
	}
	
	public Iterable<Empreendedor> findAllEmpreendedores() {
		return repository.findAll();
	}

	public Empreendedor findEmpreendedorById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Empreendedor não foi encontrado."));
	}
	
	public Empreendedor findEmpreendedorByEmail(String email) {
		return repository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Empreendedor não foi encontrado."));
	}

	public Empreendedor changeEmpreendedor(@Valid Empreendedor empreendedor, Integer id) {
		this.findEmpreendedorById(id);
		empreendedor.setIdPessoa(id);
		return this.addEmpreendedor(empreendedor);
	}

	public void deleteEmpreendedor(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O Empreendedor não foi encontrado.");
			}
	}
	
	public int showCargaHorariaTotal(Integer id) {
		int horas = this.findEmpreendedorById(id).getCargaHoraria();
		int dias = 0;
		
		if(this.findEmpreendedorById(id).getSemana().getDomingo())dias++;
		if(this.findEmpreendedorById(id).getSemana().getQuarta()) dias++;
		if(this.findEmpreendedorById(id).getSemana().getQuinta()) dias++;
		if(this.findEmpreendedorById(id).getSemana().getSabado()) dias++;
		if(this.findEmpreendedorById(id).getSemana().getSexta()) dias++;
		if(this.findEmpreendedorById(id).getSemana().getTerca()) dias++;
		if(this.findEmpreendedorById(id).getSemana().getSegunda()) dias++;
		
		
		return dias*horas*4;
	}

}
