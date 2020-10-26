package com.local.pedidovenda.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.local.pedidovenda.model.Usuario;
import com.local.pedidovenda.repository.PedidoRepository;
import com.local.pedidovenda.security.UsuarioLogado;
import com.local.pedidovenda.security.UsuarioSistema;

@Named
@RequestScoped
public class GraficoPedidosCriadosBean {
	
	private DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM");
	
	@Inject
	private PedidoRepository pedidoRepository;
	
	@Inject
	@UsuarioLogado
	private UsuarioSistema usuarioLogado;

	private CartesianChartModel model;	
	
	
	public void preRender() {
		this.model =  new CartesianChartModel();
		
		this.adiconarSerie("Todos os pedidos", null);
		this.adiconarSerie("Meus Pedidos", usuarioLogado.getUsuario());		
	}	

	private void adiconarSerie(String rotulo, Usuario criadoPor) {
		Map<Date, BigDecimal> valoresPorData = this.pedidoRepository.valoresTotaisPorData(15, criadoPor);
		
		ChartSeries series = new ChartSeries(rotulo);
		
		for (Date data : valoresPorData.keySet()) {
			series.set(DATE_FORMAT.format(data), valoresPorData.get(data));
		}		
		this.model.addSeries(series);		
	}

	public CartesianChartModel getModel() {
		return model;
	}	
}