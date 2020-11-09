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

import br.com.pris.pris.model.entities.Cliente;
import br.com.pris.pris.model.services.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<Cliente> insertCliente(@Valid @RequestBody Cliente cliente) {
		return ResponseEntity.ok(service.addCliente(cliente));
	}

	@GetMapping
	public ResponseEntity<Iterable<Cliente>> showAllClientes() {
		return ResponseEntity.ok(service.findAllClientes());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> showClienteById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findClienteById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@Valid @RequestBody Cliente cliente, @PathVariable Integer id) {
		return ResponseEntity.ok(service.changeCliente(cliente, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
		service.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}

}
