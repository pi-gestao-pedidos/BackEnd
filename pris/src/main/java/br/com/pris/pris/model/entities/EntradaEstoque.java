package br.com.pris.pris.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private Integer idMaterial;
	
	@ManyToOne
	@JoinColumn(name = "idMaterial", insertable=false, updatable=false)
	@JsonIgnore
	private Material material;
	
	@NotNull(message = "Campo data deve estar preenchido")
	@DateTimeFormat(pattern = "dd/MM/yyyy") // Editar – Não foi validado
	private LocalDate data;
	
	@NotNull(message = "Campo Logadouro deve estar preenchido")
	@Min(value = 1, message = "Quantidade deve ser maior que 0.")
	private Integer quantidade;
	
	@NotNull(message = "Campo Custo deve estar preenchido")
	@DecimalMin(value = "0.00", message = "Custo deve ser positivo.")
	private BigDecimal custo;
}
