package com.squareshift.store.checkout.squareshiftstorecheckout.dto;

public class Product {

	private String category;
	
	private String description;
	
	private int discount_percentage;
	
	private long id;
	
	private String image;
	
	private long price;
	
	private Rating rating;
	
	private String title;
	
	private long weight_in_grams;

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(int discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getWeight_in_grams() {
		return weight_in_grams;
	}

	public void setWeight_in_grams(long weight_in_grams) {
		this.weight_in_grams = weight_in_grams;
	}
}
