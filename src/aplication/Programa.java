package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner ler=new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o nome do departamento:");
		String nomeDepartamento = ler.nextLine();
		System.out.println("Entre com os dados do trabalhador");
		System.out.print("Nome:");
		String nomeTrabalhador = ler.nextLine();
		System.out.println("nivel:");
		String nivelTrabalhador = ler.nextLine();
		System.out.println("Salario Base:");
		double salarioBase = ler.nextDouble();
		
		
		//instancia um trabalhador
		
		Trabalhador trabalhador1 = new Trabalhador(nomeTrabalhador,NivelTrabalhador.valueOf(nivelTrabalhador),salarioBase,new Departamento(nomeDepartamento));
		
		// argumentos nivel trabalhador= passa o argumento na forma de string para Nivel trabalhador enumerado na classe Nivel Trabalhador
		// departamento instancia um departamento que é outra classe passando o nome como argumento. associa um objeto departamento ao trabalhador
		
		
		System.out.println("Quantos contratos terá esse trabalhador");
		int qtd = ler.nextInt();
		
		//para receber os dados de cada contrato
		for(int i=1; i<=qtd ; i++) {
			System.out.println("Entre com os dados do contrato #"+ i);
			System.out.print("Data DD/MM/AAAA:");     // para aceitar uma data nesse formato precisa criar um simple date format no inicio do programa
			Date dataContrato = sdf.parse(ler.next());  // ler next para capturar a string da data digitada pelo usuario 
			                     //essa parte da um excecao que por enquanto esta corrigida aceitando a opcao o eclipse de throws declaration
			System.out.print("valor por hora:");
			double valorPorHora = ler.nextDouble();
			System.out.println("Duracao do contrato: (horas)");
			int horas = ler.nextInt();
			
			//instancia o contrato
			HoraContrato contrato = new HoraContrato(dataContrato,valorPorHora,horas);
			//associas esse contrato ao trabalhador chama o metodo 
			trabalhador1.addContrato(contrato);
		}
			
			
			System.out.println();
			//verificar ganhos do trabalhador
			System.out.print("Entre com mes ano para ver os ganhos: (MM,YYYY)");
			//capturar a string inteira com mes ano
			String mesEAno = ler.next();
			//agora vamos separar o mes e o ano e converter para inteiro 
			int mes = Integer.parseInt(mesEAno.substring(0, 2));                    // mesEAno.substring(0, 2) captura a parte da string com os elementos de 0 e 1 o 2 nao entra
			//integer parseint converte para inteiro o valor capturado da string
			int ano = Integer.parseInt(mesEAno.substring(3)); //recorta da posicao 3 em diante
			
			//mostrar os dados do trabalhador e seu ganho no periodo solicitado
			System.out.println("Nome: "+trabalhador1.getNome());
			System.out.println("Departamento: "+trabalhador1.getDep().getNome()); //pega o nome dentro do departamento
			System.out.println("Ganhos de "+mesEAno+ ":"+ String.format("%.2f",trabalhador1.ganhos(ano, mes) ));
			//string format e para exibir com duas casa decimais o valor
			
		
		
		
		
		
		ler.close();
	}

	
	
	   
}
