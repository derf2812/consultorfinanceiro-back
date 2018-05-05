package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.CategoriaDao;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Categoria;

@RestController
public class ServicoTeste 
{
	@RequestMapping("/api/categoria")
	public List<Categoria> getCategorias( ) 
	{
//		ServicoLancamento servico = new ServicolancamentoImpl();
//		
//		Conta conta = new Conta();
//		Categoria categoriaSaldoInicial = new CategoriaDao().getByNome("Lazer");
//		TipoLancamento receitaPontual = new TipoLancamento();
//		
//		servico.fazerLancamento(receitaPontual, conta , categoriaSaldoInicial, 0, 500);
//		
//		System.out.println(conta.getSaldo());
//		System.out.println(categoriaSaldoInicial);
		
		return new CategoriaDao().listar();
	}
}