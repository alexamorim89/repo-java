package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Program {
	
	/*
	 *	Fazer um programa para ler os dados de um produto em estoque (nome, preço e
		quantidade no estoque). Em seguida:
		
		• Mostrar os dados do produto (nome, preço, quantidade no estoque, valor total no
		estoque)
		
		• Realizar uma entrada no estoque e mostrar novamente os dados do produto
		
		• Realizar uma saída no estoque e mostrar novamente os dados do produto
		Para resolver este problema, você deve criar
		uma CLASSE conforme projeto ao lado: 
	 */

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Produto product = new Produto();
		System.out.println("Insira os dados do produto: ");
		System.out.print("Nome:");
		product.name = sc.nextLine();
		
		System.out.print("Preço: ");
		product.price = sc.nextDouble();
		
		System.out.print("Quantidade em estoque: ");
		product.quantity = sc.nextInt();
		
		System.out.println();
		System.out.println("Informações do produto: " + product);
		
		System.out.println();
		System.out.println("Insira o número de produtos a serem adicionados ao estoque: ");
		int quantity = sc.nextInt();
		product.addProducts(quantity);
		
		System.out.println();
		System.out.println("Dados atualizados: " + product);
		
		System.out.println();
		System.out.println("Insira o número de produtos a serem removidos do estoque: ");
		quantity = sc.nextInt();
		product.removeProducts(quantity);
		
		System.out.println();
		System.out.println("Dados atualizados: " + product);
		
		
		sc.close();
	}

}
