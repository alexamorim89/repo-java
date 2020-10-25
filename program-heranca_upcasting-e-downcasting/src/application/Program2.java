package application;

import entities.Conta;
import entities.ContaNegocio;
import entities.ContaPoupanca;

public class Program2 {

	public static void main(String[] args) {
		
		//TESTANDO A SOBRESCRITA DO METODO SAQUE NAS CLASSES DERIVADAS(SUBSCLASSES)
		
		Conta c1 = new Conta(1001, "Alex", 1000.0);
		c1.saque(200.0);
		System.out.println(c1.getSaldo());
		
		
		Conta c2 = new ContaPoupanca(1002, "Maria", 1000.0, 0.01);
		c2.saque(200.0);
		System.out.println(c2.getSaldo());
		
		
		Conta c3 = new ContaNegocio(1003, "Bob", 1000.0, 500.0);
		c3.saque(200.0);
		System.out.println(c3.getSaldo());
		
	}	

}
