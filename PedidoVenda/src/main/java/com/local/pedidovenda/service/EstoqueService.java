package com.local.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.local.pedidovenda.model.ItemPedido;
import com.local.pedidovenda.model.Pedido;
import com.local.pedidovenda.repository.PedidoRepository;
import com.local.pedidovenda.util.jpa.Transactional;

public class EstoqueService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public void baixarItensEstoque(Pedido pedido) {
		pedido = this.pedidoRepository.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItens()) {
			item.getProduto().baixarEstoque(item.getQuantidade());
		}		
	}

	public void retornarItensEstoque(Pedido pedido) {
		pedido = this.pedidoRepository.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItens()) {
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}		
	}	
	
}