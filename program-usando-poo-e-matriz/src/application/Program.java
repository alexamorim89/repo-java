package application;

import java.util.Scanner;

public class Program {
	
	/*
	 * Fazer um programa para ler dois números inteiros M e N, e depois ler
		uma matriz de M linhas por N colunas contendo números inteiros,
		podendo haver repetições. Em seguida, ler um número inteiro X que
		pertence à matriz. Para cada ocorrência de X, mostrar os valores à
		esquerda, acima, à direita e abaixo de X, quando houver, conforme
		exemplo.  
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int c = sc.nextInt();
		
		int[][] matriz = new int[l][c];
		
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
				matriz[linha][coluna] = sc.nextInt();
			}
		}
		
		int x = sc.nextInt();
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; c < matriz[linha].length; coluna++) {
				if(matriz[linha][coluna] == x) {
					System.out.println("Position: " + linha +","+ coluna);
					if(coluna > 0) {
						System.out.println("Left: " + matriz[linha][coluna - 1]);
					} 
					if(linha > 0) {
						System.out.println("Up: " + matriz[linha - 1][coluna]);
					}
					if(coluna < matriz[linha].length -1) {
						System.out.println("Right: " + matriz[linha][coluna + 1]);
					}
					if(linha < matriz[linha].length -1) {
						System.out.println("Down: " + matriz[linha + 1][coluna]);
					}
				}
			}
		}
		
		sc.close();
	}
}
