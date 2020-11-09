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
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItemPedido;
	
	@ManyToOne
	@JoinColumn(name="idProduto")
	@JsonIgnoreProperties("produto_pedido")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="idPedido")
	@JsonIgnoreProperties("produto_pedido")
	private Pedido pedido;
	
	private Integer quantidade;
	private Double lucro;

}
