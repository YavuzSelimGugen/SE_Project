/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.HotelTicket;
import Entities.RouteTicket;
import Entities.Ticket;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author YavuzSelim
 */
public interface HotelApi {
    public ArrayList<HotelTicket> getRoom(String location, Date date);
    public Ticket bookRoute (HotelTicket ticket);
}
