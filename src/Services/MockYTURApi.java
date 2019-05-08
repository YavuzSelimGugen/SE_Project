/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Company;
import Entities.RouteTicket;
import Entities.Ticket;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author YavuzSelim
 */
public class MockYTURApi implements TravelApi{

    @Override
    public ArrayList<RouteTicket> getRoutes(String from, String to, String date) {
        ArrayList<RouteTicket> routes = new ArrayList<>();
        CompanyServices ts = new CompanyServices();
        Company c = ts.getCompany(2);
        if (to.equals("Bursa") || to.equals("Trabzon") || to.equals("Izmir")
                || to.equals("Ankara") || to.equals("Istanbul")) {
            RouteTicket temp = new RouteTicket();
            temp.setTo(to);
            temp.setFrom(from);
            temp.setTravelDate(Date.valueOf(date));
            temp.setPrice(150.0);
            temp.setCompanyId(c);
            
            routes.add(temp);
            RouteTicket temp2 = new RouteTicket();
            temp2.setTo(to);
            temp2.setFrom(from);
            temp2.setTravelDate(Date.valueOf(date));
            temp2.setPrice(200.0);
            temp2.setCompanyId(c);
            routes.add(temp2);
        }
        return routes;
    }

    @Override
    public Ticket bookRoute(RouteTicket r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
