package br.com.pris.pris.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@DiscriminatorValue("funcionario")
public class Funcionario extends Pessoa{
	
	@Column(unique = true)
	@Email
	@Pattern(regexp="^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$", message = "Email deve ser um endereço de e-mail bem formado")
	private String email;
	
	private BigDecimal salario;
	private String cargaHoraria;
	
	@OneToOne(mappedBy = "pessoa")
	@JsonIgnoreProperties("pessoa")
	private Semana semana;

}
