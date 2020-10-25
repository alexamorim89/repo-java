package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Produto;

public class ProgramSolucao5 {
	
	/* EXPRESSAO LAMBDA DECLARADA */
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		List<Produto> list = new ArrayList<Produto>();
		list.add(new Produto("TV", 900.00));
		list.add(new Produto("Mouse", 50.00));
		list.add(new Produto("Tablet", 350.50));
		list.add(new Produto("HD Case", 80.90));
		
		Function<Produto, String> upperCaseNome = p -> p.getNome().toUpperCase();
		
		List<String> nomeDosProdutos = list.stream().map( upperCaseNome ).collect(Collectors.toList());
		
		nomeDosProdutos.forEach(System.out::println);
	}

}
