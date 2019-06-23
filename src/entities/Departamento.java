package entities;

public class Departamento {
	private String nome;
	
	//construtores padrao e recebendo nome como atributo
	public Departamento() {

}
	public Departamento(String nome) {
		this.nome = nome;
	}
	
	
	//getters and setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
