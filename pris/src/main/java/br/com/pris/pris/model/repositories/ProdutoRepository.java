package br.com.pris.pris.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
