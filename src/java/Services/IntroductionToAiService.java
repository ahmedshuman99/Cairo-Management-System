/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontoai;
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
public class IntroductionToAiService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
       public List<Introductiontoai> getAll() {
        try {
            String query = "select * from introductiontoai";
            List<Introductiontoai> list = em.createNativeQuery(query, Introductiontoai.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        }
       
       
       
    public void create(Introductiontoai introductiontoai) {
        try {
            em.getTransaction().begin();
            Course0000 courseId = introductiontoai.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                introductiontoai.setCourseId(courseId);
            }
            Student0000 studentId = introductiontoai.getStudentId();
            if (studentId != null) {
                studentId = em.getReference(studentId.getClass(), studentId.getId());
                introductiontoai.setStudentId(studentId);
            }
            em.persist(introductiontoai);
            if (courseId != null) {
                courseId.getIntroductiontoaiList().add(introductiontoai);
                courseId = em.merge(courseId);
            }
            if (studentId != null) {
                studentId.getIntroductiontoaiList().add(introductiontoai);
                studentId = em.merge(studentId);
            }
            em.persist(introductiontoai);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


}
