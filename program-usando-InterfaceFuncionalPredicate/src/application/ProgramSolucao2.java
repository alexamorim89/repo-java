package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.Produto;

public class ProgramSolucao2 {
	
	/* REFERENCE METHOD COM METODO ESTATICO */
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Produto> list = new ArrayList<Produto>();
		list.add(new Produto("TV", 900.00));
		list.add(new Produto("Mouse", 50.00));
		list.add(new Produto("Tablet", 350.50));
		list.add(new Produto("HD Case", 89.90));
		
		list.removeIf(Produto::staticProdutoPredicate);
		
		for (Produto produto : list) {
			System.out.println(produto);
		}
		
	}

}
