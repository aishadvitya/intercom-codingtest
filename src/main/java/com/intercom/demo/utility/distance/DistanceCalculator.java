package com.intercom.demo.utility.distance;

public interface DistanceCalculator {
	static final Double EARTH_RADIUS=6371.00;
	
	default  Double toRad(Double value) {
        return value * Math.PI / 180;
    }
    double calculateDistance(Double lat1,Double lon1,Double lat2, Double lon2) ;
}
