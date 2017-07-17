package com.rentcars.controller;

import java.util.List;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentcars.model.CarPrice;
import com.rentcars.model.CarSipp;
import com.rentcars.service.ParseJson;

@RestController
@RequestMapping("/rentcars")
public class CarController {

	
	@Autowired
	private ParseJson parseJson;
	
	@RequestMapping(value = "/listcars", method = RequestMethod.GET)
    public ResponseEntity<List<CarPrice>> getCars(){
			
		List<CarPrice>  listcars = parseJson.listAllCars();	
		
		  if (listcars.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	           
	        }

		  return new ResponseEntity<List<CarPrice>>(listcars, HttpStatus.OK);
	
 	}
	
	
	@RequestMapping(value = "/listcarsformat", method = RequestMethod.GET)
	public  ResponseEntity<List<CarSipp>> readTypesFormat(){
		
		List<CarSipp>  listcarsformat = parseJson.readTypesFormat();	
		
		  if (listcarsformat.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	           
	        }

		  return new ResponseEntity<List<CarSipp>>(listcarsformat, HttpStatus.OK);
	
	}
	
	
}
