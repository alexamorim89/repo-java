package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

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
		
		Consumer<Produto> atualizaPreco = p -> p.setPreco(p.getPreco() * 1.1);
		
		list.forEach( atualizaPreco );
		
		list.forEach(System.out::println);
		
	}

}
