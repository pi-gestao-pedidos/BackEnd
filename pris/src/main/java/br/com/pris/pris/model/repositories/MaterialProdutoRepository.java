package br.com.pris.pris.model.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.MaterialProduto;

public interface MaterialProdutoRepository extends CrudRepository<MaterialProduto, Integer>{

	String query = "SELECT sum(material_produto.quantidade*material.custo)\n" + 
			"FROM material_produto \n" + 
			"INNER JOIN material ON material_produto.id_produto = :id \n" + 
			"AND material_produto.id_material = material.id_material";
	@Query(value = query, nativeQuery = true)
	BigDecimal custoTotalMateriais(Integer id);
	
	
	String query2 = "SELECT sum(material.estoque + (:quantidade * material_produto.quantidade)) "
			+ "FROM prisapi.material_produto, material "
			+ "WHERE id_produto = :idProd "
			+ "AND (material_produto.id_material = material.id_material)";
	@Query(value = query2, nativeQuery = true)
	Integer somaEstoque(Integer idProd, Integer quantidade);

	String query3 = "SELECT sum(material.estoque - (:quantidade * material_produto.quantidade)) "
			+ "FROM prisapi.material_produto, material "
			+ "WHERE id_produto = :idProd "
			+ "AND (material_produto.id_material = material.id_material)";
	@Query(value = query3, nativeQuery = true)
	Integer retiraEstoque(Integer idProd, Integer quantidade);
	
	String query4 = "SELECT sum(material.id_material) FROM prisapi.material_produto, material "
			+ "WHERE id_produto = :idProd "
			+ "AND (material_produto.id_material = material.id_material)";
	@Query(value = query4, nativeQuery = true)
	Integer idMaterial(Integer idProd);
}