package service;
import java.util.List;
import java.util.function.Predicate;

import model.Produto;

public class ProdutoService {
	
	public double filtraSoma(List<Produto> list) {
		double soma = 0;
		for (Produto p : list) {
			if(p.getNome().charAt(0) == 'T') {
				soma += p.getPreco();
			}
		}		
		return soma;
	}
	
	public double filtraSomaUsandoPredicate(List<Produto> list, Predicate<Produto> criterio) {
		double soma = 0;
		for (Produto p : list) {
			if(criterio.test(p) ) {
				soma += p.getPreco();
			}
		}		
		return soma;
	}
	
	
}
