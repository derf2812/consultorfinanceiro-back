package br.com.consultorfinanceiro.consultorfinanceiroback.servicos;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultorfinanceiro.consultorfinanceiroback.dao.CategoriaRepository;
import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Categoria;

@RestController
public class ServicoTeste 
{
	@Inject
	CategoriaRepository categoriaRepository;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, name="/api/categoria")
	public List<Categoria> getCategorias( ) 
	{		
		return categoriaRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, name="/api/categoria")
	public void saveCategorias( 
		final @RequestBody Categoria categoria )
	{
		categoriaRepository.save(categoria);
	}
}