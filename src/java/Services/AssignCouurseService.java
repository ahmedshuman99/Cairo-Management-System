/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Actions.Assigncourse;
import Entities.Courses.Course0000;
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
public class AssignCouurseService {

    //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    

    //MARK :: METHODS
    public List<Assigncourse> getAll() {
        try {
            String query = "select * from assigncourse";
            List<Assigncourse> list = em.createNativeQuery(query, Assigncourse.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    public void create(Assigncourse assigncourse) {
        try {
            em.getTransaction().begin();
            Course0000 courseId = assigncourse.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                assigncourse.setCourseId(courseId);
            }
            em.persist(assigncourse);
            if (courseId != null) {
                courseId.getAssigncourseCollection().add(assigncourse);
                courseId = em.merge(courseId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assigncourse> getStudentsByCourseId(int courseId) {
        return em.createQuery("SELECT ac FROM Assigncourse ac WHERE ac.courseId = :courseId", Assigncourse.class)
                .setParameter("courseId", courseId)
                .getResultList();
    }


}
