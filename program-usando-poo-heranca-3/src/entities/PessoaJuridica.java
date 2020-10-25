package entities;

public class PessoaJuridica extends Contribuinte {
	private Integer numeroDeFuncionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double imposto() {
		double imposto = 0;
		if(numeroDeFuncionarios > 10) {
			imposto = (rendaAnual * 0.14);
		} else {
			imposto = (rendaAnual *  0.16);
		}
		return imposto;
	}
	
	

}
