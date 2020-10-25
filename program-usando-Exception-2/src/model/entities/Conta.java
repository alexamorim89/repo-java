package model.entities;

import model.exceptions.SaqueInvalidoException;

public class Conta {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void depositaro(double valor) {
		this.saldo += valor;
	}

	public void sacar(double valor) throws SaqueInvalidoException {
		if(saldo <= 0) {
			throw new SaqueInvalidoException("Voce nao possui saldo!");
		}  else if(valor > limiteSaque) {
			throw new SaqueInvalidoException("O valor excede o limite de saque!");
		} if (valor > saldo) {
			throw new SaqueInvalidoException("Não há equilíbrio suficiente");
		}
		
		saldo -= valor;
	}

}
