package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.EntradaLog;

public class Program {

	/*
	 * Um site de internet registra um log de acessos dos usuários. Um registro de
	 * log consiste no nome de usuário (apenas uma palavra) e o instante em que o
	 * usuário acessou o site no padrão ISO 8601, separados por espaço, conforme
	 * exemplo. Fazer um programa que leia o log de acessos a partir de um arquivo,
	 * e daí informe quantos usuários distintos acessaram o site.
	 * 
	 * 
	 * Example
	 * Arquivo de Entrada:
	 *  amanda 2018-08-26T20:45:08Z
		alex86 2018-08-26T21:49:37Z
		bobbrown 2018-08-27T03:19:13Z
		amanda 2018-08-27T08:11:00Z
		jeniffer3 2018-08-27T09:19:24Z
		alex86 2018-08-27T22:39:52Z
		amanda 2018-08-28T07:42:19Z
	 * 
	 * 
	 * Execucao:
	 * Insira o caminho completo do arquivo: c:\temp\log-in.txt
	   Total de usuarios: 4
	 * 
	 */

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.print("Insira o caminho completo do arquivo: ");
		String path = sc.nextLine();

		try (BufferedReader bfr = new BufferedReader(new FileReader(path))) {

			Set<EntradaLog> set = new HashSet<EntradaLog>();

			String linha = bfr.readLine();
			while (linha != null) {
				String[] campos = linha.split(" ");
				String nome = campos[0];
				Date data = Date.from(Instant.parse(campos[1]));

				set.add(new EntradaLog(nome, data));
				linha = bfr.readLine();
			}
			System.out.println("Total de usuarios: " + set.size());

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}
