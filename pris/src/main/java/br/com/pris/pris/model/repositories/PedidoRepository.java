package br.com.pris.pris.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

}
