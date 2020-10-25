package model;

import util.Util;

public class Produto {
	private String nome;
	private Double preco;

	public Produto() {
	}

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public static void staticAtualizaProduto(Produto produto) {
		produto.setPreco(produto.getPreco() * 1.1);; 
	}
	
	public void naoStaticAtualizaProduto() {
		preco = preco * 1.1; 
	}
	
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + Double.valueOf(Util.FORMATO.format(preco)) + "]";
	}
}
