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

import br.com.pris.pris.model.entities.Semana;
import br.com.pris.pris.model.services.SemanaService;

@RestController
@RequestMapping("/semana")
@CrossOrigin
public class SemanaController {
	@Autowired
	private SemanaService service;

	@PostMapping
	public ResponseEntity<Semana> insertSemana(@Valid @RequestBody Semana semana) {
		return ResponseEntity.ok(service.addSemana(semana));
	}

	@GetMapping
	public ResponseEntity<Iterable<Semana>> showAllSemanas() {
		return ResponseEntity.ok(service.findAllSemanas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Semana> showSemanaById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findSemanaById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Semana> updateSemana(@Valid @RequestBody Semana semana,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changeSemana(semana, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSemana(@PathVariable Integer id) {
		service.deleteSemana(id);
		return ResponseEntity.noContent().build();
	}
}
