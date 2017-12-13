/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmu.project.NetworkGraph;

/**
 *
 * @author Patrick
 */
public class Coordinate {
    double longitude;
    double latitude;
    
    public static final int EARTH_RADIUS = 6378137;
    
    public String toString(){
        return "(" + this.getLongitude() + "," + this.getLatitude() +")";
    }
    
    
    
    public Coordinate() {
    }
    
    /**
    * Calculates the great circle distance between to Coordinates based on their latitude and longitude values
    * @param start First Coordinate as Coordinate Instance
    * @param end Second Coordinate as Coordinate Instance
    * @return distance in meter
    */
    public static double computeDistance (Coordinate start, Coordinate end){
        //Idea based on http://www.tutego.de/blog/javainsel/2009/09/latitudelongitude-distance-in-java/ 
        
        double lat1 = start.getLatitude();
        double lon1 = start.getLongitude();
        double lat2 = end.getLatitude();
        double lon2 = end.getLongitude();
        
        double latSin = Math.sin(Math.toRadians(lat2 - lat1) / 2);
        double lonSin = Math.sin(Math.toRadians(lon2 - lon1) / 2);
        
        double a = latSin + lonSin + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * lonSin * lonSin;
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        double distance = Coordinate.EARTH_RADIUS * c;
        
        return distance;
        
        
    }
    
    public Coordinate(double lon, double lat) {
        this.longitude = lon;
        this.latitude  = lat;
    }
    
    
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    
}