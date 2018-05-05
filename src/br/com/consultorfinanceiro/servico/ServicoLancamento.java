package br.com.consultorfinanceiro.servico;

import br.com.consultorfinanceiro.modelo.Categoria;
import br.com.consultorfinanceiro.modelo.Conta;
import br.com.consultorfinanceiro.modelo.TipoLancamento;

public interface ServicoLancamento {
	
	public void fazerLancamento(TipoLancamento tpoLancamento, Conta conta, Categoria categoria, int prazo,
			double valorLancamento);

}
