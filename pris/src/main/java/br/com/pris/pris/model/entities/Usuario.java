package br.com.pris.pris.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank(message = "Nome deve ser preenchido.")
	@Size (min = 3, message = "Nome deve ter mais que 2 caracteres.")
	private String nome;
	
	@Column(unique = true)
	@Email
	@Pattern(regexp="^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$", message = "Email deve ser um endereço de e-mail bem formado")
    private String email;
    
	@Column
    private String senha;
    
	@Column
    private boolean isAdmin;
	
	private Integer idPessoa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa", insertable=false, updatable=false)
	@JsonIgnoreProperties("usuario")
	private Pessoa pessoa;
}
