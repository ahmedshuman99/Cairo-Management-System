 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ahmed
 */
@Stateless
public class Student0000Service {

    //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    
    //MARK :: METHODS
    public List<Student0000> getAll() {
        try {
            String query = "select * from student0000";
            List<Student0000> list = em.createNativeQuery(query, Student0000.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
    public void create(Student0000 student0000) {
        try {
            et.begin();
            em.persist(student0000);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
    public Student0000 FindByID(Student0000 student , int parseInt) {
        et.begin();      
        try {
           student = em.find(Student0000.class, parseInt);
            if (student != null) {              
            } else {
                System.out.println("Car not found with ID " + parseInt);
            }
            et.commit();
            return student;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public Student0000 findStudent0000(Integer id) {
        try {
            return em.find(Student0000.class, id);
        } finally {
            em.close();
        }
    }
      
    public void updateBalance(double newBalance, Student0000 student) {
    try {
        et.begin();
        student.setBalance(newBalance);
        em.merge(student);
        et.commit();
    } catch (Exception ex) {
        if (et != null && et.isActive()) {
            et.rollback();
        }
    }
}

    public void delete(Student0000 student) throws NonexistentEntityException {
        try {
            et.begin();   
            em.remove(student);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
    public void updateStudentActive(Student0000 student) {
        try {   
            et.begin();
            em.merge(student);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }
     
    public Student0000 getUserByEmailAndPassword(String email, String password) {
        try {
            String jpql = "SELECT s FROM Student0000 s WHERE s.email = :email AND s.password = :password";
            Query query = em.createQuery(jpql, Student0000.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return (Student0000) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // No user found with the provided email and password
        }
    }
}
