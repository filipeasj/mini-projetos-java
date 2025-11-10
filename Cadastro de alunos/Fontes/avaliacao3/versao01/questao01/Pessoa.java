package avaliacao3.versao01.questao01;

// Encapsulamento de dados biofísicos e operações com pessoas
public class Pessoa {

	private String nome;	// nome
	private double peso;	// peso em quilogramas
	private double altura;	// altura em metros
	
	// construtor
	public Pessoa(String nome, double peso, double altura) throws IllegalArgumentException {
		// lançamento de exceção se peso ou altura não for positivo
		if (peso <= 0 || altura <= 0)
			throw new IllegalArgumentException("Peso ou altura ou ambos inválidos!");
		
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}

	// retorno de nome da pessoa
	public String getNome() {
		return nome;
	}

	// retorno de peso da pessoa
	public double getPeso() {
		return peso;
	}

	// retorno de altura da pessoa
	public double getAltura() {
		return altura;
	}
	
	// cálculo e retorno de IMC da pessoa
	public double getIMC() {
		return peso / (altura * altura);
	}
	
}