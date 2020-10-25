package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;
import entities.FuncionarioTercerizado;

public class Program {
	/*
	 * Uma empresa possui funcionários próprios e terceirizados.
	Para cada funcionário, deseja-se registrar nome, horas 	trabalhadas e valor por hora. Funcionários terceirizado
	possuem ainda uma despesa adicional.
	
	O pagamento dos funcionários corresponde ao valor da hora
	multiplicado pelas horas trabalhadas, sendo que os 	funcionários terceirizados ainda recebem um bônus
	correspondente a 110% de sua despesa adicional.
	
	Fazer um programa para ler os dados de N funcionários (N fornecido pelo usuário) e armazená-los em uma lista. Depois
	de ler todos os dados, mostrar nome e pagamento de cada	funcionário na mesma ordem em que foram digitados.
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Insira o número de funcionários: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do Funcionário #"+ i + ":");
			System.out.print("Terceirizado (s/n)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.next();
			
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			
			System.out.print("Valor por Hora: ");
			double valorPorHora = sc.nextDouble();
			
			if(ch == 's' || ch == 'y') {
				System.out.print("Cobrança adicional: ");
				double cobrancaAdicional = sc.nextDouble();
				list.add(new FuncionarioTercerizado(nome, horas, valorPorHora, cobrancaAdicional));
			} else {
				list.add(new Funcionario(nome, horas, valorPorHora));
			}
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS:");
		for (Funcionario funcionario : list) {
			System.out.println(funcionario.getNome() + " - $ " + String.format("%.2f", funcionario.formaPagamento()));
		}
		
		sc.close();		
	}

}
