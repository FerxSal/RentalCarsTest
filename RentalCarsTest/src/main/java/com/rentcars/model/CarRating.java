package com.rentcars.model;

import java.util.Comparator;

public class CarRating implements Comparator<CarRating>{

	private String name;
	private String cartype;
	private String supplier;
	private String rating;
	

	public CarRating(String name, String cartype, String supplier, String rating) {
		super();
		this.name = name;
		this.cartype = cartype;
		this.supplier = supplier;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
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
	public int compare(CarRating o1, CarRating o2) {
		// TODO Auto-generated method stub
		return Double.compare(Double.parseDouble(o2.getRating()), Double.parseDouble(o1.getRating()));

	}

	@Override
	public String toString() {
		return "CarRating [name=" + name + ", cartype=" + cartype + ", supplier=" + supplier + ", rating=" + rating
				+ "]";
	}
	
    
}
