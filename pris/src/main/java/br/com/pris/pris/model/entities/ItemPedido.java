package br.com.pris.pris.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer idItemPedido;
	
	private Integer idPedido;
	private Integer idProduto;
	
	@ManyToOne
	@JoinColumn(name="idPedido", insertable=false, updatable=false)
	@JsonIgnoreProperties("pedidos")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="idProduto", insertable=false, updatable=false)
	@JsonIgnoreProperties({"tempo","unidadeMensal","despesas","materiais","pedidos"})
	private Produto produto;
	
	@NotNull(message = "Quantidade deve possuir um valor")
	@Min(value = 1, message = "Quantidade deve ser maior que 1")
	private Integer quantidade;
	
	@NotNull(message = "Lucro deve possuir um valor")
	@DecimalMin(value = "0.00", message = "Lucro deve ser maior ou igual a 0.00")
	private Double lucro;

}
