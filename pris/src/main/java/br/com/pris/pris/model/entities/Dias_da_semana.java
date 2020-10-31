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
public class Dias_da_semana {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_dias_da_semana;
	
	@ManyToOne
	@JoinColumn(name = "perfil_cliente")
	@JsonIgnoreProperties("dias_da_semana")
	private Perfil_cliente perfil_cliente;
	
	private Boolean domingo;
	private Boolean segunda;
	private Boolean terca;
	private Boolean quarta;
	private Boolean quinta;
	private Boolean sexta;
	private Boolean sabado;

}
