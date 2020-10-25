package application;

import java.io.File;
import java.util.Scanner;

/*
 * 
 * SOLUCAO BEM SIMPLES
 * MANIPULANDO INFORMACOES DO CAMINHO DO ARQUIVO USANDO A CLASSE FILE
 * 
 */

public class Program5 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Insira um caminho de pasta: ");
		String path = sc.next();
		
		File file = new File(path);
		System.out.println();
		System.out.println("getName: " + file.getName());
		System.out.println("getParent: " + file.getParent());
		System.out.println("getPath: " + file.getPath());
		System.out.println("length: " + file.length());
		
		sc.close();
	}

}
