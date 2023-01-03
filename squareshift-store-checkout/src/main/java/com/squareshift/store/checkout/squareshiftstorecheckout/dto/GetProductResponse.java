package com.squareshift.store.checkout.squareshiftstorecheckout.dto;

public class GetProductResponse {

	private Product response;

	private int status;

	public Product getResponse() {
		return response;
	}

	public void setResponse(Product response) {
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
