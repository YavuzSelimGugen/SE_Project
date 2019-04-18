/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo01;

/**
 *
 * @author YavuzSelim
 */
public class Vehicle {
    private int id;
    private String startDate;
    private String destination;
    private String takeoff; // kalkis noktasi
    private int duration,capacity, price;

    Vehicle(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }
    public void setTravel(String startDate,
            String takeoff, 
            String destination, 
            int duration, 
            int capacity,
            int price){
        this.setDestination(destination);
        this.setDuration(duration);
        this.setTakeoff(takeoff);
        this.setCapacity(capacity);
        this.setStartDate(startDate);
        this.setPrice(price);
    }
    
    public void sellTicket() {
        setCapacity(this.capacity-1);
    }
    
    public boolean isCapacityFull () {
        return getCapacity() > 0;
    }
    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the takeoff
     */
    public String getTakeoff() {
        return takeoff;
    }

    /**
     * @param takeoff the takeoff to set
     */
    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
