package application01;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	/*
	 *  Fazer um programa para ler os valores da largura e altura
		de um retângulo. Em seguida, mostrar na tela o valor de
		sua área, perímetro e diagonal. Usar uma classe como
		mostrado no projeto ao lado.	 * 
	 * 
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Retangulo r = new Retangulo(); 
		
		System.out.println("Insira a largura e a altura do retângulo: ");
		r.width = sc.nextDouble();
		r.height = sc.nextDouble();
		
		
		System.out.println("AREA = " + r.area());
		System.out.println("PERIMETER = " + r.perimeter());
		System.out.println("DIAGONAL = " + r.diagonal());
		
		sc.close();
	}

}
