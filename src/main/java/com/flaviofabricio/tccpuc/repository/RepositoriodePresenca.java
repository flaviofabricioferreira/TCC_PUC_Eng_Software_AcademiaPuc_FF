package com.flaviofabricio.tccpuc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flaviofabricio.tccpuc.entity.Presenca;

/**
* Interface referente ao repositório de presencas do aluno no banco de dados.  
*     	  
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
@Repository
public interface RepositoriodePresenca extends JpaRepository<Presenca, Integer>{

}
