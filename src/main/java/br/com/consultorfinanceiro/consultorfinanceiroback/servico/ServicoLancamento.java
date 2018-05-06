package br.com.consultorfinanceiro.consultorfinanceiroback.servico;

import java.util.Collection;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;

public interface ServicoLancamento 
{
	public void fazerLancamento(Lancamento lancamento);

	public Collection<Lancamento> getAllLancamentos();

	public void apagarLancamento(int idLancamento);
}