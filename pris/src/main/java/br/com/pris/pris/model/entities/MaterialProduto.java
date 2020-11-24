package br.com.pris.pris.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_material_produto;
	
	private Integer idMaterial;
	private Integer idProduto;
	
	@ManyToOne
	@JoinColumn(name="idMaterial", insertable=false, updatable=false)
	@JsonIgnore
	private Material material;
	
	@ManyToOne
	@JoinColumn(name="idProduto", insertable=false, updatable=false)
	@JsonIgnore
	private Produto produto;
	
	@NotNull(message = "Quantidade deve possuir um valor")
	@Min(value = 1, message = "Quantidade deve ser maior que 1")
	private Integer quantidade;

}
