package br.com.pris.pris.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semana {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSemana;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	@JsonIgnoreProperties("pessoa")
	private Pessoa pessoa;
	
	private Boolean domingo;
	private Boolean segunda;
	private Boolean terca;
	private Boolean quarta;
	private Boolean quinta;
	private Boolean sexta;
	private Boolean sabado;

}
