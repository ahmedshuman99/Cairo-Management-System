/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontosoftwareenginnering;
import Entities.Identity.Student0000;
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
public class IntroductiontosoftwareenginneringService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
       public List<Introductiontosoftwareenginnering> getAll() {
        try {
            String query = "select * from introductiontosoftwareenginnering";
            List<Introductiontosoftwareenginnering> list = em.createNativeQuery(query, Introductiontosoftwareenginnering.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        }
       
       
       public void create(Introductiontosoftwareenginnering introductiontosoftwareenginnering) {
        try {
            em.getTransaction().begin();
            Course0000 courseId = introductiontosoftwareenginnering.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                introductiontosoftwareenginnering.setCourseId(courseId);
            }
            Student0000 studentId = introductiontosoftwareenginnering.getStudentId();
            if (studentId != null) {
                studentId = em.getReference(studentId.getClass(), studentId.getId());
                introductiontosoftwareenginnering.setStudentId(studentId);
            }
            em.persist(introductiontosoftwareenginnering);
            if (courseId != null) {
                courseId.getIntroductiontosoftwareenginneringList().add(introductiontosoftwareenginnering);
                courseId = em.merge(courseId);
            }
            if (studentId != null) {
                studentId.getIntroductiontosoftwareenginneringList().add(introductiontosoftwareenginnering);
                studentId = em.merge(studentId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
       
       
}
