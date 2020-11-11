package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Material;
import br.com.pris.pris.model.repositories.MaterialRepository;

@Service
@Validated
public class MaterialService {
	
	@Autowired
	private MaterialRepository repository;

	public Material addMaterial(@Valid Material material) {
		return this.repository.save(material);
	}

	public Iterable<Material> findAllMaterials() {
		return repository.findAll();
	}

	public Material findMaterialById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Material não foi encontrado."));
	}

	public Material changeMaterial(@Valid Material material, Integer id) {
		this.findMaterialById(id);
		material.setIdMaterial(id);
		return this.addMaterial(material);
	}

	public void deleteMaterial(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O Material não foi encontrado.");
			}
	}

}
