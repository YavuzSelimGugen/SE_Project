/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author YavuzSelim
 */
public class CompanyServices {

    EntityManagerFactory emf;
    EntityManager em;

    public CompanyServices() {
        emf = Persistence.createEntityManagerFactory("CelebiAgencyPU");
        em = emf.createEntityManager();
    }

    public void createCompany(String name, double point) {
        Company c1 = new Company();
        c1.setName(name);
        c1.setPoint(point);
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }

    public List<Company> getCompanies() {
        Query q = em.createQuery("select c from Company c");
        List<Company> companies = q.getResultList();
        em.close();
        emf.close();
        return companies;
    }

    public Company getCompany(int company_id) {
        Query q = em.createQuery("select c from Company c where c.id =:pid");
        q.setParameter("pid", company_id);
        Company company = (Company) q.getSingleResult();
        em.close();
        emf.close();
        return company;
    }

    public void updateCompanyPoint(int company_id, double point) {
//        Query qUpdate = em.createQuery("update Personel p set p.adi='Mehmet' where p.personelId=16");
//        qUpdate.executeUpdate();
//        em.flush();
        
        Company c = em.find(Company.class, company_id);

        em.getTransaction().begin();
        c.setPoint(point);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void deleteCompany(int company_id) {
        Query q=em.createQuery("delete from Company c where c.id=:pId");
        q.setParameter("pId", company_id);
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
