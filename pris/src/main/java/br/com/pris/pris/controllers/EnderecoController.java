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

import br.com.pris.pris.model.entities.Endereco;
import br.com.pris.pris.model.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@PostMapping
	public ResponseEntity<Endereco> insertEndereco(@Valid @RequestBody Endereco endereco) {
		return ResponseEntity.ok(service.addEndereco(endereco));
	}

	@GetMapping
	public ResponseEntity<Iterable<Endereco>> showAllEndereco() {
		return ResponseEntity.ok(service.findAllEnderecos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> showEnderecoById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findEnderecoById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> updateEndereco(@Valid @RequestBody Endereco endereco, @PathVariable Integer id) {
		return ResponseEntity.ok(service.changeEndereco(endereco, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEndereco(@PathVariable Integer id) {
		service.deleteEndereco(id);
		return ResponseEntity.noContent().build();
	}
}
