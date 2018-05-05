package br.com.consultorfinanceiro;

import java.util.List;

import br.com.consultorfinanceiro.dao.CategoriaDao;
import br.com.consultorfinanceiro.modelo.Categoria;
import br.com.consultorfinanceiro.modelo.Conta;
import br.com.consultorfinanceiro.modelo.TipoLancamento;
import br.com.consultorfinanceiro.servico.ServicoLancamento;
import br.com.consultorfinanceiro.servico.ServicolancamentoImpl;

public class Teste {

	public static void main(String[] args) {
		
		ServicoLancamento servico = new ServicolancamentoImpl();
		
		Conta conta = new Conta();
		Categoria categoriaSaldoInicial = new CategoriaDao().getByNome("Lazer");
		TipoLancamento receitaPontual = new TipoLancamento();
		
		servico.fazerLancamento(receitaPontual, conta , categoriaSaldoInicial, 0, 500);
		
		System.out.println(conta.getSaldo());
		System.out.println(categoriaSaldoInicial);
		
		
	}
	

}
