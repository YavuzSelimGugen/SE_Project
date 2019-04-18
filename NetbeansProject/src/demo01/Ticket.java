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
public class Ticket {
    double price;
    String date, takeoff, destination;
    boolean isPayed;
    Customer customer;
    Company company;

    Ticket(
            double price, 
            String date,
            String takeoff,
            String destination, 
            Company com, 
            Customer cus) {
        this.setPrice(price);
        this.setDate(date);
        this.setDestination(destination);
        this.setTakeoff(takeoff);
        this.setCustomer(cus);
        this.setCompany(com);
    }
    public void approvePayment() {
        
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }
}
