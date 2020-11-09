package br.com.pris.pris.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Perfil_cliente;
import br.com.pris.pris.model.repositories.Perfil_clienteRepository;

@RestController
@RequestMapping("/perfilCliente")
public class Perfil_clienteController {
	
	@Autowired
	private Perfil_clienteRepository repository;
	
	@PostMapping
	public Perfil_cliente addPerfilCliente(@RequestBody Perfil_cliente perfilCliente) {
		repository.save(perfilCliente);
		return perfilCliente;
	}
	
	
	@GetMapping
	public Iterable<Perfil_cliente> getAllPerfilCliente() {
		return repository.findAll();
	}
	
	@GetMapping("/{cpf}")
	public Optional<Perfil_cliente> getPerfilClienteByCpf(@PathVariable String cpf) {
		return repository.findById(cpf);
	}
	
	
	@PutMapping("/{cpf}")
	public ResponseEntity<Perfil_cliente> updatePerfilCliente(@PathVariable String cpf, @RequestBody Perfil_cliente perfilCliente) throws Exception {
		Perfil_cliente perfilClienteDB = repository.findById(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cpf não encontrado"));
		perfilClienteDB.setNome(perfilCliente.getNome());
		return ResponseEntity.ok(repository.save(perfilClienteDB));
	}
	
	
	@DeleteMapping("/{cpf}")
	public void deletePerfilCliente(@PathVariable String cpf) {
		repository.deleteById(cpf);
	}
	
}
