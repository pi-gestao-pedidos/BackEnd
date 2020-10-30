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
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_despesa;
	
	@ManyToOne
	@JoinColumn(name = "perfil_cliente")
	@JsonIgnoreProperties("despesa")
	private Perfil_cliente perfil_cliente;
	private String nome;
	private Double valor;
}
