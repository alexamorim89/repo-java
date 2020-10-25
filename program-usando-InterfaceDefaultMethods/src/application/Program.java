package application;

import java.util.Locale;
import java.util.Scanner;

import services.BrasilJurosService;
import services.JurosService;
import services.UsaJurosService;

public class Program {

	/*
	 * Problema exemplo Fazer um programa para ler uma quantia e a duração em meses
	 * de um empréstimo. Informar o valor a ser pago depois de decorrido o prazo do
	 * empréstimo, conforme regras de juros do Brasil. A regra de cálculo de juros
	 * do Brasil é juro composto padrão de 2% ao mês.
	 * 
	 * 
	 * Cálculos: Pagamento = 200 * 1.02 * 1.02 * 1.02 = 200 * 1.023 = 212.2416
	 * Pagamento = valor * (1 + taxaJuros / 100)N
	 * 
	 * Amount: 200.00 
	 * Months: 3 
	 * Payment after 3 
	 * months: 212.24
	 * 
	 */

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Valor: ");
		double valor = sc.nextDouble();
		System.out.print("Meses: ");
		int meses = sc.nextInt();

		JurosService is1 = new BrasilJurosService(2.0);
		double pagamento1 = is1.pagamento(valor, meses);

		System.out.println("Pagamento depois de " + meses + " meses:");
		System.out.println(String.format("%.2f", pagamento1));

		JurosService is2 = new UsaJurosService(1.0);
		double pagamento2 = is2.pagamento(valor, meses);

		System.out.println("Pagamento depois de " + meses + " meses:");
		System.out.println(String.format("%.2f", pagamento2));

		sc.close();
	}

}