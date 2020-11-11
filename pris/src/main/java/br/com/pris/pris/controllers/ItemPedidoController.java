package br.com.pris.pris.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pris.pris.model.entities.ItemPedido;
import br.com.pris.pris.model.services.ItemPedidoService;

@RestController
@RequestMapping("/itempedido")
@CrossOrigin
public class ItemPedidoController {
	@Autowired
	private ItemPedidoService service;

	@PostMapping
	public ResponseEntity<ItemPedido> insertItemPedido(@Valid @RequestBody ItemPedido itemPedido) {
		return ResponseEntity.ok(service.addItemPedido(itemPedido));
	}

	@GetMapping
	public ResponseEntity<Iterable<ItemPedido>> showAllItemPedidos() {
		return ResponseEntity.ok(service.findAllItemPedidos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> showItemPedidoById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findItemPedidoById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> updateItemPedido(@Valid @RequestBody ItemPedido itemPedido,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changeItemPedido(itemPedido, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteItemPedido(@PathVariable Integer id) {
		service.deleteItemPedido(id);
		return ResponseEntity.noContent().build();
	}

}
