package br.com.pris.pris.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@DiscriminatorValue("cliente")
public class Cliente extends Pessoa{
	
	@Column(unique = true)
	@Email
	@Pattern(regexp="^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$", message = "Email deve ser um endereço de e-mail bem formado")
	private String email;
	
	@OneToMany(mappedBy = "pessoa")
	@JsonIgnore//Properties("pessoa")
	private List<Pedido> pedidos;
	
}
