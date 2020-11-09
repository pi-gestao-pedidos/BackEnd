package br.com.pris.pris.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material_produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_material_produto;
	
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "material")
	@JsonIgnoreProperties("material_produto")
	private Material material;
	
	@ManyToOne
	@JoinColumn(name = "produto")
	@JsonIgnoreProperties("material_produto")
	private Produto produto;

}
