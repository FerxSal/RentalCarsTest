package com.rentcars.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentcars.model.CarPrice;
import com.rentcars.model.CarRating;
import com.rentcars.model.CarScore;
import com.rentcars.model.CarSipp;


@Service
public class ParseJson {
 
	public static String vehicleURL = "http://www.rentalcars.com/js/vehicles.json";
	
	
	public List<CarPrice> listAllCars(){
	
	 ObjectMapper mapper = new ObjectMapper();
	 List<CarPrice>  carPrice = new ArrayList<CarPrice>();
     try {
    	 
         
         Map<String, Object> map = mapper.readValue(new URL(vehicleURL), new TypeReference<HashMap<String,Object>>(){});
      
         if  (map.containsKey("Search")){
        	 
        	 LinkedHashMap<String,List<LinkedHashMap<String,String>>> list = (LinkedHashMap<String,List<LinkedHashMap<String,String>>>)(map.get("Search")); 
        	 if (list != null && !list.isEmpty()){
        		 List<LinkedHashMap<String,String>> vehicle = list.get("VehicleList");
     
        		
        		 for (LinkedHashMap<String,String> elem : vehicle)
        		     if (elem.containsKey("name"))
        		       carPrice.add(new CarPrice( elem.get("name"),String.valueOf(elem.get("price"))));
        		       
        		 carPrice.sort(Comparator.comparing(CarPrice::getPrice));
        		 //carPrice.forEach(elem->System.out.println("{"+elem.getName()+"}"+"-"+"{"+elem.getPrice()+"}"));
         		 
        	 }
    	        	 
         }
        
     } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
	 return carPrice;
	
	}
	public List<CarSipp> readTypesFormat(){
		
		 ObjectMapper mapper = new ObjectMapper();
		 List<CarSipp>   carSipp = new ArrayList<CarSipp>();
		 
	     try {
	    	 
	         
	         Map<String, Object> map = mapper.readValue(new URL(vehicleURL), new TypeReference<HashMap<String,Object>>(){});
	         
	         if  (map.containsKey("Search")){
	        	 
	        	 LinkedHashMap<String,List<LinkedHashMap<String,String>>> list = (LinkedHashMap<String,List<LinkedHashMap<String,String>>>)(map.get("Search")); 
	        	 if (list != null && !list.isEmpty()){
	        		 List<LinkedHashMap<String,String>> vehicle = list.get("VehicleList");
	     
	        		 for (LinkedHashMap<String,String> elem : vehicle)
	        		     if (elem.containsKey("name")){ 
	        		       carSipp.add(new CarSipp(elem.get("name"), elem.get("sipp") , 
	        		    		   UtilCarRent.getCharacters(elem.get("sipp").substring(0, 1),0) ,
	        		    		   UtilCarRent.getCharacters(elem.get("sipp").substring(1, 2),1), 
	        		    		   UtilCarRent.getCharacters(elem.get("sipp").substring(2, 3),2), UtilCarRent.getCharacters(elem.get("sipp").substring(3, 4),3), UtilCarRent.getCharacters(elem.get("sipp").substring(3, 4),4))); 
	        		     }

	        	 }
	    	        	 
	         }
	          	 	 
	         
	     } catch (Exception e) {
	         e.printStackTrace();
	     }

	     return carSipp;
	     
	}
	
	public static void printHighestRatePerType(){
		
		 ObjectMapper mapper = new ObjectMapper();
	     try {
	    	 
	         
	         Map<String, Object> map = mapper.readValue(new URL(vehicleURL), new TypeReference<HashMap<String,Object>>(){});
	         List<CarRating>   carRating = new ArrayList<CarRating>();
		
	         if  (map.containsKey("Search")){
	         
	        	 LinkedHashMap<String,List<LinkedHashMap<String,String>>> list = (LinkedHashMap<String,List<LinkedHashMap<String,String>>>)(map.get("Search")); 
	        	 if (list != null && !list.isEmpty()){
	        		 List<LinkedHashMap<String,String>> vehicle = list.get("VehicleList");
	        	 
	        		 for (LinkedHashMap<String,String> elem : vehicle)
	        		     if (elem.containsKey("name")){ 
	        		    	 carRating.add(new CarRating(elem.get("name"), UtilCarRent.getCharacters(elem.get("sipp").substring(0, 1),0), elem.get("supplier") , String.valueOf(elem.get("rating")) )); 
	        		    	 
	        		    	 
	        		     }
	        	 
	        		 
	         carRating.sort(Comparator.comparing(CarRating::getRating));
	         //System.out.println(carRating);
	        //group by carType
	         Map<String, List<CarRating>> groupBycarTypeMap =
	        		 carRating.stream().collect(Collectors.groupingBy(CarRating::getCartype));
	         
	         
	         
	         groupBycarTypeMap.forEach((key,value) -> {
	             value.forEach(elem->System.out.println("{"+elem.getName()+"}"+"-"+"{"+elem.getCartype()+"}"+"-"+"{"+elem.getSupplier()+"}"+"-"+"{"+elem.getRating()+"}"));
	         });
	         
	           
	         //carSipp.forEach(elem->System.out.println(
	        //System.out.println(groupBycarTypeMap);
		
	       }
	         }  }   
	     catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	     }
	   
	}
	
	
	public static void printVehicleScores(){
		
		ObjectMapper mapper = new ObjectMapper();
	     try {
	    	 
	         
	         Map<String, Object> map = mapper.readValue(new URL(vehicleURL), new TypeReference<HashMap<String,Object>>(){});
	         List<CarScore>   carScore = new ArrayList<CarScore>();
		
	         if  (map.containsKey("Search")){
	         
	        	 LinkedHashMap<String,List<LinkedHashMap<String,String>>> list = (LinkedHashMap<String,List<LinkedHashMap<String,String>>>)(map.get("Search")); 
	        	 if (list != null && !list.isEmpty()){
	        		 List<LinkedHashMap<String,String>> vehicle = list.get("VehicleList");
	        	 
	        		 for (LinkedHashMap<String,String> elem : vehicle)
	        		     if (elem.containsKey("name")){ 
	        		    	 carScore.add(new CarScore(elem.get("name"),
	        		    			 Integer.valueOf(UtilCarRent.getPoints(elem.get("sipp").substring(2, 3))) +  Integer.valueOf(UtilCarRent.getPoints(elem.get("sipp").substring(3, 4))), 
	        		    			 elem.get("supplier") , String.valueOf(elem.get("rating")) )); 
	        		    	 
	        		    	 
	        		     }
	        		 
	        		// Compute sum of salaries by department
	        		// Map<Department, Integer> totalByDept = employees.stream()
	        		// .collect(Collectors.groupingBy(Employee::getDepartment,
	        		// Collectors.summingInt(Employee::getSalary)));
	        		//Map<String, Integer> totalByDept = carScore.stream()
	     	        	//	.collect(Collectors.groupingBy(CarScore::getSupplier,
	     	        		// Collectors.summingInt(CarScore::getScore))); 
	        		
	        		
	        		 Map<String,Map<Integer,List<CarScore>>>  result = carScore.stream().collect(
	        		        Collectors.groupingBy(CarScore::getSupplier, 
	        		        Collectors.groupingBy(CarScore::getScore)));
	        		
	        		 
	        		System.out.println(result);
	        		 

	       }
	         }  }   
	     catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	     }

	}
	
	public static void printVehicleScoresWithBreakDown(){
		
		ObjectMapper mapper = new ObjectMapper();
	     try {
	    	 
	         
	         Map<String, Object> map = mapper.readValue(new URL(vehicleURL), new TypeReference<HashMap<String,Object>>(){});
	         List<CarScore>   carScore = new ArrayList<CarScore>();
		
	         if  (map.containsKey("Search")){
	         
	        	 LinkedHashMap<String,List<LinkedHashMap<String,String>>> list = (LinkedHashMap<String,List<LinkedHashMap<String,String>>>)(map.get("Search")); 
	        	 if (list != null && !list.isEmpty()){
	        		 List<LinkedHashMap<String,String>> vehicle = list.get("VehicleList");
	        	 
	        		 for (LinkedHashMap<String,String> elem : vehicle)
	        		     if (elem.containsKey("name")){ 
	        		    	 carScore.add(new CarScore(elem.get("name"),
	        		    			 Integer.valueOf(UtilCarRent.getPoints(elem.get("sipp").substring(2, 3))) +  Integer.valueOf(UtilCarRent.getPoints(elem.get("sipp").substring(3, 4))), 
	        		    			 elem.get("supplier") , String.valueOf(elem.get("rating")) ));         		    	 
	        		    	 
	        		     }
	        		 
	        		// Compute sum of salaries by department
	        		// Map<Department, Integer> totalByDept = employees.stream()
	        		// .collect(Collectors.groupingBy(Employee::getDepartment,
	        		// Collectors.summingInt(Employee::getSalary)));
	        		//Map<String, Integer> totalByDept = carScore.stream()
	     	        	//	.collect(Collectors.groupingBy(CarScore::getSupplier,
	     	        		// Collectors.summingInt(CarScore::getScore))); 

	       }
	         }  }   
	     catch (Exception e) {
	         e.printStackTrace();
	     }
		
	}
	

	
}
