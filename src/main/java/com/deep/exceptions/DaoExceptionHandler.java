 package com.deep.exceptions;

public class DaoExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DaoExceptionHandler(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoExceptionHandler(String message) {
		super(message);
	}

	public DaoExceptionHandler(Throwable cause) {
		super(cause);
	}

}
