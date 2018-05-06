package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Lancamento;
import br.com.consultorfinanceiro.consultorfinanceiroback.servico.ServicoLancamento;

@RestController
public class ServicoRestLancamento 
{
	@Inject
	private ServicoLancamento servicoLancamento;

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/api/lancamento")
	private Collection<Lancamento> getLancamentos( )
	{
		return servicoLancamento.getAllLancamentos();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/lancamento")
	private void criarLancamento( 
		@RequestBody Lancamento lancamento )
	{
		servicoLancamento.fazerLancamento(lancamento);
	}
}