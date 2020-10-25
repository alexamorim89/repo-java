package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private Date verificaEntrada;
	private Date verificaSaida;
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date verificaEntrada, Date verificaSaida) {
		this.numeroQuarto = numeroQuarto;
		this.verificaEntrada = verificaEntrada;
		this.verificaSaida = verificaSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getVerificaEntrada() {
		return verificaEntrada;
	}

	public Date getVerificaSaida() {
		return verificaSaida;
	}
	
	public long duracao() {
		long diff = verificaSaida.getTime() - verificaEntrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizaDatas(Date verificaEntrada, Date verificaSaida) {
		Date now = new Date();
		if (verificaEntrada.before(now) || verificaSaida.before(now)) {
			throw new DomainException("as datas de reserva para atualização devem ser datas futuras");
		}
		if (!verificaSaida.after(verificaEntrada)) {
			throw new DomainException("a data de verificação de saida deve ser posterior à data de verificação de entrada");
		}		
		this.verificaEntrada = verificaEntrada;
		this.verificaSaida = verificaSaida;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Sala ");
		sb.append(this.numeroQuarto);
		sb.append(", verifica entrada: ");
		sb.append(sdf.format(this.verificaEntrada));
		sb.append(", verifica saida: ");
		sb.append(sdf.format(this.verificaEntrada));
		sb.append(", ");
		sb.append(this.duracao());
		sb.append(" noites");		
		return sb.toString();
	}
}