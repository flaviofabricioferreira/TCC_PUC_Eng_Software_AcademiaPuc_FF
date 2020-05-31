package com.flaviofabricio.tccpuc.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviofabricio.tccpuc.entity.Aluno;
import com.flaviofabricio.tccpuc.repository.RepositoriodeAlunos;


/**
* Classe referente ao Serviço responsável pela interação da classe Aluno 
* com o banco de dados.  
*     	  
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
@Service
public class ServicoAluno {
    
    /**
     * Instanciação da Interface de Repositório de Alunos.
     */
    private RepositoriodeAlunos repositoriodeAlunos;
    
    /**
     * Construtor da classe ServicoAluno e responsável pelo cadastramento da 
     * lista de alunos iniciais no banco de dados.
     * 
     * @param repositoriodeAlunos Interface da classe Aluno com banco de dados.
     */
    @Autowired
    public ServicoAluno(RepositoriodeAlunos repositoriodeAlunos) {
	this.repositoriodeAlunos = repositoriodeAlunos;
	cadastrarAlunosnoBancoInicial();
    }
        
    /**
     * Função responsável pelo cadastro de um aluno no banco de dados.
     * 
     * @param aluno Objeto aluno o qual será salvo/cadastrado no banco de dados.
     */
    public void cadastrarAlunoNoBanco(Aluno aluno) {
 	this.repositoriodeAlunos.save(aluno);
    }
    
    /**
     * 
     * Função responsável pela recuperação de um aluno do banco de dados.
     * 
     * @param id Identificador do aluno do banco de dados.
     * @return Objeto do tipo aluno recuperado do banco de dados.
     */
    public Aluno recuperarAlunodoBanco(Integer id) {
	Aluno aluno = this.repositoriodeAlunos.findById(id).get(); 
	return aluno;
    }
    
    /**
     * Função responsável pela recuperação de uma lista de alunos do banco de 
     * dados.
     * 
     * @return Lista de objetos do tipo aluno recuperado do banco de dados.
     */
    public List<Aluno> recuperarListadeAlunosdoBanco() {
	List<Aluno> ListaAlunosRecuperados = this.repositoriodeAlunos.findAll(); 
	//Impressão de Aluno Recuperados para necessidade de Debug
	//ListaAlunosRecuperados.forEach(alunoRecuperado ->{System.out.println(alunoRecuperado.toString());});
	return ListaAlunosRecuperados;
    }
    
    // 
    /**
     * Função responsável por cadastrar no inicio da execução da aplicação, uma 
     * lista 36 alunos no banco de dados.  
     */
    public void cadastrarAlunosnoBancoInicial() {
	this.repositoriodeAlunos.save(new Aluno(12451,"Júlia Bonfim","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12452,"João Paulo","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12453,"Luciana Rodrigues","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12454,"Rodrigo Amaral","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12455,"Leticia Januze","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12456,"Francisco Uchoa","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12457,"Jessica Martiniani","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12458,"Carlos Alberto","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12459,"Bruna Guarda","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12460,"Paulo Roberto","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12461,"Amanda José","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12462,"Pedro Paulo","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12463,"Camila Santos","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12464,"Lucas Sampaio","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12465,"Sandra Neves","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12466,"Luiz Claudio","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12467,"Aline Barbosa","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12468,"Marcos Paulo","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12469,"Patrícia Amaral","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12470,"Gabriel Lins","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12471,"Fernanda Monteiro","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12472,"Rafael Santos","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12472,"Márcia Ventura","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12473,"Daniel Bosco","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12474,"Juliana Gonçalves","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12475,"Bruno Raphael","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12476,"Adriana Calcanhoto","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12477,"Marcelo Brandão","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12478,"Antônia Barbosa","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12479,"Eduardo Braga","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12480,"Francisca Maria","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12481,"Felipe José","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12482,"Ana Clara","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12483,"Raimundo Fagner","111.222.333-44","78654", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(12484,"Vanessa da Matta","111.222.333-44","78654", "Rua A"));;
	this.repositoriodeAlunos.save(new Aluno(12485,"Mariana Pinha","111.222.333-44","78654", "Rua A"));
    }   
}
