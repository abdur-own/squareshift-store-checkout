package com.squareshift.store.checkout.squareshiftstorecheckout.dto;

public class WarehouseDistance {
	
	private Long distance_in_kilometers;
	
	private int status;

	public Long getDistance_in_kilometers() {
		return distance_in_kilometers;
	}

	public void setDistance_in_kilometers(Long distance_in_kilometers) {
		this.distance_in_kilometers = distance_in_kilometers;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
