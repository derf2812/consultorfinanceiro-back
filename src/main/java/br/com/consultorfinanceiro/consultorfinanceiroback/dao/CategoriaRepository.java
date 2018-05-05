package br.com.consultorfinanceiro.consultorfinanceiroback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> 
{
	
}