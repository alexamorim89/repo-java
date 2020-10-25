package application;

import entities.Conta;
import entities.ContaPoupanca;

public class Program3 {

	public static void main(String[] args) {
		
		//TESTANDO O POLIMORFISMO
		
		Conta c = new Conta(1020, "Alex", 1000.0);
		Conta cp = new ContaPoupanca(1023, "Maria", 1000.0, 0.01);
		c.saque(50.0);
		cp.saque(50.0);
		
		System.out.println(c.getSaldo());
		System.out.println(cp.getSaldo());
		
	}

}
