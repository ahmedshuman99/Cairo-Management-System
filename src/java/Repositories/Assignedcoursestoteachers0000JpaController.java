/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Courses.Course0000;
import Entities.Identity.Doctor0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class Assignedcoursestoteachers0000JpaController implements Serializable {

    public Assignedcoursestoteachers0000JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Assignedcoursestoteachers0000 assignedcoursestoteachers0000) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course0000 courseId = assignedcoursestoteachers0000.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                assignedcoursestoteachers0000.setCourseId(courseId);
            }
            Doctor0000 doctorId = assignedcoursestoteachers0000.getDoctorId();
            if (doctorId != null) {
                doctorId = em.getReference(doctorId.getClass(), doctorId.getDoctorId());
                assignedcoursestoteachers0000.setDoctorId(doctorId);
            }
            em.persist(assignedcoursestoteachers0000);
            if (courseId != null) {
                courseId.getAssignedcoursestoteachers0000List().add(assignedcoursestoteachers0000);
                courseId = em.merge(courseId);
            }
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

    public void edit(Assignedcoursestoteachers0000 assignedcoursestoteachers0000) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assignedcoursestoteachers0000 persistentAssignedcoursestoteachers0000 = em.find(Assignedcoursestoteachers0000.class, assignedcoursestoteachers0000.getCourseassignedId());
            Course0000 courseIdOld = persistentAssignedcoursestoteachers0000.getCourseId();
            Course0000 courseIdNew = assignedcoursestoteachers0000.getCourseId();
            Doctor0000 doctorIdOld = persistentAssignedcoursestoteachers0000.getDoctorId();
            Doctor0000 doctorIdNew = assignedcoursestoteachers0000.getDoctorId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                assignedcoursestoteachers0000.setCourseId(courseIdNew);
            }
            if (doctorIdNew != null) {
                doctorIdNew = em.getReference(doctorIdNew.getClass(), doctorIdNew.getDoctorId());
                assignedcoursestoteachers0000.setDoctorId(doctorIdNew);
            }
            assignedcoursestoteachers0000 = em.merge(assignedcoursestoteachers0000);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getAssignedcoursestoteachers0000List().add(assignedcoursestoteachers0000);
                courseIdNew = em.merge(courseIdNew);
            }
            if (doctorIdOld != null && !doctorIdOld.equals(doctorIdNew)) {
                doctorIdOld.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000);
                doctorIdOld = em.merge(doctorIdOld);
            }
            if (doctorIdNew != null && !doctorIdNew.equals(doctorIdOld)) {
                doctorIdNew.getAssignedcoursestoteachers0000List().add(assignedcoursestoteachers0000);
                doctorIdNew = em.merge(doctorIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = assignedcoursestoteachers0000.getCourseassignedId();
                if (findAssignedcoursestoteachers0000(id) == null) {
                    throw new NonexistentEntityException("The assignedcoursestoteachers0000 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assignedcoursestoteachers0000 assignedcoursestoteachers0000;
            try {
                assignedcoursestoteachers0000 = em.getReference(Assignedcoursestoteachers0000.class, id);
                assignedcoursestoteachers0000.getCourseassignedId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The assignedcoursestoteachers0000 with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = assignedcoursestoteachers0000.getCourseId();
            if (courseId != null) {
                courseId.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000);
                courseId = em.merge(courseId);
            }
            Doctor0000 doctorId = assignedcoursestoteachers0000.getDoctorId();
            if (doctorId != null) {
                doctorId.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000);
                doctorId = em.merge(doctorId);
            }
            em.remove(assignedcoursestoteachers0000);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assignedcoursestoteachers0000> findAssignedcoursestoteachers0000Entities() {
        return findAssignedcoursestoteachers0000Entities(true, -1, -1);
    }

    public List<Assignedcoursestoteachers0000> findAssignedcoursestoteachers0000Entities(int maxResults, int firstResult) {
        return findAssignedcoursestoteachers0000Entities(false, maxResults, firstResult);
    }

    private List<Assignedcoursestoteachers0000> findAssignedcoursestoteachers0000Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Assignedcoursestoteachers0000.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Assignedcoursestoteachers0000 findAssignedcoursestoteachers0000(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Assignedcoursestoteachers0000.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssignedcoursestoteachers0000Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Assignedcoursestoteachers0000> rt = cq.from(Assignedcoursestoteachers0000.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
