package entities;

public class Conta {
	protected Integer numero;
	protected String titular;
	protected Double saldo;

	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void saque(Double valor) {
		double taxa = 5.0;
		this.saldo -= valor + taxa;
	}
	
	public void deposito(Double valor) {
		this.saldo += valor;
	}

}
