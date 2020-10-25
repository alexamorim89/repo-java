package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Program {
	/*
	 * Na contagem de votos de uma eleição, são gerados vários registros de votação
	 * contendo o nome do candidato e a quantidade de votos (formato .csv) que ele
	 * obteve em uma urna de votação. Você deve fazer um programa para ler os
	 * registros de votação a partir de um arquivo, e daí gerar um relatório
	 * consolidado com os totais de cada candidato.
	 * 
	 * 
	 * Example
	 * Arquivo de Entrada:
	 *  Alex Blue,15
		Maria Green,22
		Bob Brown,21
		Alex Blue,30
		Bob Brown,15
		Maria Green,27
		Maria Green,22
		Bob Brown,25
		Alex Blue,31
	 * 
	 * 
	 * Execucao:
	 *  Insira o caminho completo do arquivo: c:\temp\in.txt
	    Alex Blue: 76
		Maria Green: 71
		Bob Brown: 61
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o caminho completo do arquivo:");
		String path = sc.next();
		
		Map<String, Integer> map = new HashMap<>();

		try(BufferedReader bfr = new BufferedReader(new FileReader(path))) {
		
			String linha = bfr.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				String nome = campos[0];
				int contadorDeVotos = Integer.parseInt(campos[1]);
				
				if(map.containsKey(nome)) {
					int votos = map.get(nome); // RETORNA O VALOR DA CHAVE
					contadorDeVotos += votos;
					map.put(nome, contadorDeVotos);
				} else {
					map.put(nome, contadorDeVotos);					
				}
				linha = bfr.readLine();
			}			
			System.out.println("Candidatos: " + map);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		boolean sucesso = new File("c:\\temp\\out").mkdir(); //CRIA UM DIRETORIO
		System.out.println("Diretorio out criado: " + sucesso);
		
		try(BufferedWriter bfw = new BufferedWriter(new FileWriter("c:\\temp\\out\\formato.csv"))) {			
			for (Entry<String, Integer> mapDeCandidatos : map.entrySet()) {
				bfw.write(mapDeCandidatos.getKey() + ": " + mapDeCandidatos.getValue());
				bfw.newLine();
			}			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}