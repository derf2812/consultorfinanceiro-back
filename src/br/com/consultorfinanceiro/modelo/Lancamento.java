package br.com.consultorfinanceiro.modelo;

import java.util.Date;

public class Lancamento {

	private int lancamentoId;
	private Categoria categoria;
	private Conta conta;
	private TipoLancamento tipolancamento;
	private int prazo;
	private double valorLancamento;
	private double taxa;
	private Date dataLancamento;
	private Date dataCancelamento;

	public int getLancamentoId() {
		return lancamentoId;
	}

	public void setLancamentoId(int lancamentoId) {
		this.lancamentoId = lancamentoId;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoLancamento getTipolancamento() {
		return tipolancamento;
	}

	public void setTipolancamento(TipoLancamento tipolancamento) {
		this.tipolancamento = tipolancamento;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
}
