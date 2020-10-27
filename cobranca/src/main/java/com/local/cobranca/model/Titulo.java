package com.local.cobranca.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Titulo {
	
	private Long 			codigo;
	private String  		descricao;
	private Date    		dataVencimento;
	private BigDecimal		valor;
	private StatusTitulo	status;	
	
	public Titulo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	
	@NotBlank(message = "descrição é obrigatória")
	@Size( max = 60, message = "A descrição não pode conter mais de 60 caracteres")
	@Column(name = "descricao")
	public String getDescricao() {
		return descricao;
	}
	
	@NotNull(message = "Date de vencimento é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	@NotNull
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	public BigDecimal getValor() {
		return valor;
	}
	
	@Enumerated(EnumType.STRING)
	public StatusTitulo getStatus() {
		return status;
	}	
	
	
	//--------------- SETs ---------------
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public void setStatus(StatusTitulo status) {
		this.status = status;
	}

    @Transient
    public boolean isPendente(){
    	return StatusTitulo.PENDENTE.equals(this.status);
    }	
	
	//--------------- HashCode e Equals ---------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}		
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
	
	@Override
	public String toString() {
		return "Titulo [codigo=" + codigo + ", descricao=" + descricao + ", dataVencimento=" + dataVencimento
				+ ", valor=" + valor + ", status=" + status + "]";
	}	
	
}