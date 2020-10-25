package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.service.ContratoService;
import model.service.PaypalService;


/*
 * 	Uma empresa deseja automatizar o processamento de seus contratos. O processamento de
	um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no
	número de meses desejado.
	A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.
	Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa
	por pagamento. Por enquanto, o serviço contratado pela empresa é o do Paypal, que aplica
	juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
	Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
	e valor total do contrato). Em seguida, o programa deve ler o número de meses para
	parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
	sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
	meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.
	Veja exemplo na próxima página
 *  
 * 
 */

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira os dados do contrato");		
		System.out.print("Número: 8028");
		int numero = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): 25/06/2018");
		Date data = sdf.parse(sc.next());
		
		System.out.print("Valor do contrato: 600.00");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Insira o número de parcelas: 3");
		int meses = sc.nextInt();
		
		ContratoService contratoService = new ContratoService(new PaypalService());
		contratoService.processaContrato(contrato, meses);
		
		System.out.println("Parcelas: ");
		for (Parcela parcela : contrato.getListaDePrestacao()) {
			System.out.println(parcela);
		}
		
		
		/*
		 * Cálculos (1% de juros simples mensais + 2% de taxa de pagamento):
		 *  
		 * Quota #1:
			200 + 1% * 1 = 202
			202 + 2% = 206.04
		  
		  Quota #2:
			200 + 1% * 2 = 204
			204 + 2% = 208.08
		  
		  Quota #3:
			200 + 1% * 3 = 206
			206 + 2% = 210.12
		 * 
		 */
		
		sc.close();
	}
}
