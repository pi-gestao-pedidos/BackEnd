package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Cliente;
import br.com.pris.pris.model.repositories.ClienteRepository;

@Service
@Validated
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente addCliente(@Valid Cliente cliente) {
		return this.repository.save(cliente);
	}

	public Iterable<Cliente> findAllClientes() {
		return repository.findAll();
	}

	public Cliente findClienteById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O cliente não foi encontrado."));
	}

	public Cliente changeCliente(@Valid Cliente cliente, Integer id) {
		Cliente clienteDB = this.findClienteById(id);
		clienteDB = cliente;
		return this.addCliente(clienteDB);
	}

	public void deleteCliente(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O cliente não foi encontrado.");
			}
	}
}
