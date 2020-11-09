package br.com.pris.pris.model.entities;

import java.math.BigDecimal;
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
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	
	private String nome;
	private String descricao;
	private Integer tempo;
	private Integer unidadeMensal;
	private BigDecimal precoCusto;
	private BigDecimal precoVenda;
	private Double lucro;
	private Integer estoque;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<DespesaProduto> despesas;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<MaterialProduto> material;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<ItemPedido> pedidos;

}
