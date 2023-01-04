package com.squareshift.store.checkout.squareshiftstorecheckout.dto;

import java.util.List;

public class CartItemsWithTotalAmount {

	private double totalAmount;

	private double totalDiscount;

	private double shipingCost;

	private double totalWeight;

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

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public double getShipingCost() {
		return shipingCost;
	}

	public void setShipingCost(double shipingCost) {
		this.shipingCost = shipingCost;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

}
