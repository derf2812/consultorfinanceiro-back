package br.com.consultorfinanceiro.consultorfinanceiroback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.TipoLancamento;

public interface TipoLancamentoRepository extends JpaRepository<TipoLancamento, Integer> 
{

}