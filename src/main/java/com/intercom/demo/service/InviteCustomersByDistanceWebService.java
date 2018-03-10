package com.intercom.demo.service;

import java.io.EOFException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intercom.demo.controller.DetermineDistanceInvitation;
import com.intercom.demo.model.Customer;
import com.intercom.demo.utility.ObjectReader;

@RestController
@Configuration
@PropertySource("classpath:demo.properties")
public class InviteCustomersByDistanceWebService{
	@Value("${source}")
	String type;
	
	@Value("${distance}")
	Double distance;
	
	@Value("${sourceLatitude}")
	Double lat1;
	
        @Value("${sourceLongitude}")
		Double lon1;
        
        @Value("${sourceLocation}")
        String value;
	
	@RequestMapping("/invitedCustomers")
	@ResponseBody
	public String inviteCustomer() {
		DetermineDistanceInvitation inviteCustomer=new DetermineDistanceInvitation();
		try {
			 List<Customer> invitees= inviteCustomer
					 .getClosestCustomersForCoffee(new ObjectReader<Customer>(Customer.class).readObject(type,value), distance,lat1,lon1);;
			 if(invitees==null || invitees.isEmpty()) {
				 return "No one to invite :( sorry!";
				
			 }
			 System.out.println(invitees);
			 return invitees.toString();
			 
		}
		catch(IOException eof) {
			 Logger.getGlobal().severe("Exception occured while reading file/URL - Message is"+eof.getMessage());
			 return "Ooops. Error occured while trying to get invitees";
		}
		catch (Exception e) {
			 Logger.getGlobal().severe("Exception occured while reading file/URL - Message is"+e.getMessage());
			 return "Ooops. Error occured while trying to get invitees";
		}
		
	}

	
}
