/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Identity.Admin0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ahmed
 */
@Stateless
public class Admin0000Service {

    //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    
    
    //MARK :: METHODS
    public List<Admin0000> getAll() {
        try {
            String query = "select * from admin0000";
            List<Admin0000> list = em.createNativeQuery(query, Admin0000.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
    public void create(Admin0000 admin0000) {
        try {
            et.begin();
            em.persist(admin0000);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Admin0000 authenticate(String email, String password) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return null; // Empty email or password, cannot authenticate
        }
        try {
            TypedQuery<Admin0000> query = em.createQuery("SELECT a FROM Admin0000 a WHERE a.email = :email AND a.password = :password", Admin0000.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Admin0000> resultList = query.getResultList();

            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }
        } catch (PersistenceException e) {
        }

        return null; // If no matching user found or an error occurred, return null
    }

    public void updateCourse(Admin0000 admin) {

        try {

            et.begin();

            // Merge the updated course entity into the persistence context
            em.merge(admin);

            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            // Handle exception appropriately, e.g., log or throw
        }
    }

    public void delete(Admin0000 admin) throws NonexistentEntityException {
        try {
            et.begin();
            em.remove(admin);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Admin0000 getUserByEmailAndPassword(String email, String password) {
        try {
            String jpql = "SELECT s FROM Admin0000 s WHERE s.email = :email AND s.password = :password";
            Query query = em.createQuery(jpql, Admin0000.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return (Admin0000) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // No user found with the provided email and password
        }
    }
}
