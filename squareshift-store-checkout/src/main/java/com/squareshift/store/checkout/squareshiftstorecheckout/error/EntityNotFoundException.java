package com.squareshift.store.checkout.squareshiftstorecheckout.error;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4554989520492188877L;

	public EntityNotFoundException(String message) {
		super(message);
	}
}
