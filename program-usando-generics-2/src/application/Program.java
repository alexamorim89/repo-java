package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Produto;
import model.services.CalculoService;

public class Program {

	/*
	 * Problema
	 * 
	 * Uma empresa de consultoria deseja avaliar a performance de produtos,
	 * funcionários, dentre outras coisas. Um dos cálculos que ela precisa é
	 * encontrar o maior dentre um conjunto de elementos. Fazer um programa que leia
	 * um conjunto de produtos a partir de um arquivo, conforme exemplo, e depois
	 * mostre o mais caro deles.
	 * 
	 *
	 * Computer,890.50 
	 * IPhone X,910.00 
	 * Tablet,550.00 
	 * Most expensive: 
	 * IPhone, 910.00
	 */
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Produto> list = new ArrayList<>();

		String path = "C:\\temp\\in.txt"; //E NESCESSARIO CRIAR O DIRETORIO E O ARQUIVO

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				list.add(new Produto(campos[0], Double.parseDouble(campos[1])));
				linha = br.readLine();
			}

			Produto x = CalculoService.max(list);
			System.out.println("Mais caro:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}