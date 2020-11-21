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

import br.com.pris.pris.model.entities.Pedido;
import br.com.pris.pris.model.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidoController {
	@Autowired
	private PedidoService service;

	@PostMapping
	public ResponseEntity<Pedido> insertPedido(@Valid @RequestBody Pedido pedido) {
		return ResponseEntity.ok(service.addPedido(pedido));
	}

	@GetMapping
	public ResponseEntity<Iterable<Pedido>> showAllPedidos() {
		return ResponseEntity.ok(service.findAllPedidos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> showPedidoById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findPedidoById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@Valid @RequestBody Pedido pedido,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changePedido(pedido, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePedido(@PathVariable Integer id) {
		service.deletePedido(id);
		return ResponseEntity.noContent().build();
	}

}
