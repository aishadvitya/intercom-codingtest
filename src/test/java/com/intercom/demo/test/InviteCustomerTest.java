package com.intercom.demo.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.junit.Test;

import com.intercom.demo.controller.DetermineDistanceInvitation;
import com.intercom.demo.model.Customer;

import junit.framework.Assert;

public class InviteCustomerTest {
	DetermineDistanceInvitation invitation=new DetermineDistanceInvitation();
	 Set<Customer> customers=new HashSet();
	@PostConstruct
	public void init() {
		
        
		Customer customer1=new Customer();
		customer1.setLatitude(null);
		customer1.setLongitude(null);
		customer1.setName("XX");
		customer1.setUser_id(1);
		
		Customer customer2=new Customer();
		customer2.setLatitude(10.10);
		customer2.setLongitude(20.10);
		customer2.setName("YY");
		customer2.setUser_id(2);
		
		Customer customer3=new Customer();
		customer3.setLatitude(334.3);
		customer3.setLongitude(23.2);
		customer3.setName("");
		customer3.setUser_id(null);
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		
	}
	@Test
	public void testPositive() {    
		 try {
    invitation.getClosestCustomersForCoffee(customers, 10.00, 123.12, 123.00);
    customers.clear();
   
		invitation.getClosestCustomersForCoffee(customers, 10.00, 123.12, 123.00);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		Assert.fail();
	}
    
	}
	
	@Test
	public void testNegative() {
		customers=null;
		try {
			invitation.getClosestCustomersForCoffee(null, null, null,  null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}
	}

}
