package br.com.consultorfinanceiro.consultorfinanceiroback.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>
{

}