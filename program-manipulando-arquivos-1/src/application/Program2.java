package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * SOLUCAO BEM SIMPLES
 * SOLUCAO NAO ELEGANTE
 * LEITURA BASICA DE UM ARQUIVO 
 * LEITURA BASICA DE UM STREAM DE CARACTERES A PARTIR DE ARQUIVOS
 * USANDO FileReader e BufferedReader
 */

public class Program2 {
	public static void main(String[] args) {
		
		String path = "c:\\temp\\in.txt";
		FileReader fr = null;
		BufferedReader bfr = null;
		
		try {
			fr = new FileReader(path);
			bfr = new BufferedReader(fr);
			
			String linha = bfr.readLine(); //ler a linha do arquivo e retorna null quando tiver no final
			while (linha != null) {
				System.out.println(linha);
				linha = bfr.readLine();
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}  finally {
			try {
				if(bfr != null) {
					bfr.close();
				} 
				if(fr != null) {
					fr.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
