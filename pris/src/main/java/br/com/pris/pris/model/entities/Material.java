package br.com.pris.pris.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMaterial;
	
	private String nome;
	private Integer estoque;
	private String unidadeMedida;
	
	@OneToMany(mappedBy = "material")
	@JsonIgnoreProperties("material")
	private List<MaterialProduto> materiais;
	
	@OneToMany(mappedBy = "material")
	@JsonIgnoreProperties("material")
	private List<EntradaEstoque> entradasEstoque;

}
