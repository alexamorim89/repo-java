package entities;

public class Funcionario {
	private int id;
	private String nome;
	private Double salario;
	
	public Funcionario(int id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void aumentarSalario(double pocentagem) {
		salario += salario * pocentagem / 100.0;
	}
	
	@Override
	public String toString() {
		return this.id +", " + this.nome +", " + String.format("%.2f", this.salario);
	}
	
}
