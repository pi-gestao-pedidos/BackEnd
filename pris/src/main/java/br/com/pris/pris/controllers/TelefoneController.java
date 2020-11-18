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

import br.com.pris.pris.model.entities.Telefone;
import br.com.pris.pris.model.services.TelefoneService;

@RestController
@RequestMapping("/telefone")
@CrossOrigin
public class TelefoneController {
	@Autowired
	private TelefoneService service;

	@PostMapping
	public ResponseEntity<Telefone> insertTelefone(@Valid @RequestBody Telefone telefone) {
		return ResponseEntity.ok(service.addTelefone(telefone));
	}

	@GetMapping
	public ResponseEntity<Iterable<Telefone>> showAllTelefones() {
		return ResponseEntity.ok(service.findAllTelefones());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Telefone> showTelefoneById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findTelefoneById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Telefone> updateTelefone(@Valid @RequestBody Telefone telefone,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changeTelefone(telefone, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTelefone(@PathVariable Integer id) {
		service.deleteTelefone(id);
		return ResponseEntity.noContent().build();
	}
}
