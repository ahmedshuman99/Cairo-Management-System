/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ahmed
 */
@Stateless
public class Marksofintroductiontoaicourse9999Service {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
     public List<Marksofintroductiontoaicourse9999> getAll() {
        try {
            String query = "select * from marksofintroductiontoaicourse9999";
            List<Marksofintroductiontoaicourse9999> list = em.createNativeQuery(query, Marksofintroductiontoaicourse9999.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        }
     
          public void create(Marksofintroductiontoaicourse9999 mark) {
        try {
            et.begin();
            em.persist(mark);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
      }
      public Marksofintroductiontoaicourse9999 findMarksofintroductiontoaicourse9999(Integer id) {
        try {
            return em.find(Marksofintroductiontoaicourse9999.class, id);
        } finally {
            em.close();
        }
    }

       public List<Object[]> getCoursesByDoctorId(int doctorId) {
        try {
            String query = "SELECT c.courseId, c.courseName " +
                           "FROM assignedcoursestoteachers0000 a " +
                           "JOIN course0000 c ON a.courseId = c.courseId " +
                           "WHERE a.doctorId = :doctorId";
            List<Object[]> resultList = em.createNativeQuery(query)
                                           .setParameter("doctorId", doctorId)
                                           .getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
            return Collections.emptyList();
        }
    }

}
