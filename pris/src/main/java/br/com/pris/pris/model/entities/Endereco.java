package br.com.pris.pris.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEndereco;
	
	private Integer idPessoa;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa", insertable=false, updatable=false)
	@JsonIgnore
	private Pessoa pessoa;
	
	@NotBlank(message = "Campo CEP deve estar preenchido")
	@Pattern(regexp = "^\\d{5}-\\d{3}$", message = "Campo CEP deve estar preenchido")
	private String cep;
	
	@NotBlank(message = "Campo Logadouro deve estar preenchido")
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "Campo Bairro deve estar preenchido")
	private String bairro;
	
	@NotBlank(message = "Campo Localidade deve estar preenchido")
	private String localidade;
	
	@NotBlank(message = "Campo UF deve estar preenchido")
	private String uf;

}
