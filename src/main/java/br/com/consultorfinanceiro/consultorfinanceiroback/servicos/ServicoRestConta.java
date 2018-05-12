package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.ContaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Conta;

@RestController
public class ServicoRestConta 
{
	@Inject
	private ContaRepository repositorio;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/api/conta")
	public List<Conta> getContas( ) 
	{		
		return repositorio.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/api/conta/{contaId}")
	public Conta getConta( 
		@PathVariable("contaId") int contaId )
	{		
		return repositorio.findById( contaId ).get( );
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/conta")
	public void saveCategorias( 
		final @RequestBody Conta conta )
	{
		repositorio.save(conta);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/conta/zerarsaldo/{contaId}")
	public void saveCategorias( 
		@PathVariable("contaId") int contaId )
	{
		repositorio.findById( contaId ).ifPresent( c -> {
			c.setSaldo(0);
			repositorio.save(c);
		});
	}
}