package com.rentcars.model;

public class CarSipp {

	private String name;
	private String sipp;
	private String cartype;
	private String cartypedoors;
	private String transmission;
	private String fuel;
	private String aircon;
	
	public CarSipp(String name, String sipp, String cartype, String cartypedoors, String transmission, String fuel,
			String aircon) {
		super();
		this.name = name;
		this.sipp = sipp;
		this.cartype = cartype;
		this.cartypedoors = cartypedoors;
		this.transmission = transmission;
		this.fuel = fuel;
		this.aircon = aircon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSipp() {
		return sipp;
	}
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCartypedoors() {
		return cartypedoors;
	}
	public void setCartypedoors(String cartypedoors) {
		this.cartypedoors = cartypedoors;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getAircon() {
		return aircon;
	}
	public void setAircon(String aircon) {
		this.aircon = aircon;
	}
	
	
	@Override
	public String toString() {
		return "CarSipp [name=" + name + ", sipp=" + sipp + ", cartype=" + cartype + ", cartypedoors=" + cartypedoors
				+ ", transmission=" + transmission + ", fuel=" + fuel + ", aircon=" + aircon + "]";
	}
	

	
}
