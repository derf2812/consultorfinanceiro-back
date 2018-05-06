package br.com.consultorfinanceiro.consultorfinanceiroback.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoLancamento 
{
	@Id
	@GeneratedValue
	private int idTipoLancamento;
	
	@Column
	private String descricaoLancamento;

	public int getIdTipoLancamento() {
		return idTipoLancamento;
	}

	public void setIdTipoLancamento(int idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}
}