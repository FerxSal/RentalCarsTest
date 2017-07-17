package com.rentcars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle implements Comparable<Vehicle> {

	@JsonProperty
	private String sipp;
	@JsonProperty
	private String name;
	@JsonProperty
	private float price;
	@JsonProperty
	private String supplier;
	@JsonProperty
	private float rating;
	
	public String getSipp() {
		return sipp;
	}
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Vehicle [sipp=" + sipp + ", name=" + name + ", price=" + price + ", supplier=" + supplier + ", rating="
				+ rating + "]";
	}

	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		return Float.compare(this.getPrice(), o.getPrice());
	}


	
}
