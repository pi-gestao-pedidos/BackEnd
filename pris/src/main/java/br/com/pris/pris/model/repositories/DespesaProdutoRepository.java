package br.com.pris.pris.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.Despesa;

public interface DespesaProdutoRepository extends CrudRepository<Despesa, Integer>{

}
