package entities;

import java.util.Date;

import utilitarios.Util;

public class Cliente {
	private String nome;
	private String email;
	private Date dataNascimento;

	public Cliente() {
	}

	public Cliente(String nome, String email, Date dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(" (");
		sb.append(Util.FORMAT_DD_MM_YYYY.format(this.dataNascimento));
		sb.append(")");
		sb.append(" - ");
		sb.append(this.email);
		return sb.toString();
		
	}
	
}
