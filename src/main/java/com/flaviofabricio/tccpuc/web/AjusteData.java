package com.flaviofabricio.tccpuc.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Classe para configurar formatação de data utilizada  na 
* determinação de data da presença do aluno no banco de dados.  
*     	  
* @author            Flávio Fabrício Ventura de Melo Ferreira
*/
public class AjusteData {

    /**
     * Formatação em dia-mês-ano hora-minuto.
     */
    private static final DateFormat 
    			 DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    /**
     * Função utilizada pra criação de objeto Date a partir de sting de data no
     * formato padrão brasileiro
     * 
     * @param dateString 	String de formatação em dias-mês-ano hora-minuto
     * @return			Objeto Date criado a partir de data entrada no
     * 				formatado dia-mês-ano hora-minuto.
     */
        public static Date createDateFromDateString(String dateString){
        Date date = null;
        if(null != dateString){
            try{
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    
    }
}
