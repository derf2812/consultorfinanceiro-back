package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.ContaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Conta;
import br.com.consultorfinanceiro.consultorfinanceiroback.utils.Encrypt;
import br.com.consultorfinanceiro.consultorfinanceiroback.utils.RetornoJS;

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
	public ResponseEntity<RetornoJS<Conta>> saveConta( 
		final @RequestBody Conta conta )
	{
		try
		{
			conta.setSaldo(0d);
			conta.setSaldoDespesa(0d);
			conta.setSaldoReceita(0d);
			
			conta.setSenha( Encrypt.toHash( conta.getSenha( ) ) );
			
			Conta contaSalva = repositorio.save(conta);
			
			return new ResponseEntity<RetornoJS<Conta>>(new RetornoJS<>(contaSalva), HttpStatus.OK);
		} 
		catch( Exception e )
		{
			return new ResponseEntity<RetornoJS<Conta>>(new RetornoJS<>(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/conta/login")
	public ResponseEntity<RetornoJS<Conta>> login( 
		final @RequestBody Conta conta )
	{
		try
		{
			Optional<Conta> contaOpt = repositorio.findByLoginAndSenha(conta.getLogin(), Encrypt.toHash(conta.getSenha()));
			
			if(!contaOpt.isPresent()) {
				throw new RuntimeException("Login ou senha errados!");
			}
			
			return new ResponseEntity<RetornoJS<Conta>>(new RetornoJS<>(contaOpt.get()), HttpStatus.OK);
		} 
		catch( Exception e )
		{
			return new ResponseEntity<RetornoJS<Conta>>(new RetornoJS<>(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/conta/zerarsaldo/{contaId}")
	public void zerarSaldo( 
		@PathVariable("contaId") Integer contaId )
	{
		repositorio.findById( contaId ).ifPresent( c -> {
			c.setSaldo(0d);
			c.setSaldoDespesa(0d);
			c.setSaldoReceita(0d);
			repositorio.save(c);
		});
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.DELETE, value="/api/conta/{id}")
	public void deleteCategoria(@PathVariable("id") Integer id) 
	{		
		repositorio.deleteById(id);
	}
}