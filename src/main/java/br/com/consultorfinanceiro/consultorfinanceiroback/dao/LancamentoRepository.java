package br.com.consultorfinanceiro.consultorfinanceiroback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> 
{

}