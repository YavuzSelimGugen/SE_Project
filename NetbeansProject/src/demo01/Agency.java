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
public class Agency {
    String name;
    ArrayList<Company> companies;
    ArrayList<Hostel> hotels;
    
    public Ticket findTicket(
            Customer cus, 
            Company c, 
            String date, 
            String takeoff, 
            String destination) {
        double price = c.findTravel(date, takeoff, destination);
        if(price != -1) {
            return new Ticket(price, date, takeoff, destination, c, cus);
        }
        else return null;
    }
    public void takePayment(Customer c){
        
    }
    public void addCompany(Company c) {
        this.companies.add(c);
    }
    public void addHostel(Hostel h) {
        this.hotels.add(h);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
