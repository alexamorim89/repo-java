package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program3 {
	
	/*
	 * SOLUCAO BEM SIMPLES
	 * ESCREVENDO EM UM ARQUIVO DE FORMA SIMPLES 
	 * FileWriter
	 * BuffereWriter  
	 *  
	 *  
	 *  • Cria/recria o arquivo: new FileWriter(path)
		• Acrescenta ao arquivo existente: new FileWriter(path, true)
	 *  
	 *  
	 */
	
	public static void main(String[] args) {
		
		String[] linhas = new String[] {"Bom Dia!", "Boa Tarde!", "Boa Noite!"};
		
		String path = "c:\\temp\\out.txt";
		
		try(BufferedWriter bfw = new BufferedWriter(new FileWriter(path, true))) {
			for (String linha : linhas) {
				bfw.write(linha);
				bfw.newLine(); //cria uma nova linha
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
