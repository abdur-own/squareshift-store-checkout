package com.squareshift.store.checkout.squareshiftstorecheckout.error;

public class BadRequestException extends RuntimeException {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1060291744450442898L;

	public BadRequestException(final String message) {
		super(message);
	}
}
