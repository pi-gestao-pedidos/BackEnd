package br.com.pris.pris.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
