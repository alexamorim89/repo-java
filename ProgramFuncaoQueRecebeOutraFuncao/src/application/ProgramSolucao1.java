package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import model.Produto;
import service.ProdutoService;

public class ProgramSolucao1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		List<Produto> list = new ArrayList<Produto>();
		list.add(new Produto("TV", 900.00));
		list.add(new Produto("Mouse", 50.00));
		list.add(new Produto("Tablet", 350.50));
		list.add(new Produto("HD Case", 80.90));
		
		ProdutoService ps = new ProdutoService();
		
		double soma1 = ps.filtraSoma(list);
		double soma2 = ps.filtraSomaUsandoPredicate(list, p-> p.getPreco() < 100);
		
		Predicate<Produto> filtroCriterio = p-> p.getPreco() < 400;
		double soma3 = ps.filtraSomaUsandoPredicate(list, filtroCriterio);
		
		
		System.out.println("Soma 1 = " + String.format("%.2f", soma1));
		System.out.println("Soma 2 = " + String.format("%.2f", soma2));
		System.out.println("Soma 3 = " + String.format("%.2f", soma3));
	}

}
