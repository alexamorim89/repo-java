package com.local.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.local.pedidovenda.model.Pedido;
import com.local.pedidovenda.model.StatusPedido;
import com.local.pedidovenda.repository.PedidoRepository;
import com.local.pedidovenda.repository.filter.PedidoFilter;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private PedidoRepository pedidoRepository;
	
	private PedidoFilter filtro;
	private List<Pedido> pedidosFiltrados;
	
	
	public PesquisaPedidosBean() {
		this.filtro = new PedidoFilter();
		this.pedidosFiltrados = new ArrayList<>();
	}	
	
	public void pesquisar() {
		this.pedidosFiltrados = this.pedidoRepository.filtrados(this.filtro);
	}

	public PedidoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(PedidoFilter filtro) {
		this.filtro = filtro;
	}

	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

	public StatusPedido[] getStatuses(){
		return StatusPedido.values();
	}  
	
}