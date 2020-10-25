package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelDeCarro;
import model.entities.Veiculo;
import model.service.AluguelService;
import model.service.ImpostoBrasilService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		Date fim = sdf.parse(sc.nextLine());
		
		AluguelDeCarro aluguelDeCarro = new AluguelDeCarro(inicio, fim, new Veiculo(modeloCarro));

		System.out.print("Enter price per hour: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double precoPorDia = sc.nextDouble();
		
		AluguelService rentalService = new AluguelService(precoPorDia, precoPorHora, new ImpostoBrasilService());
		
		rentalService.processarFatura(aluguelDeCarro);

		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", aluguelDeCarro.getFatura().getPagamentoBasico()));
		System.out.println("Tax: " + String.format("%.2f", aluguelDeCarro.getFatura().getImposto()));
		System.out.println("Total payment: " + String.format("%.2f", aluguelDeCarro.getFatura().pagamentoTotal()));
		
		sc.close();
	}

}
