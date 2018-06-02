package br.com.consultorfinanceiro.consultorfinanceiroback.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private int contaId;
	
	@Column(unique=true)
	private String login;
	
	@Column
	private String senha;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale="pt-br")
	private Date dataImplantacao;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataCadastro;
	
	@Column
	private Double saldo;
	
	@Column
	private Double saldoReceita;
	
	@Column
	private Double saldoDespesa;
	
	@Column
	private String nomeUsuario;
	
	@Column
	private String email;
	
	@Column(precision=2)
	private Double limiteGastoMensal;

	public int getContaId() {
		return contaId;
	}

	public void setContaId(int contaId) {
		this.contaId = contaId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataImplantacao() {
		return dataImplantacao;
	}

	public void setDataImplantacao(Date dataImplantacao) {
		this.dataImplantacao = dataImplantacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Double getSaldoReceita() {
		return saldoReceita == null ? 0 : saldoReceita;
	}

	public void setSaldoReceita(Double saldoReceita) {
		this.saldoReceita = saldoReceita;
	}

	public Double getSaldoDespesa() {
		return saldoDespesa == null ? 0 : saldoDespesa;
	}

	public void setSaldoDespesa(Double saldoDespesa) {
		this.saldoDespesa = saldoDespesa;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getLimiteGastoMensal() {
		return limiteGastoMensal;
	}

	public void setLimiteGastoMensal(Double limiteGastoMensal) {
		this.limiteGastoMensal = limiteGastoMensal;
	}
}