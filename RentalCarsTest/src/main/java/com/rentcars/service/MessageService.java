package com.rentcars.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	 ParseJson parseJson;
	
    @Value("${name:unknown}")
    private String name;
    
    @Value("${listcars:unkown}")
    private String listcars;

    public void getMessage(){
     	
      getMessage(listcars);	
    }
    
    
    public void getMessage(String listcars) {
    	
    	
    	UtilCarRent.printAllCars(parseJson.listAllCars());
    	UtilCarRent.printAllCarsFormat(parseJson.readTypesFormat());  
    	ParseJson.printHighestRatePerType(); 
    	ParseJson.printVehicleScores();
    	
    	
    }

}