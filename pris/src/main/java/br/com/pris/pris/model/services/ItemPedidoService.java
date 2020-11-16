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
	
	@Autowired
	private InventoryService inventory;
	

	public ItemPedido addItemPedido(@Valid ItemPedido itemPedido) {
		if (itemPedido.getIdItemPedido() > 0) {
			if (findItemPedidoById(itemPedido.getIdItemPedido()).getQuantidade() < itemPedido.getQuantidade()) {
				Integer mudanca = itemPedido.getQuantidade() - findItemPedidoById(itemPedido.getIdItemPedido()).getQuantidade();
				this.repository.save(itemPedido);
				this.inventory.returnsMaterial(itemPedido.getIdProduto(), mudanca);
				return itemPedido;
			}
			if (findItemPedidoById(itemPedido.getIdItemPedido()).getQuantidade() > itemPedido.getQuantidade()) {
				Integer mudanca = findItemPedidoById(itemPedido.getIdItemPedido()).getQuantidade() - itemPedido.getQuantidade();
				this.repository.save(itemPedido);
				this.inventory.removeMaterial(itemPedido.getIdProduto(), mudanca);
				return itemPedido;
			}
			if (findItemPedidoById(itemPedido.getIdItemPedido()).getQuantidade() == itemPedido.getQuantidade()) {
				return this.repository.save(itemPedido);
			}
		}
		
		this.inventory.returnsMaterial(itemPedido.getIdProduto(), itemPedido.getQuantidade());
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
			if (repository.existsById(id)) {
					ItemPedido itemPedido = repository.findById(id).get();
					Integer mudanca = itemPedido.getQuantidade();
					this.inventory.returnsMaterial(itemPedido.getIdProduto(), mudanca);
					this.repository.deleteById(id);
				}
			//repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O ItemPedido não foi encontrado.");
			}
	}
	
}
