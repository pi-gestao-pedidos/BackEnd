package br.com.pris.pris.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Integer id_produto;
	
	private String nome;
	private String descricao;
	private Integer tempo;
	private Integer unidade_mensal;
	private Double preco_custo;
	private Double preco_venda;
	private Double lucro;
	private Integer estoque;
	
	@OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("produto")
	private List<Despesa_produto> despesa_produto;
	
	@OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("produto")
	private List<Material> material;

}
