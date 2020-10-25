package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Produto;

public class ProgramSolucao4 {

	public static void main(String[] args) {

		List<Produto> list = new ArrayList<>();

		list.add(new Produto("TV", 900.00));
		list.add(new Produto("Notebook", 1200.00));
		list.add(new Produto("Tablet", 450.00));
		
		Comparator<Produto> comparator = (p1, p2)-> {
			return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());	
		};
		
		list.sort(comparator);
		
		for (Produto p : list) {
			System.out.println(p);
		}
	}
}