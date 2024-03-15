/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Identity.Doctor0000;
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
import javax.persistence.TypedQuery;

/**
 *
 * @author ahmed
 */
@Stateless
public class Doctor0000Service {

    //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    
    //MARK :: METHODS
    public List<Doctor0000> getAll() {
        try {
            String query = "select * from doctor0000";
            List<Doctor0000> list = em.createNativeQuery(query, Doctor0000.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    public void create(Doctor0000 doctor) {
        try {
            et.begin();
            em.persist(doctor);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void updateCourse(Doctor0000 doctor) {
        try {
            et.begin();
            em.merge(doctor);

            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }
    
    public void delete(Doctor0000 doctor) throws NonexistentEntityException {
        try {
            et.begin();   
            em.remove(doctor);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Doctor0000 FindByID(Doctor0000 doctor, int parseInt) {
        et.begin();
        try {
            doctor = em.find(Doctor0000.class, parseInt);
            if (doctor != null) {

            } else {
                System.out.println("Car not found with ID " + parseInt);
            }
            et.commit();
            return doctor;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public List<Student0000> getStudentsForCourse(int courseId) {
        TypedQuery<Student0000> query = em.createQuery(
                "SELECT s FROM Assigncourse ac "
                + "JOIN Student0000 s ON ac.studentId = s.id "
                + "JOIN Course0000 c ON ac.courseId = c.courseId "
                + "WHERE c.courseId = :courseId", Student0000.class);

        query.setParameter("courseId", courseId);
        return query.getResultList();
    }
   
    public Doctor0000 getUserByEmailAndPassword(String email, String password) {
        try {
            String jpql = "SELECT s FROM Doctor0000 s WHERE s.doctorEmail = :email AND s.doctorPassword = :password";
            Query query = em.createQuery(jpql, Doctor0000.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return (Doctor0000) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // No user found with the provided email and password
        }
    }
         
   
}

