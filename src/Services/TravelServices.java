/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Customer;
import Entities.RouteTicket;
import Entities.Ticket;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    CustomerServices cs;

    public TravelServices() {
        cs = new CustomerServices();
    }

    public ArrayList<RouteTicket> queryRoute(String company, String date, String from, String to) {

        RouteTicket rt = new RouteTicket();
        if (company.equals("TCDD")) {
            MockTCDDApi api = new MockTCDDApi();
            return api.getRoutes(from, to, date);
        } else if(company.equals("Ucan Turk")) {
            MockUcanTurkApi api = new MockUcanTurkApi();
            return api.getRoutes(from, to, date);
        } else if (company.equals("YTUR")) {
            MockYTURApi api = new MockYTURApi();
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
    public Ticket sellTicket(RouteTicket r, Customer c, String paymentType) throws SQLException {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Ticket t = new Ticket();
        t.setBonusPointEarned(r.getPrice() * r.getCompanyId().getPoint());
        t.setDate(Date.valueOf(LocalDate.now()));
        t.setPaymentAmount(r.getPrice());
        t.setPaymentType(paymentType);
        t.setUsedPoints(0.0);
        t.setCustomerId(c);
        em.getTransaction().begin();
        em.persist(t);
        Query query = em.createQuery(
                "UPDATE Customer c SET c.bonusPoint =:cpoint WHERE c.id =:cid");
        query.setParameter("cid", c.getId());
        query.setParameter("cpoint", c.getBonusPoint() + (r.getPrice() * r.getCompanyId().getPoint()));
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return t;
    }

    public Ticket sellTicket(RouteTicket r,
            Customer c,
            String paymentType,
            double points) throws SQLException {

        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Ticket t = new Ticket();
        t.setBonusPointEarned(r.getPrice() * r.getCompanyId().getPoint());
        t.setDate(Date.valueOf(LocalDate.now()));
        t.setPaymentAmount(r.getPrice());
        t.setPaymentType(paymentType);
        t.setUsedPoints(points);
        t.setCustomerId(c);
        em.getTransaction().begin();
        em.persist(t);
        Query query = em.createQuery(
                "UPDATE Customer c SET c.bonusPoint =:cpoint WHERE c.id =:cid");
        query.setParameter("cid", c.getId());
        query.setParameter("cpoint", c.getBonusPoint() - points);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return t;
    }

}
