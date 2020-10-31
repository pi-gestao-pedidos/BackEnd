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
public class Despesa_produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id_despesa_produto;
	
	private String nome;	
	private Double valor;	
	private Double porcentagem;	
	
	@ManyToOne
	@JoinColumn(name = "produto_id_produto")
	@JsonIgnoreProperties("produto")
	private Produto produto;
	

}
