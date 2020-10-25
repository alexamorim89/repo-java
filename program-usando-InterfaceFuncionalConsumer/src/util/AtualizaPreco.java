package util;

import java.util.function.Consumer;

import model.Produto;

public class AtualizaPreco implements Consumer<Produto> {

	@Override
	public void accept(Produto p) {
		p.setPreco(p.getPreco() * 1.1);
	}

}
