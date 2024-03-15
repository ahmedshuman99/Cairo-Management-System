/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import Entities.Identity.Doctor0000;
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
public class Assignedcoursestoteachers0000Service {

    //MARK :: ATTRIBUTES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CAIRO_UNIVERSITYPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    
    //MARK :: METHODS
    public List<Assignedcoursestoteachers0000> getAll() {
        try {
            String query = "select * from assignedcoursestoteachers0000";
            List<Assignedcoursestoteachers0000> list = em.createNativeQuery(query, Assignedcoursestoteachers0000.class).getResultList();
            return list;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
    public void create(Assignedcoursestoteachers0000 assignedcoursestoteachers0000) {      
        try {
            em.getTransaction().begin();
            Doctor0000 doctorId = assignedcoursestoteachers0000.getDoctorId();
            if (doctorId != null) {
                doctorId = em.getReference(doctorId.getClass(), doctorId.getDoctorId());
                assignedcoursestoteachers0000.setDoctorId(doctorId);
            }
            em.persist(assignedcoursestoteachers0000);
            if (doctorId != null) {
                doctorId.getAssignedcoursestoteachers0000List().add(assignedcoursestoteachers0000);
                doctorId = em.merge(doctorId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
    public Assignedcoursestoteachers0000 findAssignedcoursestoteachers0000(Integer id) {
        try {
            return em.find(Assignedcoursestoteachers0000.class, id);
        } finally {
            em.close();
        }
    }
}
