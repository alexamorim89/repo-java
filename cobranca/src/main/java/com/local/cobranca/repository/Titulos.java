package com.local.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.cobranca.model.Titulo;

@Repository
public interface Titulos extends JpaRepository<Titulo, Long>{
	
	public List<Titulo> findByDescricaoContaining(String descricao);
	
	public List<Titulo> findByDescricaoIgnoreCase(String descricao);	
	
}
