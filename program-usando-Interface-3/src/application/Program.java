package application;

import java.util.Locale;

import model.entities.Circulo;
import model.entities.FiguraAbstract;
import model.entities.Retangulo;
import model.entities.enums.Cor;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		FiguraAbstract s1 = new Circulo(Cor.BLACK, 2.0);
		FiguraAbstract s2 = new Retangulo(Cor.WHITE, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getCor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getCor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
	}
}
