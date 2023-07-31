package com.yuri.mypet.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);// envoca o metado que esta sendo estendido
	}

	public ObjectNotFoundException(String msg, Throwable cause) {// construtor
		super(msg, cause); // envoca o metado passando a mensagem ea causa do erro
	}

}
