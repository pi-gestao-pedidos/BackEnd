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
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDespesa;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@JsonIgnoreProperties("pessoa")
	private Pessoa pessoa;
	
	private String nome;
	private BigDecimal valor;
}
