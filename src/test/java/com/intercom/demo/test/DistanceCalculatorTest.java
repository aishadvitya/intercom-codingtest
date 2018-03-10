package com.intercom.demo.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.intercom.demo.utility.distance.DistanceCalculator;
import com.intercom.demo.utility.distance.HaversineDistanceCalculator;

public class DistanceCalculatorTest {
	DistanceCalculator distanceCalculator=new HaversineDistanceCalculator();
	@Test
	public void test() {
		Assert.assertEquals(distanceCalculator.calculateDistance(53.3381985, -6.2592576, 53.2451022, -6.238335),10.44,0.1);
		Assert.assertEquals(distanceCalculator.calculateDistance(null,null, 53.2451022, -6.238335),Double.MAX_VALUE,Double.MAX_VALUE);
		Assert.assertEquals(distanceCalculator.calculateDistance(null,null,null,null),Double.MAX_VALUE,0.0);
	
	}

}
