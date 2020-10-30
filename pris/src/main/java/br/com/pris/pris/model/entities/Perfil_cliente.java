package br.com.pris.pris.model.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Perfil_cliente {
	
	@Id
	private String cpf_cnpj;
	private String nome;
	private String razao_social;
	private String email;
	private String foto;
	private Boolean perfil_ou_cliente;
	private String senha;
	private Double salario;
	private String carga_horaria;
	
	@OneToMany(mappedBy = "perfil_cliente", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("perfil_cliente")
	private List<Pedido> pedido;
	
	@OneToMany(mappedBy = "perfil_cliente", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("perfil_cliente")
	private List<Telefone> telefone;
	
	@OneToOne(mappedBy = "perfil_cliente", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("perfil_cliente")
	private List<Endereco> endereco;
	
	@OneToMany(mappedBy = "perfil_cliente", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("perfil_cliente")
	private List<Despesa> despesa;
	
	@OneToOne(mappedBy = "perfil_cliente", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("perfil_cliente")
	private List<Dias_da_semana> dias_da_semana;
	
}
