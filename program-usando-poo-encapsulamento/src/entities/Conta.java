package entities;

public class Conta {
	private int numero;
	private String nome;
	private double saldo;
	
	
	public Conta(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}	
	
	public Conta(int numero, String nome, double depositoInicial) {
		this.numero = numero;
		this.nome = nome;
		depositar(depositoInicial);
	}


	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
		double taxa = 5.00;
		this.saldo -= (valor + taxa);
	}
	
	
	@Override
	public String toString() {
		return "Account " + this.numero 
			+ ", Holder: " + this.nome 
			+ ", Balance: $ " 
			+ String.format("%.2f", this.saldo);
	}
	
}
