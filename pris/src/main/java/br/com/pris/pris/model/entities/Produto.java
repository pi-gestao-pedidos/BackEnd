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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@NotBlank(message = "Nome deve ser preenchido.")
	@Size (min = 3, message = "Nome deve ter mais que 2 caracteres.")
	private String nome;
	
	private String descricao;
	
	@NotNull(message = "Tempo possuir um valor em Minutos")
	@Min(value = 1, message = "Tempo deve ser maior que 0")
	private Integer tempo;
	
	@NotNull(message = "Quantidade mensal deve possuir um valor")
	@Min(value = 0, message = "Quantidade mensal Tempo deve ser maior ou igual a 0")
	private Integer unidadeMensal;
	
	@NotNull(message = "Preço de custo deve possuir um valor")
	@DecimalMin(value = "0.00", message = "Preço de custo deve ser maior ou igual a 0.00")
	private BigDecimal precoCusto;
	
	@NotNull(message = "Preço de venda deve possuir um valor")
	@DecimalMin(value = "0.00", message = "Preço de venda deve ser maior ou igual a 0.00")
	private BigDecimal precoVenda;
	
	private BigDecimal precoSugerido;
	
	@NotNull(message = "Lucro deve possuir um valor")
	@DecimalMin(value = "0.00", message = "Lucro deve ser maior ou igual a 0.00")
	private Double lucro;
	
	@NotNull(message = "Estoque deve possuir um valor")
	@Min(value = 0, message = "Estoque deve ser maior que 0")
	private Integer estoque;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<DespesaProduto> despesas;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<MaterialProduto> materiais;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnore//Properties("produtos")
	private List<ItemPedido> pedidos;

}
