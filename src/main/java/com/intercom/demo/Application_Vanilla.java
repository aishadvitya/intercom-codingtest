package com.intercom.demo;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.intercom.demo.controller.DetermineDistanceInvitation;
import com.intercom.demo.model.Customer;
import com.intercom.demo.utility.ObjectReader;
import com.intercom.demo.utility.StringUtils;

public class Application_Vanilla {
	Properties properties = new Properties();
	String type;
	Double distance;
	Double lat1;
	Double lon1;
	String value;

	public Application_Vanilla() {
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(StringUtils.propertiesFile));
			type = properties.getProperty(StringUtils.source);
			distance = Double.valueOf(properties.getProperty(StringUtils.distance));
			lat1 = Double.valueOf(properties.getProperty(StringUtils.sourceLatitude));
			lon1 = Double.valueOf(properties.getProperty(StringUtils.sourceLongitude));
			value = properties.getProperty(StringUtils.sourceLocation);
		} catch (IOException e) {
			Logger.getGlobal().severe(e.getMessage());
		}
	}

	public static void main(String args[]) {
		Application_Vanilla evite = new Application_Vanilla();
		evite.getAllInvitations();
	}

	public void getAllInvitations() {
		try {

			DetermineDistanceInvitation inviteCustomer = new DetermineDistanceInvitation();
			List<Customer> invitees= inviteCustomer
					 .getClosestCustomersForCoffee(new ObjectReader<Customer>(Customer.class).readObject(type,value), distance,lat1,lon1);;
			 if(invitees==null || invitees.isEmpty()) {
				 System.out.println("No one to invite :( sorry!");
				return;
			 }
			 System.out.println(invitees);
			
			 
		} catch (Exception e) {
			Logger.getGlobal().severe("Exception occured while reading file/URL - Message is" + e.getMessage());
			
		}
	}
}
