package entities;

public class ContaNegocio extends Conta {

	private Double limiteEmprestimo;
	
	public ContaNegocio() {
		super();
	}
	
	public ContaNegocio(Integer numero, String titular, Double saldo, Double limiteEmprestimo) {
		super(numero, titular, saldo);
		this.limiteEmprestimo = limiteEmprestimo;
	}

	
	public Double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(Double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}

	public void emprestimo(double valor) {
		double taxa = 10.0;
		if(valor <= limiteEmprestimo) {
			saldo += valor - taxa;
		}
	}
	
	@Override
	public void saque(Double valor) {
		super.saque(valor);
		saldo -= 2.0;
	}
	
}
