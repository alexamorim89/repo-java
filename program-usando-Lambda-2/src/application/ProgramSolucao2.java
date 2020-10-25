package application;

import java.util.ArrayList;
import java.util.List;

import entities.MeuComparator;
import entities.Produto;

public class ProgramSolucao2 {

	public static void main(String[] args) {

		List<Produto> list = new ArrayList<>();

		list.add(new Produto("TV", 900.00));
		list.add(new Produto("Notebook", 1200.00));
		list.add(new Produto("Tablet", 450.00));
		
		list.sort(new MeuComparator());
		
		for (Produto p : list) {
			System.out.println(p);
		}
	}
}