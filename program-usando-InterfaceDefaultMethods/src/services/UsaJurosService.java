package services;

public class UsaJurosService implements JurosService {
	
	private double taxaJuros;

	public UsaJurosService(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	@Override
	public double getTaxaJuros() {
		return taxaJuros;
	}
}
