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
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataImplantacao;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataCadastro;
	
	@Column
	private double saldo;
	
	@Column
	private String nomeUsuario;
	
	@Column
	private String email;

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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
}