package com.github.apeforge.ironape.commons.util;

public class IronApeException extends RuntimeException {

	private static final long serialVersionUID = -6322141382910309264L;

	public IronApeException() {
	}

	public IronApeException(String message) {
		super(message);
	}

	public IronApeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IronApeException(Throwable cause) {
		super(cause);
	}

}
