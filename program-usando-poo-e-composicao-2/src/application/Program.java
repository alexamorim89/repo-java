package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;
import utilitarios.Util;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira os dados do cliente:");		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Nascimento (DD/MM/YYYY): ");
		Date dataNascimento = Util.FORMAT_DD_MM_YYYY.parse(sc.next()); 
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Insira os dados do pedido: ");
		System.out.print("Status: ");
		sc.nextLine();
		StatusPedido status = StatusPedido.valueOf(sc.next());
//		String status = sc.next();
		
		Pedido pedido = new Pedido(new Date(),  status, cliente);
		
		System.out.print("Quantos itens há neste pedido? ");
		int numero = sc.nextInt();
		for(int i = 1; i <= numero; i++ ) {
			System.out.println("Insira os dados do item "+i+": ");			
			System.out.print("Nome do Produto: ");
			String nomeProduto = sc.next();
			
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			
			ItemPedido item = new ItemPedido(quantidade, precoProduto, new Produto(nomeProduto, precoProduto));
			
			pedido.adicionaItem(item);
		}
		
		System.out.println("RESUMO DO PEDIDO:");		
		System.out.println("Momento do pedido: " + Util.FORMAT_DD_MM_YYYY_HH_MM_SS.format(pedido.getMomento()));
		System.out.println("Status do pedido: " + pedido.getStatus());
		System.out.println("Cliente: " + cliente);
		System.out.println("Itens do pedido: ");
		System.out.println(pedido);
		sc.close();
		
	}

}
