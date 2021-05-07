package com.estoqueapi.exception;

public class EstoqueApiException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7637203198163699060L;

	public EstoqueApiException(String exception) {
		super(exception);
	}

}
