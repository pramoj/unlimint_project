package com.unlimint.orders_parser.exception;

public class OrdersException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 342261773263144491L;

	public OrdersException(String message, Throwable cause) {

		super(message, cause);
	}

	public OrdersException(String message) {

		super(message);
	}

	public OrdersException(Throwable cause) {

		super(cause);
	}
}
