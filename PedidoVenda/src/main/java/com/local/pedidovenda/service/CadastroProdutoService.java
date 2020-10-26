package com.local.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.local.pedidovenda.model.Produto;
import com.local.pedidovenda.repository.ProdutoRepository;
import com.local.pedidovenda.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = this.produtoRepository.porSku(produto.getSku());
		
		if(produtoExistente != null && !produtoExistente.equals(produto)){
			throw new NegocioException("Já existe um produto com o SKU informado.");
		}		
		return produtoRepository.guardar(produto);
	}
	
}