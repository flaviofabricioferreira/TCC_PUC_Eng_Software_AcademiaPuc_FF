package com.flaviofabricio.tccpuc.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.flaviofabricio.tccpuc.business.service.ServicoAluno;
import com.flaviofabricio.tccpuc.business.service.ServicoPresenca;
import com.flaviofabricio.tccpuc.entity.Aluno;


/**
* Classe referente ao Controlador responsável pela interação da classe Presenca 
* com a visualização Web(HTML) a partir do Modelo.  
*     	  
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
@Controller
public class ControladorPresencas {
    
    /**
     * Instanciação do Serviço de Presencas responsável pela interação da classe 
     * Presenca com o banco de dados.
     */
    private ServicoPresenca servicoPresenca;
    /**
     * Instanciação do Serviço de alunos responsável pela interação da classe 
     * Aluno com o banco de dados.
     */
    private ServicoAluno servicoAluno;

    /**
     * Construtor da classe ControladorPresencas responsável pela interação da 
     * classe Presenca com a visualização Web(HTML) a partir do Modelo.
     * 
     * @param servicoAluno 	Serviço de alunos responsável pela interação da 
     * classe Aluno com o banco de dados.
     * @param servicoPresenca	Serviço de presenças responsável pela interação 
     * da classe Presença com o banco de dados.
     */
    @Autowired
    public ControladorPresencas(ServicoAluno servicoAluno,ServicoPresenca servicoPresenca) {
	this.servicoPresenca = servicoPresenca;
	this.servicoAluno = servicoAluno;
    }

    /**
     * Função responsável pela recuperação da lista de presencas de um aluno de 
     * acordo com o identificador e em sequência,a exibição de página web com 
     * a lista destas presenças.
     * 
     * @param id     Identificador do aluno cadastrado no banco de dados.
     * @param model  Modelo utilizado para passagem das informações referentes a 
     * lista de presenças armazenadas na classe Aluno para o arquivo Web(HTML), 
     * permitindo desta forma que os dados sejam apresentados de acordo com a 
     * formatação elaborada no arquivo "listapresencasaluno.html". 
     * 
     * @return       nome do arquivo html. 
     */
    @GetMapping("/listarPresencasAluno") // Jogar para Controlador de Alunos
    public String ListarPresencas(Integer id, Model model) {
	Aluno alunoX = this.servicoAluno.recuperarAlunodoBanco(id);
		
	model.addAttribute("alunoX", alunoX);
    
	Map<String, Integer> graphData = this.servicoPresenca.recuperarEstatisticaPresenca(alunoX);
    
    model.addAttribute("chartData", graphData);
	
	return "listapresencasaluno";
    };
    
    /**
     * Função responsável pelo cadastro da presenca na academia de um aluno no 
     * banco de dados, e em sequência, a exibição de página web com lista de 
     * todas as presencas cadastrados no sistema da academia referentes a este
     * aluno.
     *  
     * @param id     Identificador do aluno cadastrado no banco de dados.
     * @param model  Modelo utilizado para passagem das informações referentes a 
     * a presença armazenada na classe Aluno para o arquivo Web(HTML), 
     * permitindo desta forma que os dados sejam apresentados de acordo com a 
     * formatação elaborada no arquivo "listapresencasaluno.html".
     * 
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/cadastrarPresencaAluno")
    public String cadastratPresenca(Integer id, Model model) throws InterruptedException {
	Aluno alunoX = this.servicoAluno.recuperarAlunodoBanco(id);
	this.servicoPresenca.cadastrarPresencaNoBanco(alunoX);
	model.addAttribute("alunoX", alunoX);
	return "listapresencasaluno";
    };   
        
}
