package com.flaviofabricio.tccpuc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flaviofabricio.tccpuc.entity.Aluno;


/**
* Interface referente ao repositório de alunos no banco de dados.  
*     	  
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
@Repository
public interface RepositoriodeAlunos extends JpaRepository<Aluno, Integer> {

}
