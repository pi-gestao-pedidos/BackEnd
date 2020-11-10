package br.com.pris.pris.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

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
	private int idPedido;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@JsonIgnoreProperties("pedido")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "pedido")
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> produtos;
	
	private Integer status;

	private LocalDateTime dataPedido;
	private LocalDate dataPntrega;
	
	@NotBlank(message = "Desconto deve possuir um valor")
	@DecimalMin(value = "0.00", message = "Desconto deve ser maior ou igual a 0.00")
	private Double desconto;
	
	private BigDecimal total;
	
}
