package entities;

public final class ContaPoupanca extends Conta {
	private Double taxaDeJuro;

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Integer numero, String titular, Double saldo, Double taxaDeJuro) {
		super(numero, titular, saldo);
		this.taxaDeJuro = taxaDeJuro;
	}

	public Double getTaxaDeJuro() {
		return taxaDeJuro;
	}

	public void setTaxaDeJuro(Double taxaDeJuro) {
		this.taxaDeJuro = taxaDeJuro;
	}
	
	public void atualizarSaldo() {
		saldo += saldo * taxaDeJuro;
	}
	
	@Override
	public void saque(Double valor) {
		saldo -= valor;
	}
	
}
