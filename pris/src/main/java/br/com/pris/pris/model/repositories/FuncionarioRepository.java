package br.com.pris.pris.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.pris.pris.model.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

}
