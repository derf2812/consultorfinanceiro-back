package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.TipoLancamentoRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.TipoLancamento;

@RestController
public class ServicoRestTipoLancamento 
{
	@Inject
	private TipoLancamentoRepository repository;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/api/tipolancamento")
	public List<TipoLancamento> getCategorias( ) 
	{		
		return repository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/tipolancamento")
	public void saveCategorias( 
		final @RequestBody TipoLancamento categoria )
	{
		repository.save(categoria);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.DELETE, value="/api/tipolancamento/{id}")
	public void deleteCategoria(@PathVariable("id") Integer id) 
	{		
		repository.deleteById(id);
	}
}