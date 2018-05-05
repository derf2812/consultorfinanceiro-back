package br.com.consultorfinanceiro.consultorfinanceiroback.servico;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Categoria;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Conta;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.TipoLancamento;

public interface ServicoLancamento {
	
	public void fazerLancamento(TipoLancamento tpoLancamento, Conta conta, Categoria categoria, int prazo,
			double valorLancamento);

}
