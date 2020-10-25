package application;

import entities.Conta;
import entities.ContaNegocio;
import entities.ContaPoupanca;

public class Program1 {
	public static void main(String[] args) {
		
		Conta c = new Conta(1001, "Alex", 0.0);
		ContaNegocio cn = new ContaNegocio(1002, "Maria", 0.0, 500.0);
		
		
		//UPCASTING (Converte objeto da subclasse para a superclasse)
		
		Conta c1 = cn;
		Conta c2 = new ContaNegocio(1003, "Bob", 0.0, 200.0);
		Conta c3 = new ContaPoupanca(1004, "Anna", 0.0, 0.01);
		
		
		//DOWNCASTING (Converte objeto da SUPERclasse para a SUBclasse)
		
		ContaNegocio cn1 = (ContaNegocio)c2;
		cn1.emprestimo(100.0 );
		
//		ContaNegocio cn5 = (ContaNegocio)c3;
		if (c3 instanceof ContaNegocio) {
			ContaNegocio cn5 = (ContaNegocio)c3;
			cn5.emprestimo(200.0);
			System.out.println("Emprestimo!");		
		}
		
		if(c3 instanceof ContaPoupanca) {
			ContaPoupanca cp1 = (ContaPoupanca)c3;
			cp1.atualizarSaldo();
			System.out.println("Atualizado!");
		}
		
	}
}
