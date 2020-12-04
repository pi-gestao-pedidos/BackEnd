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
	private Integer idSemana;
	
	private Integer idPessoa;
	
	@OneToOne(mappedBy = "semana")
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa", insertable=false, updatable=false)
	@JsonIgnoreProperties("pessoa")
	private Funcionario funcionario;
	
	private Boolean domingo = false;
	private Boolean segunda = true;
	private Boolean terca = true;
	private Boolean quarta = true;
	private Boolean quinta = true;
	private Boolean sexta = true;
	private Boolean sabado = false;

}
