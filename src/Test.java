
import Entities.Company;
import Entities.Customer;
import Entities.Ticket;
import Services.CompanyServices;
import Services.CustomerServices;
import Services.TravelServices;
import java.sql.Date;
import java.time.LocalDate;
import java.util.AbstractCollection;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

                CustomerServices cs = new CustomerServices();
                Customer c = cs.getCustomer(1);
        EntityManagerFactory emf;
    EntityManager em;        
        emf=Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
        Ticket t = new Ticket();
        t.setBonusPointEarned(1.0);
        t.setCustomerId(c);
        t.setDate(Date.valueOf(LocalDate.MIN));
        t.setPaymentAmount(125.0);
        t.setPaymentType("Kredi Karti");
        t.setUsedPoints(0.0);
        
        em.persist(t);
        em.getTransaction().commit();        
    }
}
