package br.com.pris.pris.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.Material;

public interface MaterialRepository extends CrudRepository<Material, Integer> {

}
