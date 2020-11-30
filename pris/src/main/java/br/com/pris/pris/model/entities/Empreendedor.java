package br.com.pris.pris.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

//	@Column(unique = true)
//	@NotBlank(message = "Campo Email deve estar preenchido")
//	@Email
//	@Pattern(regexp = "^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$", message = "Email deve ser um endereço de e-mail bem formado")
//	private String email;
//
//	@NotBlank(message = "Campo Senha deve estar preenchido")
////	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-?])[a-zA-Z0-9!-?]{8,}$", message = "Senha deve conter no mínimo 8 caracteres, dos quais deve possuir no mínimo 1 letra, 1 número e 1 caractere especial.")
//	private String senha;
	

	@OneToMany(mappedBy = "pessoa")
	@JsonIgnoreProperties("despesa")
	private List<Despesa> despesas;
	

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	@JsonIgnoreProperties({"pessoa", "senha", "nome", "email", "idPessoa"})
	private Usuario usuario;
}
