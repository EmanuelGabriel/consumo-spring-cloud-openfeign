package br.com.emanuelgabriel.service.exception;

import feign.Request;

public class CategoriaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int status;
	private byte[] responseBody;
	private Request request;

	public CategoriaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	protected CategoriaNaoEncontradaException(int status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.request = null;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public byte[] getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(byte[] responseBody) {
		this.responseBody = responseBody;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
