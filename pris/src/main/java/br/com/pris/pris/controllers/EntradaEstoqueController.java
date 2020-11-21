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

import br.com.pris.pris.model.entities.EntradaEstoque;
import br.com.pris.pris.model.services.EntradaEstoqueService;

@RestController
@RequestMapping("/entradaEstoque")
@CrossOrigin
public class EntradaEstoqueController {

	@Autowired
	private EntradaEstoqueService service;

	@PostMapping
	public ResponseEntity<EntradaEstoque> insertEntradaEstoque(@Valid @RequestBody EntradaEstoque entradaEstoque) {
		return ResponseEntity.ok(service.addEntradaEstoque(entradaEstoque));
	}
	
	@PostMapping("/lista")
	public ResponseEntity<Iterable<EntradaEstoque>> insertEntradaEstoqueList(@Valid @RequestBody Iterable<EntradaEstoque> entradaEstoque) {
		return ResponseEntity.ok(service.addEntradaEstoqueList(entradaEstoque));
	}

	@GetMapping
	public ResponseEntity<Iterable<EntradaEstoque>> showAllEntradaEstoque() {
		return ResponseEntity.ok(service.findAllEntradaEstoque());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntradaEstoque> showEntradaEstoqueById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findEntradaEstoqueById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EntradaEstoque> updateEntradaEstoque(@Valid @RequestBody EntradaEstoque entradaEstoque, @PathVariable Integer id) {
		return ResponseEntity.ok(service.changeEntradaEstoque(entradaEstoque, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEntradaEstoque(@PathVariable Integer id) {
		service.deleteEntradaEstoque(id);
		return ResponseEntity.noContent().build();
	}
}
