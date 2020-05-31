package com.flaviofabricio.tccpuc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flaviofabricio.tccpuc.business.service.ServicoAluno;
import com.flaviofabricio.tccpuc.entity.Aluno;

/**
* Classe referente ao Controlador responsável pela interação da classe Aluno 
* com a visualização Web(HTML) a partir do Modelo.  
*     	  
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
@Controller
public class ControladorAlunos {

    /**
     * Instanciação do Serviço de alunos responsável pela interação da classe 
     * Aluno com o banco de dados.
     */
    private final ServicoAluno servicoAluno;
    
    /**
     * Construtor da classe ControladorAlunos responsável pela interação da 
     * classe Aluno com a visualização Web(HTML) a partir do Modelo.
     * 
     * @param servicoAluno Serviço de alunos responsável pela interação da 
     * classe Aluno com o banco de dados.
     */
    @Autowired
    public ControladorAlunos(ServicoAluno servicoAluno) {
	this.servicoAluno = servicoAluno;
    }
    
    
    
    /**
     * Função responsável pela exibição da Menu de opções da Area do Empregado 
     * 
     * @param model Modelo utilizado para passagem das informações para o 
     * arquivo Web(HTML), permitindo desta forma que os dados sejam 
     * apresentados de acordo com a formatação elaborada no arquivo
     * "menuAreaEmpregado.html". 
     * 
     * @return
     */
    @GetMapping("/areaDoEmpregado")
    public String axibirAreaEmpregados(Model model) {
//	List<Aluno> listaDeAlunos = this.servicoAluno.recuperarListadeAlunosdoBanco();
//	model.addAttribute("listadeAlunos", listaDeAlunos);
	return "menuAreaEmpregados";
    }
    
    
    /**
     * Função responsável pela exibição de página web com formulário para 
     * cadastramento de aluno no sistema da academia.
     * 
     * * @param model Modelo utilizado para passagem das informações armazenadas
     * na classe Aluno para o arquivo Web(HTML), permitindo desta forma que os 
     * dados sejam apresentados de acordo com a formatação elaborada no arquivo
     * "cadastroaluno.html" . 
     * @return nome do arquivo html 
     */
    @GetMapping("/FormulariodeCadastroAluno")
    public String ExibirFormulario(Model model) {
	model.addAttribute("aluno", new Aluno());
	return "cadastroaluno";
    }
    
    /**
     * Função responsável pelo cadastro no banco de dados de um aluno e em 
     * sequência a exibição de página web com lista de todos os alunos 
     * cadastrados no sistema da academia.
     * 
     * @param aluno Objeto aluno o qual será salvo/cadastrado no banco de dados.
     * @return
     */
    @PostMapping("/cadastrarAluno")
    public String cadastrar(@ModelAttribute Aluno aluno) {
	this.servicoAluno.cadastrarAlunoNoBanco(aluno);
	return "redirect:/listarAlunos";
    }
    
    /**
     * Função responsável pela recuperação da lista de todos os alunos 
     * cadastrados no sistema da academia e em sequência, a exibição de página 
     * web com lista dos mesmos.
     * 
     * @param model Modelo utilizado para passagem das informações referente a 
     * lista de todos os Alunos da academia para o arquivo Web(HTML), permitindo
     * desta forma que os dados sejam apresentados de acordo com a formatação 
     * elaborada no arquivo "listalunos.html". 
     * 
     * @return
     */
    @GetMapping("/listarAlunos")
    public String listarAlunos(Model model) {
	List<Aluno> listaDeAlunos = this.servicoAluno.recuperarListadeAlunosdoBanco();
	model.addAttribute("listadeAlunos", listaDeAlunos);
	return "listaalunos";
    }
}