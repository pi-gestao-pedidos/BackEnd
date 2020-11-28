package br.com.pris.pris.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTelefone;
	
	private Integer idPessoa;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa", insertable=false, updatable=false)
	@JsonIgnoreProperties("pessoa")
	private Pessoa pessoa;
	
	@Pattern(regexp="^(\\d{2})$", message = "DDD deve seguir o padrão 99")
	private String ddd;
	
	@Pattern(regexp="^(\\d?\\d{4}\\-\\d{4})$", message = "Número deve seguir o padrão 99999-9999")
	private String numero;
}
