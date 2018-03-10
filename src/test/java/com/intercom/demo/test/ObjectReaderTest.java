package com.intercom.demo.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

import com.intercom.demo.model.Customer;
import com.intercom.demo.utility.ObjectReader;

public class ObjectReaderTest {

	@Test
	public void testNonExceptionCases() {
	  try {
      ObjectReader reader=new ObjectReader(Customer.class);
      reader.readObject(null, "");
      reader.readObject("File", "gist.txt");
	}
	  catch(Exception e) {
		  System.out.println(e.getMessage());
		  Assert.fail();
	  }
	}
	
	@Test(expected=IOException.class)
	public void testExceptionCase() throws Exception {
		ObjectReader reader=new ObjectReader(Customer.class);
		reader.readObject("URL", "sds");
		reader.readObject("File", "gist.txt");

	}

}
