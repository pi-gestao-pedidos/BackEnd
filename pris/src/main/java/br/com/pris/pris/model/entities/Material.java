package br.com.pris.pris.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Integer id_material;
	
	private String nome;
	private Integer estoque;
	private String unidade_medida;
	private Double custo;
	
	@OneToMany(mappedBy = "material", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("material")
	private List<Material_produto> material_produto;

}
