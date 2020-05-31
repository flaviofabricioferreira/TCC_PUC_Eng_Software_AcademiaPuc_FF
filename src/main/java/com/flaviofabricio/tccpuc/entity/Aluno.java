		
package com.flaviofabricio.tccpuc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
* Classe referente aos dados de cadastro do aluno de determinada academia.  
*
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
@Entity
public class Aluno {

    /**
     * Identificador do aluno no banco de dados
     */
    @Id
    @GeneratedValue
    private int id;   
    
   
    /**
     * Nome do aluno.
     */
    private String nome;
    /**
     * Número de cpf do aluno.
     */
    private String cpf; // TIPO PLANO -> CPF
    /**
     * Número de rg do aluno.
     */
    private String rg; // TELEFONE -> RG

    /**
     * Campo para cadastro de endereco do aluno.
     */
    private String endereco; // COMENTARIO -> ENDEREÇO
    
    /**
     * Número de matrícula do aluno.
     */
    private int matricula;
    
    
    
    
    /**
    * Lista das datas de presença do aluno na academia.
    * 
    * FetchType options
    *	EAGER = To load all data from "One" Entity together with the "Many" 
    *		Entity fields(All)
    *	LAZY =  To load only "One" Entity and load on-demand "Many" Entity 
    *		fields when you call the  getList() methods.
    *
    *CascadeType options
    *	ALL = 	   Any change happened on "One" Entity must cascade to "Many" 
    *		   Entity as well. If you save an "One" Entity,then all 
    *		   associated "Many" Entities will also be saved into database. 
    *		   If you delete an "One" Entity then all accounts associated 
    *		   with that "One" Entity also be deleted("Many" Entities)
    *	PERSIST =  when save() or persist() methods are called using "One" 
    *		   Entity instance then only "Many" Entities will be persisted. 
    *		   If any other method is called on session, it’s effect will 
    *		   not affect/cascade "Many" Entities
    */
    @OneToMany(mappedBy = "aluno",fetch = FetchType.EAGER,cascade = CascadeType.ALL)   
    private List<Presenca> listaPresencas = new ArrayList<>();
    
    
    /**
     * Construtor vazio da classe Aluno
     */
    public Aluno(){}
    
    /**
     * Constutor da classe Aluno onde o ID é gerado automaticamente.
     */
    public Aluno(int numero_matricula,String nome_aluno,String cpf,String rg,String endereco) {
	 this.matricula = numero_matricula;
	 this.nome = nome_aluno;
	 this.cpf = cpf;
	 this.rg = rg;
	 this.endereco = endereco;
    }
    
    
    
    /**
     * Função para impressão no console dos parametros da classe Aluno.
     */
    @Override
    public String toString() {
	return " nome_aluno='" + this.nome + '\'' + 
		", matricula ='" + this.matricula + '\'' +
		", tipo do plano ='" + this.cpf + '\'' +
		", rg ='" + this.rg + '\'' +
		", endereco ='" + this.endereco + "\'";
    }
    
    /**
     * @return retorna o identificador do aluno.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id determina o identificador do aluno no banco de dados.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return retorna o nome do aluno no banco de dados.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome_aluno determina o nome do aluno.
     */
    public void setNome(String nome_aluno) {
        this.nome = nome_aluno;
    }

    /**
     * @return retorna o número da matricula do aluno.
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param numero_matricula determina o número de matricula do aluno.
     */
    public void setMatricula(int numero_matricula) {
        this.matricula = numero_matricula;
    }

    /**
     * @return retorna o cpf do aluno.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf determina o cpf do aluno.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return retorna o número de rg do aluno.
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg determina o número de rg do aluno.
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return retorna o endereço do aluno.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco determina o cendereço do aluno.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }   
    
    /**
     * @return retorna a lista de datas de presençã do aluno.
     */
    public List<Presenca> getListaPresencas() {
        return listaPresencas;
    }

    /**
     * @param presenca determina a lista de datas de presenção do aluno.
     */
    public void addPresenca(Presenca presenca) {
        this.listaPresencas.add(presenca);
    }

}

