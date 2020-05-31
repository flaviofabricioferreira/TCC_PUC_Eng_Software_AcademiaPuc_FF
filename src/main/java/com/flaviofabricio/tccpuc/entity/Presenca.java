package com.flaviofabricio.tccpuc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
* Classe referente as datas em que o aluno compareceu a academia.  
*     	  
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
@Entity
public class Presenca {
    
    /**
     * Identificador da presença do aluno no banco de dados
     */
    @Id
    @GeneratedValue
    private int id;
    
    /**
     * Data da presença do aluno.
     */
    private Date dataPresenca;
    
    /**
     * Aluno relacionado a presença.
     */
    @ManyToOne
    @JoinColumn
    private Aluno aluno;
    
    /**
     * Construtor vazio da classe Presença.
     */
    public Presenca() {}
    
    /**
     * Constutor da classe Presença onde o ID é gerado automaticamente.
     */
    public Presenca(Aluno aluno, Date dataPresenca) {
	this.aluno = aluno;
	this.dataPresenca = dataPresenca;
    }
    
    /**
     * Função para impressão no console dos parametros da classe Presença.
     */
    @Override
    public String toString() {
	return " Id_Presença='" + this.id + '\'' + 
		", Nome Aluno ='" + this.aluno.getNome() + '\'' +
		", Data da Presenca ='" + this.dataPresenca + "\'";
    }

    /**
     * @return retorna o identificador da presença no banco de dados.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id determina o identificador da presenca no banco de dados.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return retorna a data da presença.
     */
    public Date getDataPresenca() {
        return dataPresenca;
    }

    /**
     * @param dataPresenca determina a data da presenca.
     */
    public void setDataPresenca(Date dataPresenca) {
        this.dataPresenca = dataPresenca;
    }
    
    /**
     * @return retorna o objeto Aluno relacionado aa presença.
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno determina o objeto Aluno da presenca.
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
}
