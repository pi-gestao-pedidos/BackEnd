package br.com.pris.pris.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DespesaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idDespesaProduto;
	
	private Integer idProduto;
	
	@NotBlank(message = "Campo Nome estar preenchido.")
	private String nome;
	
	@DecimalMin(value = "0.00", message = "Valor deve ser positivo.")
	private BigDecimal valor;	
	
	@DecimalMin(value = "0.00", message = "Porcentagem deve ser positivo.")
	private Double porcentagem;	
	
	@ManyToOne
	@JoinColumn(name = "idProduto", insertable=false, updatable=false)
	@JsonIgnore
	private Produto produto;
	
	

}
