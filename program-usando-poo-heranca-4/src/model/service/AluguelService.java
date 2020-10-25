package model.service;

import model.entities.AluguelDeCarro;
import model.entities.Fatura;

public class AluguelService {
	private Double precoPorDia;
	private Double precoPorHora;
	
	private ImpostoService impostoService;

	public AluguelService(Double precoPorDia, Double precoPorHora, ImpostoService impostoService) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.impostoService = impostoService;
	}
	
	
	
	public void processarFatura(AluguelDeCarro aluguelDeCarro) {
		long t1 = aluguelDeCarro.getInicio().getTime();
		long t2 = aluguelDeCarro.getFim().getTime();
		double horas = (double)(t2 - t1) / 1000 / 60 / 60;
		
		double pagamentoBasico;
		if(horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		} else {
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
		}
		
		double imposto = impostoService.imposto(pagamentoBasico);
		aluguelDeCarro.setFatura(new Fatura(pagamentoBasico, imposto));
	}
	
}
