package services;

public class BrasilJurosService implements JurosService {
	private double taxaJuros;

	public BrasilJurosService(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	@Override
	public double getTaxaJuros() {
		return taxaJuros;
	}
	
}
