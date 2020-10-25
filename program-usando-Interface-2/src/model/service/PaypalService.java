package model.service;

public class PaypalService implements PagamentoOnlineService {
	
	/*
	 * Cálculos (1% de juros simples mensais + 2% de taxa de pagamento):
	 */
	private static final double TAXA_PORCENTAGEM = 0.02;
	private static final double JUROS_MENSAIS = 0.01;
	
	@Override
	public double taxaPagamento(double valor) {
		return valor * TAXA_PORCENTAGEM;
	}

	@Override
	public double juros(double valor, int meses) {
		return valor * JUROS_MENSAIS * meses;
	}

}
