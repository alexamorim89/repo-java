package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ContratoService {
	
	private PagamentoOnlineService pagamentoOnlineService;
	
	public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
		this.pagamentoOnlineService = pagamentoOnlineService;
	}

	public void processaContrato(Contrato contrato, int meses) {
		double quotaBasica = contrato.getValorTotal() / meses;
		
		for (int i = 1; i <= meses; i++) {
			Date data = adicionaMeses(contrato.getData(), i);
			double quotaAtualizada = quotaBasica  + pagamentoOnlineService.juros(quotaBasica, i);
			double quotaCompleta = quotaAtualizada + pagamentoOnlineService.taxaPagamento(quotaAtualizada);
			
			contrato.adicionaParcela(new Parcela(data, quotaCompleta));
			
		}
		
	}
	
	private Date adicionaMeses(Date data, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
	
}
