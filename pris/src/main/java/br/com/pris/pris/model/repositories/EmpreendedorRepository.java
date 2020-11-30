package br.com.pris.pris.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.Empreendedor;

public interface EmpreendedorRepository extends CrudRepository<Empreendedor, Integer>{

	Optional<Empreendedor> findByEmail(String email);

}
