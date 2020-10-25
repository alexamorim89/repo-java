package entities;

import java.util.Date;

import util.Util;

public class ProdutoUsado extends Produto {
	private Date dataDeFabricacao;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, Date dataDeFabricacao) {
		super(nome, preco);
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}

	@Override
	public String etiquetaPreco() {
		return getNome() 
				+ " (Usado) $ " 
				+ String.format("%.2f", getPreco())
				+ " (Data de fabricação: "
				+ Util.FORMAT_DD_MM_YYYY.format(dataDeFabricacao)
				+ ")";
	}

}
