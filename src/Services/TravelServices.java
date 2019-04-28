/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.RouteTicket;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author YavuzSelim
 */
public class TravelServices {
    EntityManagerFactory emf;
    EntityManager em;

    public TravelServices() {
        emf=Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em=emf.createEntityManager();
    }
//    public ArrayList<RouteTicket> queryRoute(String company, String date, String from, String to) {
//        
//    }
}
