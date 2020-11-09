package br.com.pris.pris.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@JsonIgnoreProperties("endereco")
	private Pessoa pessoa;
	
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

}
