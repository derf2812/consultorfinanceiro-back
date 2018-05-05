package br.com.consultorfinanceiro.modelo;

import java.util.ArrayList;

public class Categoria {

	private int categoriaId;
	private String nomeCategoria;
	private String tipoLancamentoCategoria;
	
	
	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getTipoLancamentoCategoria() {
		return tipoLancamentoCategoria;
	}

	public void setTipoLancamentoCategoria(String tipoLancamentoCategoria) {
		this.tipoLancamentoCategoria = tipoLancamentoCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [categoriaId=" + categoriaId + ", nomeCategoria=" + nomeCategoria
				+ ", tipoLancamentoCategoria=" + tipoLancamentoCategoria + "]";
	}
	
		

}
