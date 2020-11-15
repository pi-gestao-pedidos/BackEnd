package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.ItemPedido;
import br.com.pris.pris.model.repositories.ItemPedidoRepository;

@Service
@Validated
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository repository;
	

	public ItemPedido addItemPedido(@Valid ItemPedido itemPedido) {
		return this.repository.save(itemPedido);
	}

	public Iterable<ItemPedido> findAllItemPedidos() {
		return repository.findAll();
	}

	public ItemPedido findItemPedidoById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O ItemPedido não foi encontrado."));
	}

	public ItemPedido changeItemPedido(@Valid ItemPedido itemPedido, Integer id) {
		this.findItemPedidoById(id);
		itemPedido.setIdItemPedido(id);
		return this.addItemPedido(itemPedido);
	}

	public void deleteItemPedido(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O ItemPedido não foi encontrado.");
			}
	}
	
}
