package com.intercom.demo.utility;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.core.io.ResourceLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

public class ObjectReader<T> {
	final Class<T> typeParameterClass;
	private final String URL="url";
	private final String FILE="file";
	
	
	public ObjectReader(Class<T> typeParameterClass){
		this.typeParameterClass=typeParameterClass;
	}
  
	public HashSet<T> readObject(String sourceType,String value) throws UnsupportedEncodingException, EOFException,IOException{
    	  if(sourceType==null || sourceType.isEmpty() ||  value==null || value.isEmpty()) {
    		  return null;
    	  }
    	  Reader reader=null;
    	  if(sourceType.equalsIgnoreCase(URL)) {
	   reader = new InputStreamReader(new URL(value).openStream(), "UTF-8");
    	  }
    	  else if(sourceType.equalsIgnoreCase(FILE)) {
    		  reader=new InputStreamReader(getClass().getClassLoader().getResourceAsStream(value));
    		  if(!reader.ready()) {
    			  return null;
    		  }
    	  }
    	  else {
    		  return null;
    	  }
	   Gson gson = new GsonBuilder().create();
       JsonStreamParser streamParser = new JsonStreamParser(reader);
       HashSet<T> listOfObjects=new HashSet<T>();
       while (streamParser.hasNext()) {
          JsonElement e = streamParser.next();
          if (e.isJsonObject()) {
              T m = gson.fromJson(e, typeParameterClass);
              listOfObjects.add(m);
          }
       }
	 return listOfObjects;  
    }
   
  
}
