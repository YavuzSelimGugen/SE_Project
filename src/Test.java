
import Entities.Company;
import Entities.Customer;
import Entities.Hotel;
import Entities.HotelCapacity;
import Entities.Ticket;
import Services.CompanyServices;
import Services.CustomerServices;
import Services.HotelCapacityServices;
import Services.HotelServices;
import Services.TravelServices;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.AbstractCollection;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YavuzSelim
 */
public class Test {

    public static void main(String[] args) {
        
//        System.out.println(Date.valueOf(LocalDate.now()));
//        TestServices testservices = new TestServices();
//        Random rand = new Random();
        //year-month-day
//        String date = "1997-03-10";
//        Date.valueOf(date);
        //        int n = rand.nextInt(50);
        //        System.out.println(n);
        //        testservices.createCompany("TCDD", 1);
        //        testservices.updateCompanyPoint(1, 0.86);
        //        Company gcompany = testservices.getCompany(1);
        //        System.out.println(gcompany.getName() + " - " + gcompany.getPoint());
        //        testservices.deleteCompany(1);
//        CustomerServices cs = new CustomerServices();
//        Customer c = cs.getCustomer(1);
//        EntityManagerFactory emf;
//        EntityManager em;
//        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Query query = em.createQuery(
//      "UPDATE Customer c SET c.bonusPoint =:cpoint WHERE c.id =:cid");
//       query.setParameter("cid", c.getId());
//       double p =c.getBonusPoint() + (125 * 0.01);
//        System.out.println(p+" :::");
//       query.setParameter("cpoint",  p);
//       query.executeUpdate();
//       em.getTransaction().commit(); 
       
//        em.getTransaction().begin();
//        Ticket t = new Ticket();
//        t.setBonusPointEarned(1.0);
//        t.setCustomerId(c);
//        t.setDate(Date.valueOf(LocalDate.now()));
//        t.setPaymentAmount(125.0);
//        t.setPaymentType("Kredi Karti");
//        t.setUsedPoints(0.0);
//
//        em.persist(t);
//        em.getTransaction().commit();

//try {
//            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/celebi_seyahat", "celebi", "celebi");
//            Statement st=con.createStatement();
//            //String sql="INSERT INTO malzeme (malzeme_id,adi) VALUES (5,'KAğıt')";
//            String pMalzemeAdi="Bant";
//            String pTuru="Kırtasiye";
//            String sql="INSERT INTO TICKET (payment_type,payment_amount,used_points,customer_id) "
//                    + "VALUES ('kredi',7,12,1)";
//            System.out.println(sql);
//            st.executeUpdate(sql);
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }


        HotelServices hs = new HotelServices();
        Hotel h1 = hs.getHotel(1);
        Hotel h2 = hs.getHotel(2);
        
        HotelCapacityServices hcs = new HotelCapacityServices();
//        hcs.addHotelCapacity(h2, 15, 100);
//        hcs.addHotelCapacity(h2, 20, 110);
//        hcs.addHotelCapacity(h2, 30, 120);
//        hcs.addHotelCapacity(h1, 10, 100);
//        hcs.addHotelCapacity(h1, 15, 120);
//        hcs.addHotelCapacity(h1, 15, 160);
        List<HotelCapacity> querryRoom = hcs.querryRoom(new Date(0), "Istanbul");
    }
}
