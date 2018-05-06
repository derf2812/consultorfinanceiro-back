package br.com.consultorfinanceiro.consultorfinanceiroback.servico;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.CategoriaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.LancamentoRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.dao.TipoLancamentoRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;

@Component
public class ServicolancamentoImpl implements ServicoLancamento 
{
	@Inject private TipoLancamentoRepository tpoLancRepo;
	@Inject private CategoriaRepository catRepo;
	@Inject private LancamentoRepository lancRepo;
	
	@Override
	public void fazerLancamento(
		final Lancamento lancamento ) 
	{
		tpoLancRepo.findById(lancamento.getTipolancamento().getIdTipoLancamento())
			.ifPresent( lancamento::setTipolancamento );
		
		catRepo.findById( lancamento.getCategoria().getCategoriaId())
		    .ifPresent( lancamento::setCategoria );
		
		lancRepo.save( lancamento );
		
		//double saldo = conta.getSaldo()+valorLancamento;
		//conta.setSaldo(saldo );
		
		//salvar conta no bd
	}

	@Override
	public Collection<Lancamento> getAllLancamentos( )
	{
		return lancRepo.findAll();
	}
}