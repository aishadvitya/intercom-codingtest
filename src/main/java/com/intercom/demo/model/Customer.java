package com.intercom.demo.model;

public class Customer {
  private String name;
  private Integer user_id;
  private Double latitude;
  private Double longitude;
  

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String toString() {
   return "ID: "+this.user_id+" NAME "+this.name +"\n";	
}

public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public Double getLatitude() {
	return latitude;
}
public void setLatitude(Double latitude) {
	this.latitude = latitude;
}
public Double getLongitude() {
	return longitude;
}
public void setLongitude(Double longitude) {
	this.longitude = longitude;
}
@Override
public boolean equals(Object o) {

    // If the object is compared with itself then return true  
    if (o == this) {
        return true;
    }

    /* Check if o is an instance of Complex or not
      "null instanceof [type]" also returns false */
    if (!(o instanceof Customer)) {
        return false;
    }
    Customer   other = (Customer) o;
    return this.getUser_id().equals(other.getUser_id());
}
}
