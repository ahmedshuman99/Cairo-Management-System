/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontoai;
import Entities.Courses.Introductiontonetwork;
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
public class IntroductionToNetworkService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
       public List<Introductiontonetwork> getAll() {
        try {
            String query = "select * from introductiontonetwork";
            List<Introductiontonetwork> list = em.createNativeQuery(query, Introductiontonetwork.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        }
       
       
       public void create(Introductiontonetwork introductiontonetwork) {
        try {
            em.getTransaction().begin();
            Course0000 courseId = introductiontonetwork.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                introductiontonetwork.setCourseId(courseId);
            }
            Student0000 studentId = introductiontonetwork.getStudentId();
            if (studentId != null) {
                studentId = em.getReference(studentId.getClass(), studentId.getId());
                introductiontonetwork.setStudentId(studentId);
            }
            em.persist(introductiontonetwork);
            if (courseId != null) {
                courseId.getIntroductiontonetworkList().add(introductiontonetwork);
                courseId = em.merge(courseId);
            }
            if (studentId != null) {
                studentId.getIntroductiontonetworkList().add(introductiontonetwork);
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
