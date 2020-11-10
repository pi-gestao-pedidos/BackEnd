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

import br.com.pris.pris.model.entities.DespesaProduto;
import br.com.pris.pris.model.services.DespesaProdutoService;

@RestController
@RequestMapping("/despesasDoProduto")
@CrossOrigin
public class DespesaProdutoController {
	
	@Autowired
	private DespesaProdutoService service;

	@PostMapping
	public ResponseEntity<DespesaProduto> insertDespesaProduto(@Valid @RequestBody DespesaProduto despesaProduto) {
		return ResponseEntity.ok(service.addDespesaProduto(despesaProduto));
	}

	@GetMapping
	public ResponseEntity<Iterable<DespesaProduto>> showAllDespesaProduto() {
		return ResponseEntity.ok(service.findAllDespesaProduto());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DespesaProduto> showDespesaProdutoById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findDespesaProdutoById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<DespesaProduto> updateDespesaProduto(@Valid @RequestBody DespesaProduto despesaProduto, @PathVariable Integer id) {
		return ResponseEntity.ok(service.changeDespesaProduto(despesaProduto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDespesaProduto(@PathVariable Integer id) {
		service.deleteDespesaProduto(id);
		return ResponseEntity.noContent().build();
	}
}
