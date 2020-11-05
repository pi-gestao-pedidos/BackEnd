package br.com.pris.pris.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	private int id_endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "perfil_cliente", referencedColumnName = "cpf_cnpj")
	@JsonIgnoreProperties("endereco")
	private Perfil_cliente perfil_cliente;
	
	private String cep;
	private String logradouro;
	private String completemento;
	private String bairro;
	private String localidade;
	private String uf;

}
