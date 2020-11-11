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

import br.com.pris.pris.model.entities.Produto;
import br.com.pris.pris.model.services.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin
public class ProdutoController {
	@Autowired
	private ProdutoService service;

	@PostMapping
	public ResponseEntity<Produto> insertProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.ok(service.addProduto(produto));
	}

	@GetMapping
	public ResponseEntity<Iterable<Produto>> showAllProdutos() {
		return ResponseEntity.ok(service.findAllProdutos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> showProdutoById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findProdutoById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@Valid @RequestBody Produto produto,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changeProduto(produto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduto(@PathVariable Integer id) {
		service.deleteProduto(id);
		return ResponseEntity.noContent().build();
	}
}
