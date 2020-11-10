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

import br.com.pris.pris.model.entities.Empreendedor;
import br.com.pris.pris.model.services.EmpreendedorService;

@RestController
@RequestMapping("/empreendedor")
@CrossOrigin
public class EmpreendedorController {

	@Autowired
	private EmpreendedorService service;

	@PostMapping
	public ResponseEntity<Empreendedor> insertEmpreendedor(@Valid @RequestBody Empreendedor empreendedor) {
		return ResponseEntity.ok(service.addEmpreendedor(empreendedor));
	}

	@GetMapping
	public ResponseEntity<Iterable<Empreendedor>> showAllEmpreendedores() {
		return ResponseEntity.ok(service.findAllEmpreendedores());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empreendedor> showEmpreendedorById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findEmpreendedorById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Empreendedor> updateEmpreendedor(@Valid @RequestBody Empreendedor empreendedor, @PathVariable Integer id) {
		return ResponseEntity.ok(service.changeEmpreendedor(empreendedor, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmpreendedor(@PathVariable Integer id) {
		service.deleteEmpreendedor(id);
		return ResponseEntity.noContent().build();
	}
}
