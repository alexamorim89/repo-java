package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Produto;

public class Program1 {
	/*
	 *	Fazer um programa para ler o caminho de um arquivo .csv contendo os dados de itens vendidos. Cada item possui um
		nome, preço unitário e quantidade, separados por vírgula. Você deve gerar um novo arquivo chamado "summary.csv", localizado
		em uma subpasta chamada "out" a partir da pasta original do arquivo de origem, contendo apenas o nome e o valor total para
		aquele item (preço unitário multiplicado pela quantidade), conforme exemplo.
		
		Arquivo Fonte:
			TV LED,1290.99,1
			Video Game Chair,350.50,3
			Iphone X,900.00,2
			Samsung Galaxy 9,850.00,2
		
	 	Arquivo de Saida (out/summary.csv): 
			TV LED,1290.99
			Video Game Chair,1051.50
			Iphone X,1800.00
			Samsung Galaxy 9,1700.00
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> list = new ArrayList<Produto>();
		
		System.out.println("Insira um caminho do arquivo: ");
		String caminhoInformado = sc.next();
		
		File file = new File(caminhoInformado);
		
		//CRIA UM DIRETORIO C:\TEMP\OUT
		boolean sucesso = new File(file.getParent() + "\\out").mkdir();
		
		//TARGET DO CAMINHO DO ARQUIVO QUE SERA GRAVADO AS INFORMACOES
		String targetNovoArquivo = file.getParent() + "\\out\\resumo.csv";
		
		try (BufferedReader bfr = new BufferedReader(new FileReader(caminhoInformado))){
			
			while (bfr.ready()) {
				String[] linhas = bfr.readLine().split(";");
				String nome = linhas[0];
				double preco = Double.parseDouble(linhas[1]);
				int quantidade = Integer.parseInt(linhas[2]);
				
				list.add(new Produto(nome, preco, quantidade));
			}
			
			try(BufferedWriter bfw = new BufferedWriter(new FileWriter(targetNovoArquivo))){
				for (Produto produto : list) {
					bfw.write(produto.getNome() +"," + String.format("%.2f", produto.total()));
					bfw.newLine(); //CRIA UMA NOVA LINHA
				}
				System.out.println(targetNovoArquivo + " CRIADO!");
				
			} catch (IOException e) {
				System.out.println("Erro ao gravar arquivo: " + e.getMessage());
			}
			
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo: " + e.getMessage());
		}
		
		sc.close();
	}

}
