package com.rentcars.model;

import java.util.Comparator;
import java.util.List;

public class CarPrice implements Comparator<CarPrice>{

	private String name;
	private String price;
	
	public CarPrice(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	void PrettyPrintOutList(List<CarPrice> l){
		
	  if (l != null && !l.isEmpty()){
		  
		 for (CarPrice elem : l)
			System.out.println("{"+elem.getName()+"}"+"-"+"{"+elem.getPrice()+"}"); 
	  }
	  	
	}
	
	@Override
	public int compare(CarPrice o1, CarPrice o2) {
		// TODO Auto-generated method stub
		return Double.compare(Double.parseDouble(o1.getPrice()), Double.parseDouble(o2.getPrice()));
	}
	
	
}
