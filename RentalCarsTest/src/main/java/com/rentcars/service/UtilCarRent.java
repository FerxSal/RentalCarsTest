package com.rentcars.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rentcars.model.CarPrice;
import com.rentcars.model.CarSipp;

public class UtilCarRent {

	
	private static final Map<String, String> CAR_TYPE =
		    Arrays.stream(new String[][] {
		        { "M", "Mini" }, 
		        { "E", "Economy" }, 
		        { "C", "Compact" },
		        { "I", "Intermediate" },
		        { "S", "Standard" },
		        { "F", "Full size" }, 
		        { "L", "Luxury" }, 
		        { "X", "Special" },
		    }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
	
	private static final Map<String, String> CAR_DOORS_TYPE =
		    Arrays.stream(new String[][] {
		        { "B", "2 doors" }, 
		        { "C", "4 doors" }, 
		        { "D", "5 doors" },
		        { "W", "Estate" },
		        { "T", "Convertible" },
		        { "F", "SUV" }, 
		        { "P", "Pick up" }, 
		        { "V", "Passenger Van" },
		    }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
	
	
	private static final Map<String, String> CAR_TRANSMISSION_TYPE =
		    Arrays.stream(new String[][] {
		        { "M", "Manual" }, 
		        { "A", "Automatic" }, 
		   
		    }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
	
	
	private static final Map<String, String> CAR_FUEL_TYPE =
		    Arrays.stream(new String[][] {
		        { "N", "Petrol" }, 
		        { "R", "Petrol" }, 
		   
		    }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
	
	
	private static final Map<String, String> CAR_AIR_TYPE =
		    Arrays.stream(new String[][] {
		        { "N", "No airConditioning" }, 
		        { "R", "airConditioning" }, 
		   
		    }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
	
	
	private static final Map<String, String> CAR_BREAKDOWN =
		    Arrays.stream(new String[][] {
		        { "M", "1"}, 
		        { "A", "5"},
		        { "R", "2"},
		   
		    }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));
	
	
	public static String getCharacters(String sipp,int pos){
	
		if (!sipp.isEmpty()){
			
		  if  (CAR_TYPE.keySet().contains(sipp) && pos == 0)
			  return CAR_TYPE.get(sipp);
		
		  if (CAR_DOORS_TYPE.keySet().contains(sipp) && pos== 1)
		      return CAR_DOORS_TYPE.get(sipp);
		  
		  if (CAR_TRANSMISSION_TYPE.keySet().contains(sipp) && pos == 2)
			  return CAR_TRANSMISSION_TYPE.get(sipp);
		  
		  if (CAR_FUEL_TYPE.keySet().contains(sipp) && pos == 3)
			  return CAR_FUEL_TYPE.get(sipp);
		  
		  if (CAR_AIR_TYPE.keySet().contains(sipp) && pos == 4)
			  return CAR_AIR_TYPE.get(sipp);
 
		  
		}
		return "";
	}
	
	
	public static String getPoints(String sipp){
		
		if (!sipp.isEmpty()){
		
			if (CAR_BREAKDOWN.keySet().contains(sipp)){ 
				return CAR_BREAKDOWN.get(sipp);
			}
		}
		
		return "0";
	}
	

	public static void printAllCars(List<CarPrice> carPrice){
	
		 carPrice.forEach(elem->System.out.println("{"+elem.getName()+"}"+"-"+"{"+elem.getPrice()+"}"));
		
		
	}
	
	
	public static void printAllCarsFormat(List<CarSipp> carSipp){
		
		 carSipp.forEach(elem->System.out.println("{"+elem.getName()+"}"+"-"+
        		 elem.getSipp()+"-"+"{"+
        		 elem.getCartype()+"}"+"-"+
        		 elem.getCartypedoors()+"-"+"{"+
        		 elem.getTransmission()+"}"+"-"+"{"+elem.getFuel()+"}"+"-"+"{"+elem.getAircon()+"}" ));
		
		
	}
	
	
}
