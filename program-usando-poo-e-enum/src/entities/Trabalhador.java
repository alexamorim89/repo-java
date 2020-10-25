package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelDeTrabalho;

public class Trabalhador {
	private String nome;
	private NivelDeTrabalho nivel;
	private Double salarioBase;

	private Departamento departamento;
	private List<ContratoPorHora> contratos = new ArrayList<ContratoPorHora>();

	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelDeTrabalho nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDeTrabalho getNivel() {
		return nivel;
	}

	public void setNivel(NivelDeTrabalho nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoPorHora> getContratos() {
		return contratos;
	}

	public void adicionaContrato(ContratoPorHora contrato) {
		this.contratos.add(contrato);
	}
	
	public void removeContrato(ContratoPorHora contrato) {
		this.contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = this.salarioBase;
		Calendar calendar = Calendar.getInstance();
		for (ContratoPorHora c : contratos) {
			calendar.setTime(c.getData());
			int c_ano = calendar.get(Calendar.YEAR);
			int c_mes = 1 + calendar.get(Calendar.MONTH);
			
			if(ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();				
			}
		}
		return soma;
	}
	
	
	
}
