package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {
	/*
	 * Problema exemplo 
	 * Fazer um programa para ler os dados de uma reserva de hotel
	 * (número do quarto, data de entrada e data de saída) e mostrar os dados da
	 * reserva, inclusive sua duração em dias. Em seguida, ler novas datas de
	 * entrada e saída, atualizar a reserva, e mostrar novamente a reserva com os
	 * dados atualizados. O programa não deve aceitar dados inválidos para a
	 * reserva, conforme as seguintes regras: - Alterações de reserva só podem
	 * ocorrer para datas futuras - A data de saída deve ser maior que a data de
	 * entrada
	 * 
	 * 
	 * Exemplo1
	 *
	 *	Número do quarto: 8021
		Check-in date (dd/MM/yyyy): 23/09/2019
		Check-out date (dd/MM/yyyy): 26/09/2019
		Reserva: Quarto 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 noites
		Enter data to update the reservation:
		Check-in date (dd/MM/yyyy): 24/09/2019
		Check-out date (dd/MM/yyyy): 29/09/2019
		Reserva: Quarto 8021, check-in: 24/09/2019, check-out: 29/09/2019, 5 noites
	 *
	 *	Número do quarto: 8021
		Check-in date (dd/MM/yyyy): 23/09/2019
		Check-out date (dd/MM/yyyy): 21/09/2019
		Erro na reserva: A data de check-out deve ser posterior à data de check-in
		
		Exemplo 2
		Número do quarto: 8021
		Data de check-in (dd / MM / aaaa): 23/09/2019
		Data de check-out (dd / MM / aaaa): 26/09/2019
		Reserva: Quarto 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 noites
		Insira os dados para atualizar a reserva:
		Data de check-in (dd / MM / aaaa): 24/09/2015
		Data de check-out (dd / MM / aaaa): 29/09/2015
		Erro na reserva: as datas de reserva para atualização devem ser datas futuras
		
		
		Número do quarto: 8021
		Data de check-in (dd / MM / aaaa): 23/09/2019
		Data de check-out (dd / MM / aaaa): 26/09/2019
		Reserva: Quarto 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 noites
		Insira os dados para atualizar a reserva:
		Data de check-in (dd / MM / aaaa): 24/09/2020
		Data de check-out (dd / MM / aaaa): 22/09/2020
		Erro na reserva: a data de check-out deve ser posterior à data de check-in
	 */
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data de verificação de Entrada (dd/MM/yyyy): ");
			Date verificaEntrada = sdf.parse(sc.next());
			System.out.print("Data de verificação de saida (dd/MM/yyyy): ");
			Date verificaSaida = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numero, verificaEntrada, verificaSaida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Data de verificação de Entrada (dd/MM/yyyy): ");
			verificaEntrada = sdf.parse(sc.next());
			System.out.print("Data de verificação de saida (dd/MM/yyyy): ");
			verificaSaida = sdf.parse(sc.next());
			
			reserva.atualizaDatas(verificaEntrada, verificaSaida);
			System.out.println("Reserva: " + reserva);			
		} catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}  catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}
}