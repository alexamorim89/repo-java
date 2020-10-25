package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.SaqueInvalidoException;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Insira os dados da conta");
			System.out.print("Numero: ");
			int numero = sc.nextInt();
			
			System.out.print("Titular: ");
			String titular = sc.next();
			
			System.out.print("Saldo inicial: ");
			sc.nextLine();
			double saldo = sc.nextDouble();
			
			System.out.print("Limite de retirada: ");
			double limiteSaque = sc.nextDouble();
			
			Conta conta = new Conta(numero, titular, saldo, limiteSaque);
			
			System.out.println();
			System.out.print("Insira o valor para sacar: ");
			double saque = sc.nextDouble();
			
			conta.sacar(saque);
			
			System.out.println("Novo Saldo: " + String.format("%.2f", conta.getSaldo()));
			
		} catch (SaqueInvalidoException e) {
			System.out.println("Erro de retirada: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();
	}

}
