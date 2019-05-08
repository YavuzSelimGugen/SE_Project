/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.RouteTicket;
import Entities.Ticket;
import java.util.ArrayList;

/**
 *
 * @author YavuzSelim
 */
public interface TravelApi {
    public ArrayList<RouteTicket> getRoutes(String from, String to, String date);
    public Ticket bookRoute (RouteTicket r);
}
