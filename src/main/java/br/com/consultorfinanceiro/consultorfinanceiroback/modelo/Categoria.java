package br.com.consultorfinanceiro.consultorfinanceiroback.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue
	private int categoriaId;
	
	@Column
	private String nomeCategoria;
	
	@Column
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
