package br.com.pris.pris.model.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.model.entities.Produto;
import br.com.pris.pris.model.repositories.ProdutoRepository;

@Service
@Validated
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private DespesaService despesas;
	
	/*@Autowired
	private DespesaProdutoService despesaProduto;*/
	
	@Autowired
	private FuncionarioService funcionario;
	
	@Autowired
	private MaterialProdutoService material;
	

	public Produto addProduto(@Valid Produto produto) {
		return this.repository.save(produto);
	}

	public Iterable<Produto> findAllProdutos() {
		return repository.findAll();
	}

	public Produto findProdutoById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"O Produto não foi encontrado."));
	}

	public Produto changeProduto(@Valid Produto produto, Integer id) {
		this.findProdutoById(id);
		produto.setIdProduto(id);
		return this.addProduto(produto);
	}

	public void deleteProduto(Integer id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"O Produto não foi encontrado.");
			}
	}
	
	public String estimateProdutoPrice(Integer id) {
		List<BigDecimal> custoFixoList = new ArrayList<>();
		this.despesas.findAllDespesas().forEach(despesa -> custoFixoList.add(despesa.getValor()));
		this.funcionario.findAllFuncionarios().forEach(salario -> custoFixoList.add(salario.getSalario()));
		BigDecimal custoFixo = custoFixoList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		
		List<BigDecimal> custoVariavelList = new ArrayList<>();
		this.findProdutoById(id).getDespesas().forEach(despesa -> custoVariavelList.add(despesa.getValor()));
		BigDecimal custoVariavel = custoVariavelList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		
		List<Integer> tempoTrabalhoList = new ArrayList<>();
		this.funcionario.findAllFuncionarios().forEach(e -> tempoTrabalhoList.add(this.funcionario.showCargaHorariaTotal(e.getIdPessoa())));
		Integer tempo = tempoTrabalhoList.stream().reduce(0, Integer::sum);
		
		Integer tempoProducao = this.findProdutoById(id).getTempo();
		
		BigDecimal custoMateriais = this.material.custoTotal(id);
		
		return (((custoFixo.divide(BigDecimal.valueOf(tempo))).multiply(BigDecimal.valueOf(tempoProducao))).add(custoVariavel).add(custoMateriais)).toString();
	}
}
