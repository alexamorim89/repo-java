package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoPorHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelDeTrabalho;

public class Program {
	/*
	 *  Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar
		do usuário um mês e mostrar qual foi o salário do funcionário nesse mês, conforme exemplo
		(próxima página).
	 */
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Insira o nome do departamento:");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Insira os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		
		System.out.print("Salario Base: ");
		double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDeTrabalho.valueOf(nivel), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos para este trabalhador?");
		int contadorContrato = sc.nextInt();
		
		for (int i = 1; i <= contadorContrato; i++) {
			System.out.println("Insira os dados do contrato #"+i+": ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date data = sdf.parse(sc.next());
			
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			System.out.print("Duração (horas):");
			int horas = sc.nextInt();
			
			ContratoPorHora contrato = new ContratoPorHora(data, valorPorHora, horas);
			trabalhador.adicionaContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Insira o mês e o ano para calcular a receita (MM / AAAA): ");
		String mesEAno = sc.next();
		
		int mes = Integer.parseInt(mesEAno.substring(0,2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.println("Nome: " + trabalhador.getNome() );		
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());		
		System.out.println("Renda para "+ mes +"/"+ano+ ": "+ String.format("%.2f",trabalhador.renda(ano, mes)));
		
		sc.close();
	}

}
