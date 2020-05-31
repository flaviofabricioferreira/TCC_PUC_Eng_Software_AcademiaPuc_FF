package com.flaviofabricio.tccpuc.business.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviofabricio.tccpuc.entity.Aluno;
import com.flaviofabricio.tccpuc.entity.Presenca;
import com.flaviofabricio.tccpuc.repository.RepositoriodeAlunos;
import com.flaviofabricio.tccpuc.repository.RepositoriodePresenca;
import com.flaviofabricio.tccpuc.web.AjusteData;

/**
 * Classe referente ao Serviço responsável pela interação da classe presenca com
 * o banco de dados.
 * 
 * @author Flávio Fabrício Ventura de Melo Ferreira
 */
@Service
public class ServicoPresenca {

	/**
	 * Instanciação da Interface de Repositorio de Presencas.
	 */
	private RepositoriodePresenca repositorioDePresenca;

	/**
	 * Instanciação da Interface de Repositorio de Alunos.
	 */
	private RepositoriodeAlunos repositoriodeAlunos;

	/**
	 * Construtor da classe ServicoPresenca e responsável pelo cadastramento da
	 * lista de presencas iniciais de 2 alunos no banco de dados.
	 * 
	 * @param repositorioDePresenca Interface classe Presenca com banco de dados.
	 * @param repositorioDeAlunos   Interface classe Aluno com banco de dados.
	 */
	@Autowired
	public ServicoPresenca(RepositoriodePresenca repositorioDePresenca, RepositoriodeAlunos repositorioDeAlunos) {
		this.repositorioDePresenca = repositorioDePresenca;
		this.repositoriodeAlunos = repositorioDeAlunos;
		popularPresencasIniciais();
	}

	/**
	 * Função responsável pelo cadastro de uma presença do aluno no banco de dados
	 * com data no formato dia-mês-ano.
	 * 
	 * @param aluno Objeto aluno a qual terá uma presenca adicionada na sua lista de
	 *              presencas e salva/cadastrada no banco de dados.
	 */
	public void cadastrarPresencaNoBanco(Aluno aluno) {
		Presenca presencaX = new Presenca(aluno, AjusteData.createDateFromDateString("31-12-2020"));
		aluno.addPresenca(presencaX);
		this.repositorioDePresenca.save(presencaX);
	}

	/**
	 * Função responsável pela recuperação da lista de presenças do banco
	 * de dados.
	 * 
	 * @return Lista de presencas.
	 */
	public List<Presenca> recuperarListadePresencadoBanco() {
		return this.repositorioDePresenca.findAll();
	}
	
	public Map<String, Integer> recuperarEstatisticaPresenca(Aluno aluno) {
		Map<String, Integer> map = new HashMap<>();
		
		List<Presenca> listaPresencas = aluno.getListaPresencas();
		
		for (Presenca presenca : listaPresencas) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(presenca.getDataPresenca());
			String ano = String.valueOf(calendar.get(Calendar.YEAR));
			if (map.containsKey(ano)) {
				Integer quantidade = map.get(ano);
				map.put(ano, quantidade+1);
			} else {
				map.put(ano, 1);
			}
		}
		
		return map;
	}

	/**
	 * Função responsável por cadastrar no inicio da execução da aplicação, as
	 * presenças de 2 alunos por 1 semana cada no banco de dados.
	 * 
	 */
	public void popularPresencasIniciais() {
		List<Presenca> presencas = new ArrayList<>();
		int quantidadeAlunos = 10;
		int limiteDia = 28;
		int limiteMes = 12;
		int inicioAno = 2017;
		int fimAno = 2020;
		Random random = new Random();
		for (int idAluno = 1; idAluno <= quantidadeAlunos; idAluno++) {
			Aluno aluno = this.repositoriodeAlunos.findById(idAluno).get();
			for (int ano = inicioAno; ano <= fimAno; ano++) {
				for (int mes = 1; mes <= limiteMes; mes++) {
					for (int dia = 1; dia <= limiteDia; dia++) {
						if (random.nextBoolean()) {
							presencas.add(new Presenca(aluno, AjusteData
									.createDateFromDateString(String.format("%d-%d-%d %d:%d", dia, mes, ano, random.nextInt(24), random.nextInt(60)))));
						}
					}
				}
			}
		}
		this.repositorioDePresenca.saveAll(presencas);		
	}
}

