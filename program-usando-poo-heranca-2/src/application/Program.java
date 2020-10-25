package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {
	/*
	 * 	Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário).
	 *  Ao final, mostrar a etiqueta de preço de cada produto na
		mesma ordem em que foram digitados. 
		
		Todo produto possui nome e preço. Produtos importados possuem uma taxa de alfândega, e produtos usados possuem 
		data de fabricação. Estes dados específicos devem ser acrescentados na etiqueta de preço conforme
		exemplo (próxima página). 
		
		Para produtos importados, a taxa e alfândega deve ser
		acrescentada ao preço final do produto.
	 */
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Insira o número de produtos:");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do produto nº "+i+":");
			System.out.print("Comum, usado ou importado (c / u / i)? ");
			char ch = sc.next().charAt(0);
			
			String nome;
			double preco;
			
			switch (ch) {
			
			case 'c':
				System.out.print("Nome: ");
				nome = sc.next();				
				System.out.print("Preco: ");
				preco = sc.nextDouble();
				
				list.add(new Produto(nome, preco));				
				break;				
			case 'u':
				System.out.print("Nome: ");
				nome = sc.next();				
				System.out.print("Preco: ");
				preco = sc.nextDouble();				
				System.out.print("Data de fabricação (DD / MM / AAAA): ");
				Date dataDeFabricacao = sdf.parse(sc.next());
				
				list.add(new ProdutoUsado(nome, preco, dataDeFabricacao));				
				break;
			case 'i':
				System.out.print("Nome: ");
				nome = sc.next();				
				System.out.print("Preco: ");
				preco = sc.nextDouble();
				System.out.print("Taxas alfandegárias: ");
				double taxaAlfandegaria = sc.nextDouble();
				
				list.add(new ProdutoImportado(nome, preco, taxaAlfandegaria));
				break;
			default:
				break;
			}
		}
		
		System.out.println();
		System.out.println("ETIQUETAS DE PREÇO:");
		
		for (Produto produto : list) {
			System.out.println(produto.etiquetaPreco());
		}
		
		sc.close();
	}
}
