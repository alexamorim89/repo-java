package entities;

public class FuncionarioTercerizado extends Funcionario {

	private Double cobrancaAdicional;

	public FuncionarioTercerizado() {
		super();
	}

	public FuncionarioTercerizado(String nome, Integer horas, Double valorPorHora, Double cobrancaAdicional) {
		super(nome, horas, valorPorHora);
		this.cobrancaAdicional = cobrancaAdicional;
	}

	public Double getCobrancaAdicional() {
		return cobrancaAdicional;
	}

	public void setCobrancaAdicional(Double cobrancaAdicional) {
		this.cobrancaAdicional = cobrancaAdicional;
	}

	@Override
	public double formaPagamento() {
		return super.formaPagamento() + cobrancaAdicional * 1.1;
	}

}
