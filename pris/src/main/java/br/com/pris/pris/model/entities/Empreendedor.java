package br.com.pris.pris.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
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
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("empreendedor")
public class Empreendedor extends Funcionario {

	@Column(unique = true)
	@NotBlank(message = "Campo Email deve estar preenchido")
	@Email
	@Pattern(regexp = "^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$", message = "Email deve ser um endereço de e-mail bem formado")
	private String email;

	@NotBlank(message = "Campo Senha deve estar preenchido")
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-?])[a-zA-Z0-9!-?]{8,}$", message = "Senha deve conter no mínimo 8 caracteres, dos quais deve possuir no mínimo 1 letra, 1 número e 1 caractere especial.")
	private String senha;

	@OneToMany(mappedBy = "pessoa")
	@JsonIgnoreProperties("pessoa")
	private List<Despesa> despesas;
}
