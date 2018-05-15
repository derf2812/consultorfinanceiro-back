package br.com.consultorfinanceiro.consultorfinanceiroback.utils;

public class RetornoJS<T> {
	private String msgError;
	private T data;
	
	public RetornoJS(String msgError) {
		this.msgError = msgError;
	}
	
	public RetornoJS(T data) {
		this.data = data;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}