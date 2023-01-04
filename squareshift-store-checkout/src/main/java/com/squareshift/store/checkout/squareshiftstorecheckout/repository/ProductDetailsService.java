package com.squareshift.store.checkout.squareshiftstorecheckout.repository;

import com.squareshift.store.checkout.squareshiftstorecheckout.dto.GetProductResponse;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.WarehouseDistance;

public interface ProductDetailsService {

	/**
	 * @param productId
	 * @return GetProductResponse
	 */
	public GetProductResponse getProduct(String productId);
	
	/**
	 * @param postalCode
	 * @return WarehouseDistance
	 */
	public WarehouseDistance getWarehouseDistance(final String postalCode);
}
