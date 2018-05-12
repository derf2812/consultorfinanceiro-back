package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.CategoriaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Categoria;

@RestController
public class ServicoRestCategoria 
{
	@Inject
	private CategoriaRepository categoriaRepository;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="/api/categoria")
	public List<Categoria> getCategorias( ) 
	{		
		return categoriaRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/api/categoria")
	public void saveCategorias( 
		final @RequestBody Categoria categoria )
	{
		categoriaRepository.save(categoria);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.DELETE, value="/api/categoria/{id}")
	public void deleteCategorias( @PathVariable("id") Integer id  )
	{
		categoriaRepository.deleteById(id);
	}
}