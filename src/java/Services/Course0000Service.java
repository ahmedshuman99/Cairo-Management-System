/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontoai;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
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
public class Course0000Service {

    //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    
    //MARK :: METHODS
    public List<Course0000> getAll() {
        try {
            String query = "select * from course0000";
            List<Course0000> list = em.createNativeQuery(query, Course0000.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    public void create(Course0000 course) {
        try {
            et.begin();
            em.persist(course);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
   
    public Course0000 FindByID(Course0000 course , int parseInt) {
        et.begin();       
        try {
           course = em.find(Course0000.class, parseInt);
            if (course != null) {          
            } else {
                System.out.println("Car not found with ID " + parseInt);
            }
            et.commit();
            return course;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
    public Course0000 findCourse0000(Integer id) {
        try {
            return em.find(Course0000.class, id);
        } finally {
            em.close();
        }
    }
   
    public void AssignCourse(Introductiontoai introductiontoai) {
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

    public void updateCourse(Course0000 course) {
        try {      
            et.begin();
            em.merge(course);          
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }
   
    public void delete(Course0000 course) throws NonexistentEntityException {
        try {
            et.begin();   
            em.remove(course);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
