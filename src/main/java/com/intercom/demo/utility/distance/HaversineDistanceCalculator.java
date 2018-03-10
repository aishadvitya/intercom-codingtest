package com.intercom.demo.utility.distance;

public class HaversineDistanceCalculator implements DistanceCalculator {
	 
	public  double calculateDistance(Double lat1,Double lon1,Double lat2, Double lon2) { 
		if(null!=lat2 && null!=lon2 && lat1!=null && lon1!=null) {
         Double latDistance = toRad(lat2-lat1);
         Double lonDistance = toRad(lon2-lon1);
         Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
                    Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
                    Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
         Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
         return EARTH_RADIUS * c;
		}
		return Double.MAX_VALUE;
    	 } 
   
}
