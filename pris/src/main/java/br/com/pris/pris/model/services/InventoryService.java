package br.com.pris.pris.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pris.pris.model.entities.Material;
import br.com.pris.pris.model.repositories.MaterialProdutoRepository;

@Service
public class InventoryService {
	
	@Autowired
	private MaterialProdutoRepository materialProduto;
	
	@Autowired
	private MaterialService materiais;

	public void returnsMaterial(Integer idProd, Integer quantidade) {
		Material newMaterial = materiais.findMaterialById(materialProduto.idMaterial(idProd));
		newMaterial.setEstoque(materialProduto.somaEstoque(idProd, quantidade));
		this.materiais.changeMaterial(newMaterial, newMaterial.getIdMaterial());
	}

	public void removeMaterial(Integer idProd, Integer quantidade) {
		Material newMaterial = materiais.findMaterialById(materialProduto.idMaterial(idProd));
		newMaterial.setEstoque(materialProduto.retiraEstoque(idProd, quantidade));
		this.materiais.changeMaterial(newMaterial, newMaterial.getIdMaterial());
	}
}
