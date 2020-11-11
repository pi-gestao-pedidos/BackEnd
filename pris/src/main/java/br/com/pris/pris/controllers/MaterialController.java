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

import br.com.pris.pris.model.entities.Material;
import br.com.pris.pris.model.services.MaterialService;

@RestController
@RequestMapping("/material")
@CrossOrigin
public class MaterialController {
	@Autowired
	private MaterialService service;

	@PostMapping
	public ResponseEntity<Material> insertMaterial(@Valid @RequestBody Material material) {
		return ResponseEntity.ok(service.addMaterial(material));
	}

	@GetMapping
	public ResponseEntity<Iterable<Material>> showAllMaterials() {
		return ResponseEntity.ok(service.findAllMaterials());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Material> showMaterialById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findMaterialById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Material> updateMaterial(@Valid @RequestBody Material material,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changeMaterial(material, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMaterial(@PathVariable Integer id) {
		service.deleteMaterial(id);
		return ResponseEntity.noContent().build();
	}

}
