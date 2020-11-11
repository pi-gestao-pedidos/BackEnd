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

import br.com.pris.pris.model.entities.MaterialProduto;
import br.com.pris.pris.model.services.MaterialProdutoService;

@RestController
@RequestMapping("/materialproduto")
@CrossOrigin
public class MaterialProdutoController {
	@Autowired
	private MaterialProdutoService service;

	@PostMapping
	public ResponseEntity<MaterialProduto> insertMaterialProduto(@Valid @RequestBody MaterialProduto materialProduto) {
		return ResponseEntity.ok(service.addMaterialProduto(materialProduto));
	}

	@GetMapping
	public ResponseEntity<Iterable<MaterialProduto>> showAllMaterialProdutos() {
		return ResponseEntity.ok(service.findAllMaterialProdutos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MaterialProduto> showMaterialProdutoById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findMaterialProdutoById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MaterialProduto> updateMaterialProduto(@Valid @RequestBody MaterialProduto materialProduto,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changeMaterialProduto(materialProduto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMaterialProduto(@PathVariable Integer id) {
		service.deleteMaterialProduto(id);
		return ResponseEntity.noContent().build();
	}
}
