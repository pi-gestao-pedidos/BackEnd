package br.com.pris.pris.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "Campo Salário deve estar preenchido.")
	@DecimalMin(value = "0.00", message = "Salario deve ser positivo.")
	private BigDecimal salario;
	
	@NotBlank(message = "Campo Carga Horária deve estar preenchido.")
	@Min(value = 0, message = "Campo Carga Horária deve ser maior que 0")
	private String cargaHoraria;
	
	@OneToOne(mappedBy = "pessoa")
	@JsonIgnoreProperties("pessoa")
	private Semana semana;

}
