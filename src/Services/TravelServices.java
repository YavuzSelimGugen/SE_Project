/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Company;
import Entities.Customer;
import Entities.RouteTicket;
import Entities.Ticket;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author YavuzSelim
 */
public class TravelServices {
    EntityManagerFactory emf;
    EntityManager em;

    public TravelServices() {
        
    }
    public ArrayList<RouteTicket> queryRoute(String company, String date, String from, String to){
        
        RouteTicket rt = new RouteTicket();
        if(company.equals("TCDD")) {
            MockTCDDApi api = new MockTCDDApi();
            return api.getRoutes(from, to, date);
        }
        return null;
    }
    public RouteTicket getRoute(int id) {
        Query q = em.createQuery("select c from RouteTicket c where c.id =:pid");
        q.setParameter("pid", id);
        RouteTicket route = (RouteTicket) q.getSingleResult();
        em.close();
        emf.close();
        return route;
    }
    //If customer accept offer, agency sell ticket and give info to company
    public Ticket sellTicket(RouteTicket r, Customer c, String paymentType) {
        emf=Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em=emf.createEntityManager();
        
        em.getTransaction().begin();
        Ticket t = new Ticket();
        t.setBonusPointEarned(r.getPrice() * r.getCompanyId().getPoint());
        t.setDate(Date.valueOf(LocalDate.MIN));
        t.setPaymentAmount(r.getPrice());
        t.setPaymentType(paymentType);
        t.setUsedPoints(0.0);
        t.setCustomerId(c);
        em.persist(t);
        em.getTransaction().commit();
        
        Customer temp_customer = em.find(Customer.class, c);

        em.getTransaction().begin();
        temp_customer.setBonusPoint(temp_customer.getBonusPoint() 
                + r.getPrice() * r.getCompanyId().getPoint());
        em.getTransaction().commit();
        em.close();
        emf.close();
        return t;
    }
    public Ticket sellTicket(RouteTicket r, 
            Customer c, 
            String paymentType, 
            double points) {
        emf=Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em=emf.createEntityManager();
        Ticket t = new Ticket();
        t.setBonusPointEarned(r.getCompanyId().getPoint() * r.getPrice());
        t.setCustomerId(c);
        t.setDate(Date.valueOf(LocalDate.MIN));
        t.setPaymentAmount(r.getPrice());
        t.setPaymentType(paymentType);
        t.setUsedPoints(c.getBonusPoint());
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return t;
    }
    
    
}
