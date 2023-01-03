package com.squareshift.store.checkout.squareshiftstorecheckout.repository;

import com.squareshift.store.checkout.squareshiftstorecheckout.dto.GetProductResponse;
import com.squareshift.store.checkout.squareshiftstorecheckout.dto.WarehouseDistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import static java.text.MessageFormat.format;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	private WebClient webClient;

	@Value("${sqareshift.get.product.by.id}")
	private String getProductUrl;

	@Value("${sqareshift.get.warehouse.distance}")
	private String getWarehouseDistanceUrl;

	@Autowired
	public ProductDetailsServiceImpl(WebClient webClient) {
		super();
		this.webClient = webClient;
	}

	@Override
	public GetProductResponse getProduct(String productId) {
		String productUrl = format(getProductUrl, productId);
		return webClient.get().uri(productUrl).retrieve().bodyToMono(GetProductResponse.class).block();
	}

	@Override
	public WarehouseDistance getWarehouseDistance(long postalCode) {
		String wareHouseDistanceUrl = format(getWarehouseDistanceUrl, postalCode);
		return webClient.get().uri(wareHouseDistanceUrl).retrieve().bodyToMono(WarehouseDistance.class).block();
	}

}
