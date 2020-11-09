package br.com.pris.pris.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class EntradaEstoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEntrada;
	
	@ManyToOne
	@JoinColumn(name = "idMaterial")
	@JsonIgnoreProperties("entradaEstoque")
	private Material material;
	
	private LocalDate data;
	private Integer quantidade;
	private BigDecimal custo;

}
