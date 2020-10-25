package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Conta conta = null;
		
		System.out.print("Insira o número da conta: ");
		int numero = sc.nextInt();
		
		System.out.print("Insira o titular da conta: ");
		sc.nextLine();
		String nome = sc.nextLine();
		
		System.out.print("Existe um depósito inicial (s / n): ");
		char opcao = sc.next().charAt(0);
		
		if(opcao == 's' || opcao == 'S') {
			System.out.print("Insira o valor do depósito inicial: ");
			double depositoInicial = sc.nextDouble();
			conta =  new Conta(numero, nome, depositoInicial);
		} else {
			conta =  new Conta(numero, nome);
		}
		
		System.out.println();
		System.out.println("Dados da conta:");
		System.out.println(conta);
		
		System.out.println();
		System.out.print("Insira um valor de depósito: ");
		double valorDeposito = sc.nextDouble();
		conta.depositar(valorDeposito);
		System.out.println("Dados da conta atualizados: ");
		System.out.println(conta);
		
		System.out.println();		
		System.out.print("Insira um valor de retirada: ");
		double valorSaque = sc.nextDouble();
		conta.sacar(valorSaque);
		System.out.println("Dados da conta atualizados:");	
		System.out.println(conta);
		
		sc.close();
	}

}
