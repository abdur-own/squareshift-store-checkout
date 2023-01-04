package com.squareshift.store.checkout.squareshiftstorecheckout.web;

import com.squareshift.store.checkout.squareshiftstorecheckout.dto.CartItems;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.CartItemsWithTotalAmount;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.Product;
import com.squareshift.store.checkout.squareshiftstorecheckout.error.BadRequestException;
import com.squareshift.store.checkout.squareshiftstorecheckout.services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CartController {

	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@GetMapping(value = "/cart/items")
	public ResponseEntity<CartItems> getCartItems() {
		return new ResponseEntity<>(cartService.getCartItems(), HttpStatus.OK);

	}

	@PostMapping(value = "/cart/item")
	public ResponseEntity<String> saveCartItem(@RequestBody Product product) {
		String saveMessage = this.cartService.saveCartItem(product);
		return new ResponseEntity<>(saveMessage, HttpStatus.OK);
	}

	@GetMapping(value = "/cart/checkout-value")
	public ResponseEntity<CartItemsWithTotalAmount> getCheckoutValue(@RequestParam String shipping_postal_code) {
		try {
			validatePostalCode(Long.valueOf(shipping_postal_code));
			CartItemsWithTotalAmount checkoutValue = this.cartService.getCheckoutCartValue(shipping_postal_code);
			return new ResponseEntity<>(checkoutValue, HttpStatus.OK);
		} catch (NumberFormatException e) {
			throw new BadRequestException("Invalid postal code, valid ones are 465535 to 465545.");
		}

	}

	private void validatePostalCode(long shipping_postal_code) {
		if (shipping_postal_code > 465545 && shipping_postal_code < 465535) {
			throw new BadRequestException("Invalid postal code, valid ones are 465535 to 465545.");
		}
	}

	@DeleteMapping(value = "/cart")
	public ResponseEntity<String> deleteCartItems(@RequestParam String cartId) {
		return new ResponseEntity<>(this.cartService.deleteCart(cartId), HttpStatus.OK);

	}
}
