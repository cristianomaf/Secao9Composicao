package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String  nome;
	private NivelTrabalhador nivel;
	Double salarioBase;	
	//associaçoes da classe trabalhador
	//1 trabalhador tem um departamento associado
	private Departamento dep;
	//1 trabalhador pode ter varios contratos entao cria-se uma lista do tipo hora contrato
	private List <HoraContrato> contratos = new ArrayList<>();  // instancia a lista nova já 
	
	
	//construtor padrao e com argumentos
	public Trabalhador() {
		
	}
	//no contrutor não se passa o parametro que é uma lista
	public Trabalhador(String nome,NivelTrabalhador nivel, Double salarioBase,Departamento dep) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.dep = dep;
	}
	
	
	//getters and setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public NivelTrabalhador getNivel() {
		return nivel;
	}
	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Departamento getDep() {
		return dep;
	}
	public void setDep(Departamento dep) {
		this.dep = dep;
	}
	public List<HoraContrato> getContratos() {
		return contratos;
	}
	//public void setContratos(List<HoraContrato> contratos) {      // esse set Contratos nao sera implementado pois nao queremos setar a lista de outra forma que nao atraves dos metodos criados depois
    //		this.contratos = contratos;
	//}
	
	
	//metodos adicao contrato e remocao, e metodo ganhos do trabalhador
	
	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);  //pega a lista contratos e add esse contrato recebido como argumento
	}
	
	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);  //remove contrato da lista
	}
	
	
	// parte importante metodo para calcular ganhos do trabalhador em um dado mes4
	
	public double ganhos (int ano, int mes) {      //ganhos passando um ano e mes com atributos
		//primeiro o ganho inicial fica na variavel soma que recebe o salario base como valor inicial
		double soma = salarioBase;
		
		Calendar cal= Calendar.getInstance(); //instancia um variavel do tipo Calendar para captturar a data semelhante ao Scanner usado para captura de dados
		
		
		//for each que percorre a lista
		for(HoraContrato c: contratos) {
			cal.setTime(c.getData());//captura a data do contrato c 
			//o contrato tem uma data que pegaremos o ano e mes
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH); //tem que somar 1 para dar valor certo pois pega de 0 a 11 os meses 
			
			if(ano == c_ano && mes == c_mes) { // verifica se ano passado como argumento é igual ao ano do contrato e mes do contrato e igual mes passado como atributo
				soma+=c.valorTotal();  // se for soma o valor do contrato na variavel soma que possui o salario base como valor inicial
			}
		}
		return soma;
	}
	
	

}
