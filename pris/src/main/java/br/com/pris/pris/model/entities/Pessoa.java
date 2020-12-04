package br.com.pris.pris.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPessoa;
	
	@NotBlank(message = "Nome deve ser preenchido.")
	@Size (min = 3, message = "Nome deve ter mais que 2 caracteres.")
	private String nome;

	@Column(unique = true)
	@CPF(message = "CPF inválido")
	@Pattern(regexp="^(\\d{3}.\\d{3}.\\d{3}-\\d{2})$", message = "CPF deve seguir o padrão NNN.NNN.NNN-NN")
	private String cpf;
	
	private String razaoSocial;

	@Column(unique = true)
	@CNPJ(message = "CNPJ inválido")
	@Pattern(regexp="^(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})$", message = "CNPJ deve seguir o padrão NN.NNN.NNN.NNNN-NN")
	private String cnpj;
	
	private String foto;	
	
	@Column(unique = true)
	@Email
	@Pattern(regexp="^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$", message = "Email deve ser um endereço de e-mail bem formado")
    private String email;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("pessoa")
	private List<Telefone> telefones;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("pessoa")
	private List<Endereco> enderecos;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("pessoa")
	private List<Pedido> pedidos;
	
	
}
