package br.com.pris.pris.model.entities;

import java.math.BigDecimal;

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
public class DespesaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idDespesaProduto;
	
	private String nome;	
	private BigDecimal valor;	
	private Double porcentagem;	
	
	@ManyToOne
	@JoinColumn(name = "idProduto")
	@JsonIgnoreProperties("produto")
	private Produto produto;
	

}
