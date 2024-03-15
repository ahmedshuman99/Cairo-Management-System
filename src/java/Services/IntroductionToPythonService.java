/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontopython;
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
public class IntroductionToPythonService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
       public List<Introductiontopython> getAll() {
        try {
            String query = "select * from introductiontopython";
            List<Introductiontopython> list = em.createNativeQuery(query, Introductiontopython.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        }
       
       public void create(Introductiontopython introductiontopython) {
        try {
            em.getTransaction().begin();
            Course0000 courseId = introductiontopython.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                introductiontopython.setCourseId(courseId);
            }
            Student0000 studentId = introductiontopython.getStudentId();
            if (studentId != null) {
                studentId = em.getReference(studentId.getClass(), studentId.getId());
                introductiontopython.setStudentId(studentId);
            }
            em.persist(introductiontopython);
            if (courseId != null) {
                courseId.getIntroductiontopythonList().add(introductiontopython);
                courseId = em.merge(courseId);
            }
            if (studentId != null) {
                studentId.getIntroductiontopythonList().add(introductiontopython);
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
