package com.local.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.local.pedidovenda.model.Produto;
import com.local.pedidovenda.repository.ProdutoRepository;
import com.local.pedidovenda.repository.filter.ProdutoFilter;
import com.local.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoRepository produtoRepository;
	
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;	
	private Produto produtoSelecionado;	
	
	
	public PesquisaProdutosBean() {
		this.filtro = new ProdutoFilter();
	}	
	
	public void excluir(){
		this.produtoRepository.remover(this.produtoSelecionado);
		this.produtosFiltrados.remove(this.produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + this.produtoSelecionado.getSku() + " excluído com sucesso.") ;
	}	
	
	public void pesquisar() {
		this.produtosFiltrados = this.produtoRepository.filtrados(this.filtro);
	}	
	
	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}