package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;
import br.com.consultorfinanceiro.consultorfinanceiroback.servico.Servicolancamento;
import br.com.consultorfinanceiro.consultorfinanceiroback.servicos.dtp.ValidacaoPercentualDTO;

@RestController
public class ServicoRestLancamento 
{
	@Inject
	private Servicolancamento servicoLancamento;

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/api/lancamento")
	private Collection<Lancamento> getLancamentos( )
	{
		return servicoLancamento.getAllLancamentos();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/api/lancamento/conta/{id}")
	private Collection<Lancamento> getLancamentosPorConta( 
		@PathVariable("id") Integer contaId )
	{
		return servicoLancamento.findAllByContaId(contaId);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/lancamento")
	private void criarLancamento( 
		@RequestBody Lancamento lancamento )
	{
		servicoLancamento.fazerLancamento(lancamento);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.DELETE, value="/api/lancamento/{id}")
	private void apagarLancamento( 
		@PathVariable("id") int idLancamento )
	{
		servicoLancamento.apagarLancamento( idLancamento );
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/lancamento/validar-percentual-futuro")
	private ValidacaoPercentualDTO validarLancamento( 
		@RequestBody Lancamento lancamento )
	{
		return servicoLancamento.validarLancamento(lancamento);
	}
}