package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import model.Produto;

public class ProgramSolucao5 {
	
	/* EXPRESSAO LAMBDA CLASSE DECLARADA*/
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Produto> list = new ArrayList<Produto>();
		list.add(new Produto("TV", 900.00));
		list.add(new Produto("Mouse", 50.00));
		list.add(new Produto("Tablet", 350.50));
		list.add(new Produto("HD Case", 89.90));
		
		double min = 100;
		Predicate<Produto> produtoPredicate = P -> P.getPreco() >= min;
		
		list.removeIf(produtoPredicate);
		
		for (Produto produto : list) {
			System.out.println(produto);
		}
		
	}

}
