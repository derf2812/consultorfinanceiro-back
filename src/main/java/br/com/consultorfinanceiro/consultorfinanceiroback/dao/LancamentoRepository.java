package br.com.consultorfinanceiro.consultorfinanceiroback.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> 
{
	@Query("select l from Lancamento l where l.conta.contaId = ?1")
	Collection<Lancamento> findAllByContaId(Integer contaId);
}