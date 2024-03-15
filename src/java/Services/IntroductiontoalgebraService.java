/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontoalgebra;
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
public class IntroductiontoalgebraService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
       public List<Introductiontoalgebra> getAll() {
        try {
            String query = "select * from introductionToAlgebra";
            List<Introductiontoalgebra> list = em.createNativeQuery(query, Introductiontoalgebra.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        }
       
       
       
    public void create(Introductiontoalgebra introductiontoalgebra) {
        try {
            em.getTransaction().begin();
            Course0000 courseId = introductiontoalgebra.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                introductiontoalgebra.setCourseId(courseId);
            }
            Student0000 studentId = introductiontoalgebra.getStudentId();
            if (studentId != null) {
                studentId = em.getReference(studentId.getClass(), studentId.getId());
                introductiontoalgebra.setStudentId(studentId);
            }
            em.persist(introductiontoalgebra);
            if (courseId != null) {
                courseId.getIntroductiontoalgebraList().add(introductiontoalgebra);
                courseId = em.merge(courseId);
            }
            if (studentId != null) {
                studentId.getIntroductiontoalgebraList().add(introductiontoalgebra);
                studentId = em.merge(studentId);
            }
            em.persist(introductiontoalgebra);
            em.getTransaction().commit();
        } finally {
            if (em != null) 
                
                em.close();
            }
        }
    }
       
    

