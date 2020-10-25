package application;

import java.text.ParseException;

import entities.Comentario;
import entities.Postar;
import utilitarios.Util;

public class Program {

	public static void main(String[] args) throws ParseException {
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comentario c1 = new Comentario("Tenha uma boa viagem!");
		Comentario c2 = new Comentario("Uau, isso é incrível!");
		Postar p1 = new Postar(
				Util.FORMAT_dd_MM_yyy_HH_mm_ss.parse("21/06/2018 13:05:44"), 
				"Viajar para a Nova Zelândia", 
				"Vou visitar este país maravilhoso!", 
				12);
		p1.adicionaComentario(c1);
		p1.adicionaComentario(c2);
		
		
		Comentario c3 = new Comentario("Boa noite");
		Comentario c4 = new Comentario("Que a força esteja com você");
		Postar p2 = new Postar(
				Util.FORMAT_dd_MM_yyy_HH_mm_ss.parse("28/07/2018 23:14:19"), 
				"Boa noite, galera", 
				"Te vejo amanhã", 
				5);
		p2.adicionaComentario(c3);
		p2.adicionaComentario(c4);

		
		System.out.println(p1);
		System.out.println(p2);
		
	}

}
