package application02;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	/*
	 *  Fazer um programa para ler os dados de um funcionário (nome, salário bruto e imposto). Em
		seguida, mostrar os dados do funcionário (nome e salário líquido). Em seguida, aumentar o
		salário do funcionário com base em uma porcentagem dada (somente o salário bruto é
		afetado pela porcentagem) e mostrar novamente os dados do funcionário. Use a classe
		projetada abaixo.
	 * 
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Empregado emp = new Empregado();
		
		System.out.print("Nome: ");
		emp.name = sc.nextLine();
		
		System.out.print("Salário bruto: ");
		emp.grossSalary = sc.nextDouble();
		
		System.out.print("Imposto: ");
		emp.tax = sc.nextDouble();
		
		System.out.println();
		System.out.println("Empregado: " + emp);
		
		System.out.println();
		System.out.print("Qual percentual para aumentar o salário? ");
		double percentage = sc.nextDouble();
		emp.increaseSalary(percentage);
		
		System.out.println();
		System.out.println("Dados atualizados: " + emp);
		
		sc.close();
	}

}
