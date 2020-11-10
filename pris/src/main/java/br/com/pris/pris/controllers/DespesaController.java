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

import br.com.pris.pris.model.entities.Despesa;
import br.com.pris.pris.model.services.DespesaService;

@RestController
@RequestMapping("/despesas")
@CrossOrigin
public class DespesaController {

	@Autowired
	private DespesaService service;

	@PostMapping
	public ResponseEntity<Despesa> insertDespesa(@Valid @RequestBody Despesa despesa) {
		return ResponseEntity.ok(service.addDespesa(despesa));
	}

	@GetMapping
	public ResponseEntity<Iterable<Despesa>> showAllDespesa() {
		return ResponseEntity.ok(service.findAllDespesas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Despesa> showDespesaById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findDespesaById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Despesa> updateDespesa(@Valid @RequestBody Despesa despesa, @PathVariable Integer id) {
		return ResponseEntity.ok(service.changeDespesa(despesa, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDespesa(@PathVariable Integer id) {
		service.deleteDespesa(id);
		return ResponseEntity.noContent().build();
	}
}
