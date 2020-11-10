package br.com.pris.pris.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Pessoa pessoa;

	@NotBlank(message = "Campo Nome deve estar preenchido.")
	private String nome;

	@NotNull(message = "Campo Valor deve estar preenchido.")
	@DecimalMin(value = "0.00", message = "Valor deve ser positivo.")
	private BigDecimal valor;
}
