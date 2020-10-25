package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circulo;
import entities.Forma;
import entities.Retangulo;
import entities.enums.Cor;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Forma> list = new ArrayList<>();
		
		System.out.print("Insira o número de formas: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados da forma #"+i);
			
			System.out.print("Retângulo ou Círculo (r/c)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Cor (BLACK/BLUE/RED): ");
			Cor cor = Cor.valueOf(sc.next());
			if(ch == 'r') {
				System.out.print("Largura: ");
				double largura = sc.nextDouble();
				
				System.out.print("Altura: ");
				double altura = sc.nextDouble();
				
				list.add(new Retangulo(cor, largura, altura));
			} else {
				System.out.print("Raio: ");
				double raio = sc.nextDouble();
				
				list.add(new Circulo(cor, raio));
			}
		}
		
		System.out.println();
		System.out.println("AREAS DA FORMA");
		for (Forma forma : list) {
			System.out.println(String.format("%.2f", forma.area()));
		}
		
		sc.close();
	}
}
