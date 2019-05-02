/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author YavuzSelim
 */
public class CustomerServices {
    EntityManagerFactory emf;
    EntityManager em;

    public CustomerServices() {
        
    }
    
    public Customer getCustomer (int id) {
        emf=Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em=emf.createEntityManager();
        Query q = em.createQuery("select c from Customer c Where c.id =:cid");
        q.setParameter("cid", id);
        Customer singleResult = (Customer)q.getSingleResult();
        em.close();
        emf.close();
        return singleResult;
    }
    
    public List<Customer> getCustomers (String name) {
        emf=Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em=emf.createEntityManager();
        Query q = em.createQuery("select c from Customer c Where c.name =:cname");
        q.setParameter("cname", name);
        List<Customer> customers = q.getResultList();
        em.close();
        emf.close();
        return customers;
    }
    
    public void addCustomer (String name) {
        emf=Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em=emf.createEntityManager();
        Customer c1 = new Customer();
        c1.setName(name);
        c1.setBonusPoint(0.0);
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
