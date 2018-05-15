package br.com.consultorfinanceiro.consultorfinanceiroback.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>
{
	Optional<Conta> findByLoginAndSenha(String login, String hash);
}