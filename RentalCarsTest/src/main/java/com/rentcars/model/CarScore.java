package com.rentcars.model;

public class CarScore {

	private String name;
	private Integer score;
	private String supplier;
	private String rating;
	
	public CarScore(String name, Integer score, String supplier, String rating) {
		super();
		this.name = name;
		this.score = score;
		this.supplier = supplier;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "CarScore [name=" + name + ", score=" + score + ", supplier=" + supplier + ", rating=" + rating + "]";
	}
		
	
}
