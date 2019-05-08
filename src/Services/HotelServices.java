/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Customer;
import Entities.Hotel;
import Entities.HotelCapacity;
import Entities.RouteTicket;
import Entities.Ticket;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author YavuzSelim
 */
public class HotelServices {
    EntityManagerFactory emf;
    EntityManager em;
    public void createHotel(String name, String location, double point) {
        Hotel h = new Hotel();
        h.setName(name);
        h.setLocation(location);
        h.setPoint(point);
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();
    }
    
    public Hotel getHotel(int id) {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Query q = em.createQuery("select c from Hotel c where c.id =:pid");
        q.setParameter("pid", id);
        Hotel hotel = (Hotel) q.getSingleResult();
        em.close();
        emf.close();
        return hotel;
    }
    public List<Hotel> getHotels(String location) {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Query q = em.createQuery("select c from Hotel c where c.location =:pid");
        q.setParameter("pid", location);
        List <Hotel> resultList = q.getResultList();
        em.close();
        emf.close();
        return resultList;
    }
    public void updateHotelPoint(int hotel_id, double point){
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Hotel h = em.find(Hotel.class, hotel_id);

        em.getTransaction().begin();
        h.setPoint(point);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
    public List<Hotel> getHotels() {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Query q = em.createQuery("select h from Hotel h");
        List<Hotel> hotels = q.getResultList();
        em.close();
        emf.close();
        return hotels;
    }
    public Ticket sellTicket(HotelCapacity hc, Customer c, String paymentType) throws SQLException {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Ticket t = new Ticket();
        t.setBonusPointEarned(hc.getPrice() * hc.getHotelId().getPoint());
        t.setDate(Date.valueOf(LocalDate.now()));
        t.setPaymentAmount(Double.valueOf(hc.getPrice().toString()));
        t.setPaymentType(paymentType);
        t.setUsedPoints(0.0);
        t.setCustomerId(c);
        em.getTransaction().begin();
        em.persist(t);
        Query query = em.createQuery(
                "UPDATE Customer c SET c.bonusPoint =:cpoint WHERE c.id =:cid");
        query.setParameter("cid", c.getId());
        query.setParameter("cpoint", c.getBonusPoint() + (hc.getPrice() * hc.getHotelId().getPoint()));
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return t;
    }
    public Ticket sellTicket(HotelCapacity hc,
            Customer c,
            String paymentType,
            double points) {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Ticket t = new Ticket();
        t.setBonusPointEarned(hc.getPrice() * hc.getHotelId().getPoint());
        t.setDate(Date.valueOf(LocalDate.now()));
        t.setPaymentAmount(Double.valueOf(hc.getPrice().toString()));
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
