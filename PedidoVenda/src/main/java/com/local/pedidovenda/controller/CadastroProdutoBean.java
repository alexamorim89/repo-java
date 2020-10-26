package com.local.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.local.pedidovenda.model.Categoria;
import com.local.pedidovenda.model.Produto;
import com.local.pedidovenda.repository.CategoriaRepository;
import com.local.pedidovenda.service.CadastroProdutoService;
import com.local.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository categoriaRepository;
	
	@Inject
	private  CadastroProdutoService cadastroProdutoService;
	
	private Produto produto;	
	private Categoria categoriaPai;
	
	private List<Categoria> categoriasRaizes;	
	private List<Categoria> subcategorias;
	
	public CadastroProdutoBean() {
		this.limpar();
	}
	
	
	public void inicializar() {	
		if(FacesUtil.isNotPostback()){
			this.categoriasRaizes = this.categoriaRepository.buscarCategoriasRaizes();	
			
			if(this.categoriaPai != null){
				this.carregarSubcategorias();
			}
		}		
	}
	
	
	public void carregarSubcategorias(){
		this.subcategorias = categoriaRepository.subcategoriasDe(this.categoriaPai);
	}
	
	private void limpar(){
		this.produto = new Produto();
		this.categoriaPai = null;
		this.subcategorias = new ArrayList<>();
	}	
	
	public void salvar(){		
		this.cadastroProdutoService.salvar(this.produto);
		this.limpar();		
		
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if(this.produto != null){
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}		
	}	

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	
	public Boolean isEditando() {
		return this.produto.getId() != null;
	}	
}