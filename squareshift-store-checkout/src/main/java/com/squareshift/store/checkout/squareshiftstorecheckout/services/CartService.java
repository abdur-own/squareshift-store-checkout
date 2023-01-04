package com.squareshift.store.checkout.squareshiftstorecheckout.services;

import com.squareshift.store.checkout.squareshiftstorecheckout.dto.CartItems;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.CartItemsWithTotalAmount;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.Product;

public interface CartService {

	/**
	 * @return CartItems
	 */
	public CartItems getCartItems();

	/**
	 * @param product
	 * @return String
	 */
	public String saveCartItem(final Product product);

	/**
	 * @param shipping_postal_code
	 * @return CartItemsWithTotalAmount
	 */
	public CartItemsWithTotalAmount getCheckoutCartValue(final String shipping_postal_code);

	/**
	 * @return
	 */
	public String deleteCart(final String cartId);
}
