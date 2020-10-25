package application;

import java.util.Scanner;

import entities.Sala;

public class Program1 {
	/*
	 * A dona de um pensionato possui dez quartos para alugar para estudantes,
		sendo esses quartos identificados pelos números 0 a 9.
		Fazer um programa que inicie com todos os dez quartos vazios, e depois
		leia uma quantidade N representando o número de estudantes que vão
		alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos
		N estudantes. Para cada registro de aluguel, informar o nome e email do
		estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha
		que seja escolhido um quarto vago. Ao final, seu programa deve imprimir
		um relatório de todas ocupações do pensionato, por ordem de quarto,
		conforme exemplo.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Sala[] vect = new Sala[10];
		
		System.out.print("quantos quartos serão alugados? ");
		int numero = sc.nextInt();
		
		System.out.println();
		
		for (int i = 1; i <= numero; i++) {
			System.out.println("Rent #" + i);
			
			System.out.print("Nome: ");
			String name = sc.next();
			
			System.out.print("Email: ");
			sc.nextLine();
			String email = sc.next();
			
			System.out.print("Sala: ");
			int quarto = sc.nextInt();
			
			Sala estudante = new Sala(name, email, quarto);
			if(vect[quarto] == null) {
				vect[quarto] = estudante;
			} else {
				System.out.println();
				System.out.println("Quarto " + vect[quarto].getQuarto() + " ja esta ocupado!");
			}
			
			System.out.println();
		}
		
		System.out.println("Salas ocupadas:");
		for (int i = 0; i < vect.length; i++) {
			if(vect[i] != null) {
				System.out.println(vect[i].getQuarto() + ": " + vect[i].getName()  + ", " + vect[i].getEmail());
			}
		}
		
		sc.close();
	}
}
