/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo01;

import java.util.ArrayList;

/**
 *
 * @author YavuzSelim
 */
public class Company {
    public Company(String name) {
        this.name = name;
    }
    private String name;
    ArrayList<Vehicle> vehicles;
    ArrayList<Hostel> hotels;
    
    public boolean findTravel (String date, String takeoff, String destination) {
        //kll,k
        return true;
    }
    public void findBooking (String date, String location) {
        
    }
    public void sellBooking (Hostel h) {
        
    }
    
    public void sellTicket(Vehicle v, Customer c) {
        
    }
    
    public void addVehicle(Vehicle v) {
        this.vehicles.add(v);
    }
    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
