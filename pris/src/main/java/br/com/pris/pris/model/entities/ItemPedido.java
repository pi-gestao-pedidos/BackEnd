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
	private int id_item_pedido;
	
	private Integer quantidade;
	private Double lucro;
	
	@ManyToOne
	@JoinColumn(name = "pedido")
	@JsonIgnoreProperties("itemPedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto")
	@JsonIgnoreProperties("itemPedido")
	private Produto produto;

}
