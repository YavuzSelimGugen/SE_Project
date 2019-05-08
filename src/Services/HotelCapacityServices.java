/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Hotel;
import Entities.HotelCapacity;
import java.sql.Date;
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
public class HotelCapacityServices {
    EntityManagerFactory emf;
    EntityManager em;
    HotelServices hs;
    public HotelCapacityServices() {
        hs = new HotelServices();
    }
    public void addHotelCapacity(Hotel hotel, int daily_cap, int price) {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        HotelCapacity hp = new HotelCapacity();
        hp.setDailyCapacity(daily_cap);
        hp.setHotelId(hotel);
        hp.setPrice(price);
        em.getTransaction().begin();
        em.persist(hp);
        em.getTransaction().commit();
        
    }
    public List<HotelCapacity> querryRoom (Date date, String location) {
        List<Hotel> hotels = hs.getHotels(location);
        for (Hotel hotel : hotels) {
            
        }
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
        Query q = em.createQuery(
                "SELECT HC FROM HotelCapacity HC WHERE HC.hotelId IN (SELECT h FROM Hotel h where h.location=:ploc)");
        q.setParameter("ploc", location);
        List<HotelCapacity> resultList = q.getResultList();
        return resultList;
    }
}
