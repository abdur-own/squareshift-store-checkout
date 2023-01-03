package com.squareshift.store.checkout.squareshiftstorecheckout.dto;

import java.util.List;

public class CartItemsWithTotalAmount {

	private double totalAmount;

	private long totalDiscount;

	private long shipingCost;

	private long totalWeight;

	private List<Product> products;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(long totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public long getShipingCost() {
		return shipingCost;
	}

	public void setShipingCost(long shipingCost) {
		this.shipingCost = shipingCost;
	}

	public long getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(long totalWeight) {
		this.totalWeight = totalWeight;
	}

}
