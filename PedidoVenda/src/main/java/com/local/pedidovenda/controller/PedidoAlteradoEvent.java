package com.local.pedidovenda.controller;

import com.local.pedidovenda.model.Pedido;

public class PedidoAlteradoEvent {
	
	private Pedido pedido;	
	
	public PedidoAlteradoEvent(Pedido pedido) {
		this.pedido = pedido;
	}	

	public Pedido getPedido() {
		return pedido;
	}	
	
}