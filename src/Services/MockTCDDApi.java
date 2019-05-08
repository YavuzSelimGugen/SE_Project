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
public class MockTCDDApi {
    public Ticket bookRoute(RouteTicket r) {
        // TCDD ile konusarak bilet kesilir.
        // Random urettir.
//        Ticket t = new Ticket();
//        r.get
//        t.set
        return new Ticket();
    }
    
    public ArrayList<RouteTicket> getRoutes(String from, String to, String date) {
        ArrayList<RouteTicket> routes = new ArrayList<>();
        CompanyServices ts = new CompanyServices();
        Company c = ts.getCompany(1);
        if (to.equals("Istanbul") || to.equals("Ankara") || to.equals("Izmir")) {
            RouteTicket temp = new RouteTicket();
            temp.setTo(to);
            temp.setFrom(from);
            temp.setTravelDate(Date.valueOf(date));
            temp.setPrice(100.0);
            temp.setCompanyId(c);
            
            routes.add(temp);
            RouteTicket temp2 = new RouteTicket();
            temp2.setTo(to);
            temp2.setFrom(from);
            temp2.setTravelDate(Date.valueOf(date));
            temp2.setPrice(125.0);
            temp2.setCompanyId(c);
            routes.add(temp2);
        }
        return routes;
    }
}
