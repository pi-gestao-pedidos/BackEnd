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

import br.com.pris.pris.model.entities.Funcionario;
import br.com.pris.pris.model.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@PostMapping
	public ResponseEntity<Funcionario> insertFuncionario(@Valid @RequestBody Funcionario funcionario) {
		return ResponseEntity.ok(service.addFuncionario(funcionario));
	}

	@GetMapping
	public ResponseEntity<Iterable<Funcionario>> showAllFuncionarios() {
		return ResponseEntity.ok(service.findAllFuncionarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> showFuncionarioById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.findFuncionarioById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@Valid @RequestBody Funcionario funcionario,
			@PathVariable Integer id) {
		return ResponseEntity.ok(service.changeFuncionario(funcionario, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFuncionario(@PathVariable Integer id) {
		service.deleteFuncionario(id);
		return ResponseEntity.noContent().build();
	}
}
