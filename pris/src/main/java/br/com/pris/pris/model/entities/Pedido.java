package br.com.pris.pris.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	
	@ManyToOne
	@JoinColumn(name = "perfil_cliente")
	@JsonIgnoreProperties("pedido")
	private Perfil_cliente perfil_cliente;
	
	private int status;
	private LocalDateTime data_pedido;
	private LocalDate data_entrega;
	private Double desconto;
	
}
