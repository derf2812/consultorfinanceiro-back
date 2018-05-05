package br.com.consultorfinanceiro.servico;

import java.util.Date;

import br.com.consultorfinanceiro.modelo.Categoria;
import br.com.consultorfinanceiro.modelo.Conta;
import br.com.consultorfinanceiro.modelo.Lancamento;
import br.com.consultorfinanceiro.modelo.TipoLancamento;

public class ServicolancamentoImpl implements ServicoLancamento {

	@Override
	public void fazerLancamento(TipoLancamento tpoLancamento, Conta conta, Categoria categoria, int prazo, double valorLancamento) {
		
		Lancamento lancamento = new Lancamento();
		lancamento.setTipolancamento(tpoLancamento);
		lancamento.setConta(conta);
		lancamento.setCategoria(categoria);
		lancamento.setDataLancamento(new Date());
		lancamento.setPrazo(prazo);
		lancamento.setValorLancamento(valorLancamento);
		
		//salvar lancamento no bd
		
		double saldo = conta.getSaldo()+valorLancamento;
		conta.setSaldo(saldo );
		
		//salvar conta no bd

	}

}
