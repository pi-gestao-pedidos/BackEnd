package br.com.pris.pris.model.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@NotBlank(message = "Nome deve ser preenchido.")
	@Size (min = 3, message = "Nome deve ter mais que 2 caracteres.")
	private String nome;
	
	@NotNull(message = "Estoque deve possuir um valor")
	@Min(value = 0, message = "Estoque deve ser maior que 0")
	private Integer estoque;
	
	@NotBlank(message = "Medida deve ser preenchido.")
	private String unidadeMedida;
	
	@NotNull(message = "Custo deve possuir um valor")
	@DecimalMin(value = "0.00", message = "Valor deve ser positivo.")
	private BigDecimal custo;
	
	@OneToMany(mappedBy = "material")
	@JsonIgnoreProperties("material")
	private List<MaterialProduto> materiais;
	
	@OneToMany(mappedBy = "material")
	@JsonIgnoreProperties("material")
	private List<EntradaEstoque> entradasEstoque;

}
