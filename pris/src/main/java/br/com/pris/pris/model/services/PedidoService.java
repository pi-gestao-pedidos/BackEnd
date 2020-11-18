package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Pedido;
import br.com.pris.pris.model.repositories.PedidoRepository;

@Service
@Validated
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	public Pedido addPedido(@Valid Pedido pedido) {
		return this.repository.save(pedido);
	}

	public Iterable<Pedido> findAllPedidos() {
		return repository.findAll();
	}

	public Pedido findPedidoById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Pedido não foi encontrado."));
	}

	public Pedido changePedido(@Valid Pedido pedido, Integer id) {
		this.findPedidoById(id);
		pedido.setIdPedido(id);
		return this.addPedido(pedido);
	}

	public void deletePedido(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O Pedido não foi encontrado.");
			}
	}

}
