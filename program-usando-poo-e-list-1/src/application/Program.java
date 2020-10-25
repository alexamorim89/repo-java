package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {
	/*
	 * 	Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
		N funcionários. Não deve haver repetição de id.
		
		Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
		Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
		mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
		conforme exemplos.
		
		Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
		ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
		aumento por porcentagem dada.
		(exemplo na próxima página)
			 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<Funcionario>();
		
		System.out.print("Quantos funcionários serão registrados? ");
		int numero = sc.nextInt();
		
		for (int i = 1; i <= numero; i++) {
			System.out.println("Empregado #"+i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			System.out.print("Nome: ");
			String nome = sc.next();
			
			System.out.print("Salario: ");
			sc.next();
			double salario = sc.nextDouble();
			
			list .add(new Funcionario(id, nome, salario));
			
			System.out.println();
		}
		
		System.out.print("Digite a identificação do funcionário que terá aumento de salário: ");
		int id = sc.nextInt();
		
		Funcionario funcionario = list.stream().filter(f -> f.getId() == id).findFirst().orElse(null);		
		if (funcionario == null) {
			System.out.println("Este id não existe!");
		} else {
			System.out.print("Insira a porcentagem: ");
			double porcentagem = sc.nextDouble();			
			funcionario.aumentarSalario(porcentagem);
		}
		
		System.out.println();
		
		System.out.println("Lista de funcionários: ");
		for (Funcionario empregado : list) {
			System.out.println(empregado);
		}
		
		sc.close();
	}
}
