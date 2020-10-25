package application;

import java.io.File;
import java.util.Scanner;

/*
 * 
 * SOLUCAO BEM SIMPLES
 * MANIPULANDO PASTAS COM A CLASSE FILE DE FORMA SIMPLES
 * 
 */
public class Program4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira um caminho de pasta: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] pastas = path.listFiles(File::isDirectory);
		System.out.println("PASTAS:");
		for (File pasta : pastas) {
			System.out.println(pasta);
		}
		
		File[] arquivos = path.listFiles(File::isFile);
		System.out.println("ARQUIVOS:");
		for (File arquivo : arquivos) {
			System.out.println(arquivo);
		}
		
		boolean sucesso = new File(strPath + "\\subdir").mkdir();
		System.out.println("Diretório criado com sucesso: " + sucesso);
		sc.close();
	}
}
