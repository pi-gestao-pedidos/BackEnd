package br.com.pris.pris.model.services;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.MaterialProduto;
import br.com.pris.pris.model.repositories.MaterialProdutoRepository;

@Service
@Validated
public class MaterialProdutoService {

	@Autowired
	private MaterialProdutoRepository repository;

	
	public MaterialProduto addMaterialProduto(@Valid MaterialProduto materialProduto) {
		return this.repository.save(materialProduto);
	}

	public Iterable<MaterialProduto> findAllMaterialProdutos() {
		return repository.findAll();
	}

	public MaterialProduto findMaterialProdutoById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O MaterialProduto não foi encontrado."));
	}

	public MaterialProduto changeMaterialProduto(@Valid MaterialProduto materialProduto, Integer id) {
		this.findMaterialProdutoById(id);
		materialProduto.setId_material_produto(id);
		return this.addMaterialProduto(materialProduto);
	}

	public void deleteMaterialProduto(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O MaterialProduto não foi encontrado.");
			}
	}
	
	public BigDecimal custoTotal(Integer id) {
		return this.repository.custoTotalMateriais(id);
	}

	public Iterable<MaterialProduto> addMaterialProdutoList(@Valid Iterable<MaterialProduto> materialProduto) {
		Iterable<MaterialProduto> materiais = materialProduto;
		materiais.forEach(material -> this.addMaterialProduto(material));
		return materiais;
	}
	
}
