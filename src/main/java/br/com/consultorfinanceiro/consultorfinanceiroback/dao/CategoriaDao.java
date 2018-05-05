package br.com.consultorfinanceiro.consultorfinanceiroback.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.consultorfinanceiro.consultorfinanceiroback.modelo.Categoria;

public class CategoriaDao {

	private static List<Categoria> lst = new ArrayList<>();

	static {
		Categoria categoria1 = new Categoria();
		categoria1.setCategoriaId(1);
		categoria1.setNomeCategoria("Lazer");
		categoria1.setTipoLancamentoCategoria("Netflix");
		lst.add(categoria1);
	}
	
	public Categoria getByNome(String nome) {
		for(int i = 0; i < lst.size(); i++) {
			if(lst.get(i).getNomeCategoria().equalsIgnoreCase(nome)) {
				return lst.get(i);
			}
		}
		return null;
	}

	public List<Categoria> listar() {
		return lst;
	}

	public void salvar(Categoria categoria) {
		lst.add(categoria);
	}

}
