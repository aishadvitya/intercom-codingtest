package com.intercom.demo.controller;

import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.intercom.demo.model.Customer;
import com.intercom.demo.utility.distance.DistanceCalculator;
import com.intercom.demo.utility.distance.HaversineDistanceCalculator;

public class DetermineDistanceInvitation {
	private DistanceCalculator distanceCalculator=new HaversineDistanceCalculator();
	  
	 public List<Customer> getClosestCustomersForCoffee(Set<Customer> allCustomers,Double distance,Double sourceLat,Double sourceLon) throws UnsupportedEncodingException, MalformedURLException, IOException, EOFException {
		if(null==allCustomers || allCustomers.isEmpty() || distance==null || sourceLat==null || sourceLon==null) {
				return null;
			}
		List<Customer> filteredCustomer=allCustomers.parallelStream()
					.filter((Customer customer)-> null!=customer.getName() && null!=customer.getUser_id() && !customer.getName().isEmpty())	 
				    .filter( (Customer customer) -> (
				    		Double.compare(distanceCalculator.calculateDistance(sourceLat,sourceLon,customer.getLatitude(), customer.getLongitude()),distance)<0))
				    .sorted(Comparator.comparing(Customer::getUser_id))
				    .collect(Collectors.toList());
		
		
		return filteredCustomer;
		 
	}
	 
	 

}
