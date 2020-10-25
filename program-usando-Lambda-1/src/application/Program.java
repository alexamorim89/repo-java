package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Empregado;

public class Program {
	/*
	 *  Fazer um programa para ler os dados (nome, email e salário)
		de funcionários a partir de um arquivo em formato .csv.
		Em seguida mostrar, em ordem alfabética, o email dos
		funcionários cujo salário seja superior a um dado valor
		fornecido pelo usuário.
		Mostrar também a soma dos salários dos funcionários cujo
		nome começa com a letra 'M'.
		Veja exemplo na próxima página.
		
		ARQUIVOS DE ENTRADA:	
		Maria,maria@gmail.com,3200.00
		Alex,alex@gmail.com,1900.00
		Marco,marco@gmail.com,1700.00
		Bob,bob@gmail.com,3500.00
		Anna,anna@gmail.com,2800.00
		
		EXECUCAO:
		Insira o caminho completo do arquivo: c: \ temp \ in.txt
		Digite o salário: 2.000,00
		Email de pessoas com salário superior a 2.000,00:
		anna@gmail.com
		bob@gmail.com
		maria@gmail.com
		Soma do salário das pessoas cujo nome começa com 'M': 4.900,00
	 * 
	 */
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o caminho completo do arquivo: ");
		String path = sc.next();
		
		System.out.print("Insira o salário: ");
		double salario = sc.nextDouble();
		
		try( BufferedReader bfr = new BufferedReader(new FileReader(path)) ){
			
			List<Empregado> list = new ArrayList<>();			
			List<String> listaDeEmails = null;
			Double somaEmpregadosComM = null;
			
			String linha = bfr.readLine();
			while (linha != null) {				
				String[] linhas = linha.split(",");
				list.add(new Empregado( linhas[0], linhas[1], Double.parseDouble(linhas[2] )));
				
				listaDeEmails = list.stream()
						.filter(e -> e.getSalario() > salario)
						.map(e -> e.getEmail())
						.sorted()
						.collect(Collectors.toList());
				
				somaEmpregadosComM = list.stream()
					.filter(s -> s.getNome().charAt(0) == 'M')
					.map(e -> e.getSalario())
					.reduce((a, b) -> a + b)
					.get()
					.doubleValue();
				
				linha = bfr.readLine();
			}
			
			System.out.println("Email de pessoas cujo salário é superior a 2.000,00");
			listaDeEmails.forEach(System.out::println);
			System.out.println("Soma do salário das pessoas cujo nome começa com 'M': " + String.format("%.2f", somaEmpregadosComM));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
