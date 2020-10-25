package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {
	/*
	 *  Quais são os benefícios de se calcular a área de um triângulo por meio de um
		MÉTODO dentro da CLASSE Triangle?
		
		1) Reaproveitamento de código: nós eliminamos o código repetido (cálculo
		das áreas dos triângulos x e y) no programa principal.
		
		2) Delegação de responsabilidades: quem deve ser responsável por saber
		como calcular a área de um triângulo é o próprio triângulo. A lógica do cálculo
		da área não deve estar em outro lugar.
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Triangle x, y;
		x = new Triangle();
		y = new Triangle();
		
		System.out.println("Enter the measures of triangule x:");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		
		
		System.out.println("Enter the measures of triangule y:");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		
		double areaX = x.area();		
		double areaY = y.area();
		
		System.out.printf("Triangle X area: %.4f%n", areaX);
		System.out.printf("Triangle y area: %.4f%n", areaY);
		
		if(areaX > areaY) {
			System.out.println("Larger area: X");
		} else {
			System.out.println("Larger area: y");
		}
		
		sc.close();
	}
}
