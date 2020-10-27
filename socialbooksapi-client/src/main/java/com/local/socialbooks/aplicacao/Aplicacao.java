package com.local.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.local.socialbooks.client.LivrosClient;
import com.local.socialbooks.client.domain.Livro;

public class Aplicacao {
	public static void main(String[] args) throws ParseException {
		
		LivrosClient client = new LivrosClient();
		
		List<Livro> livros = client.listar();
		
		for (Livro livro : livros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		Livro livro = new Livro();
		livro.setNome("JAVA SE + POO");
		livro.setEditora("Algaworks");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("27/07/2014"));;
		
		livro.setResumo("este livro fala sóbre Java e POO");
		
		String localizacao = client.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
		
		Livro livroBuscado = client.buscar(localizacao);
		
		System.out.println("Livro Buscado: " + livroBuscado.getNome());
	}
}
