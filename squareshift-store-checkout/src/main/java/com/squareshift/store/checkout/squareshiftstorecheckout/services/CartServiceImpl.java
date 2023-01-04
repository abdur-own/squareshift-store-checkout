package com.squareshift.store.checkout.squareshiftstorecheckout.services;

import java.util.ArrayList;
import java.util.List;

import com.squareshift.store.checkout.squareshiftstorecheckout.dto.CartItems;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.CartItemsWithTotalAmount;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.GetProductResponse;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.Product;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.WarehouseDistance;
import com.squareshift.store.checkout.squareshiftstorecheckout.repository.ProductDetailsService;

import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

	private ProductDetailsService productDetailsService;

	private static final double shipingCharges[][] = { { 12, 15, 20, 50, 100, 220 }, { 14, 18, 24, 55, 110, 250 },
			{ 16, 25, 30, 80, 130, 270 }, { 21, 35, 50, 90, 150, 300 } };

	public CartServiceImpl(ProductDetailsService productDetailsService) {
		super();
		this.productDetailsService = productDetailsService;
	}

	@Override
	public CartItems getCartItems() {
		CartItems cartItems = new CartItems();
		List<Product> products = new ArrayList<>();
		for (int i = 100; i < 120; i++) {
			products.add(getProduct(String.valueOf(i)));
		}
		cartItems.setItems(products);
		return cartItems;
	}

	private Product getProduct(String productId) {
		GetProductResponse response = this.productDetailsService.getProduct(productId);
		return response.getResponse();

	}

	@Override
	public String saveCartItem(Product product) {
		if (0 != product.getId()) {
			return "Updated Successfully.";
		} else {
			return "Save Successfully.";
		}
	}

	@Override
	public CartItemsWithTotalAmount getCheckoutCartValue(final String shipping_postal_code) throws NumberFormatException {
		// Taking last digit as the number of product in the cart
		int numberOfProduct = (int) (Long.valueOf(shipping_postal_code) % 10);
		CartItemsWithTotalAmount cartItems = new CartItemsWithTotalAmount();
		List<Product> products = new ArrayList<>();
		double totalAmount = 0;
		double totalWeight = 0;
		double totalDiscount = 0;
		WarehouseDistance wareHouseDistance = this.productDetailsService.getWarehouseDistance(shipping_postal_code);
		for (int i = 100; i < (100 + numberOfProduct); i++) {
			Product product = this.productDetailsService.getProduct(String.valueOf(i)).getResponse();
			products.add(product);
			totalWeight = totalWeight + product.getWeight_in_grams();
			totalAmount = totalAmount + getDiscountedPrice(product);
			totalDiscount = totalDiscount + getDiscount(product);
		}
		double shipingCost = getShipingCharge(wareHouseDistance, totalWeight);
		cartItems.setProducts(products);
		cartItems.setTotalDiscount(totalDiscount);
		cartItems.setTotalWeight(totalWeight);
		cartItems.setShipingCost(shipingCost);
		cartItems.setTotalAmount(totalAmount + shipingCost);
		return cartItems;
	}

	private double getShipingCharge(final WarehouseDistance wareHouseDistance, final double totalWeight) {
		double weightInkg =  totalWeight/1000.0;
		if (weightInkg <= 2) {
			return this.shipingCharges[0][getIndexAccordingToWeight(wareHouseDistance.getDistance_in_kilometers())];
		} else if (weightInkg <= 5 && weightInkg > 2) {
			return this.shipingCharges[1][getIndexAccordingToWeight(wareHouseDistance.getDistance_in_kilometers())];
		} else if (weightInkg <= 20 && weightInkg > 5) {
			return this.shipingCharges[2][getIndexAccordingToWeight(wareHouseDistance.getDistance_in_kilometers())];
		} else {
			return this.shipingCharges[3][getIndexAccordingToWeight(wareHouseDistance.getDistance_in_kilometers())];
		}
	}

	private int getIndexAccordingToWeight(long totalWeight) {
		if (totalWeight < 5) {
			return 0;
		} else if (totalWeight >= 5 && totalWeight < 20) {
			return 1;
		} else if (totalWeight >= 20 && totalWeight < 50) {
			return 2;
		} else if (totalWeight >= 50 && totalWeight < 500) {
			return 3;
		} else if (totalWeight >= 500 && totalWeight < 800) {
			return 4;
		} else {
			return 5;
		}

	}

	private double getDiscountedPrice(Product product) {
		return product.getPrice() - getDiscount(product);
	}

	private double getDiscount(Product product) {
		double totalPriceAfterDiscount = ((product.getDiscount_percentage() / 100.00) * product.getPrice());
		return  totalPriceAfterDiscount;
	}

	@Override
	public String deleteCart(String cartId) {
		return "User Cart Deleted Successfully.";
	}

}
