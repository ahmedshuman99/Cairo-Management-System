/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Courses.Course0000;
import Entities.Courses.Introductiontosoftwareenginnering;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class IntroductiontosoftwareenginneringJpaController implements Serializable {

    public IntroductiontosoftwareenginneringJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Introductiontosoftwareenginnering introductiontosoftwareenginnering) {
        EntityManager em = null;
        try {
            em = getEntityManager();
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

    public void edit(Introductiontosoftwareenginnering introductiontosoftwareenginnering) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Introductiontosoftwareenginnering persistentIntroductiontosoftwareenginnering = em.find(Introductiontosoftwareenginnering.class, introductiontosoftwareenginnering.getId());
            Course0000 courseIdOld = persistentIntroductiontosoftwareenginnering.getCourseId();
            Course0000 courseIdNew = introductiontosoftwareenginnering.getCourseId();
            Student0000 studentIdOld = persistentIntroductiontosoftwareenginnering.getStudentId();
            Student0000 studentIdNew = introductiontosoftwareenginnering.getStudentId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                introductiontosoftwareenginnering.setCourseId(courseIdNew);
            }
            if (studentIdNew != null) {
                studentIdNew = em.getReference(studentIdNew.getClass(), studentIdNew.getId());
                introductiontosoftwareenginnering.setStudentId(studentIdNew);
            }
            introductiontosoftwareenginnering = em.merge(introductiontosoftwareenginnering);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginnering);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getIntroductiontosoftwareenginneringList().add(introductiontosoftwareenginnering);
                courseIdNew = em.merge(courseIdNew);
            }
            if (studentIdOld != null && !studentIdOld.equals(studentIdNew)) {
                studentIdOld.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginnering);
                studentIdOld = em.merge(studentIdOld);
            }
            if (studentIdNew != null && !studentIdNew.equals(studentIdOld)) {
                studentIdNew.getIntroductiontosoftwareenginneringList().add(introductiontosoftwareenginnering);
                studentIdNew = em.merge(studentIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = introductiontosoftwareenginnering.getId();
                if (findIntroductiontosoftwareenginnering(id) == null) {
                    throw new NonexistentEntityException("The introductiontosoftwareenginnering with id " + id + " no longer exists.");
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
            Introductiontosoftwareenginnering introductiontosoftwareenginnering;
            try {
                introductiontosoftwareenginnering = em.getReference(Introductiontosoftwareenginnering.class, id);
                introductiontosoftwareenginnering.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The introductiontosoftwareenginnering with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = introductiontosoftwareenginnering.getCourseId();
            if (courseId != null) {
                courseId.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginnering);
                courseId = em.merge(courseId);
            }
            Student0000 studentId = introductiontosoftwareenginnering.getStudentId();
            if (studentId != null) {
                studentId.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginnering);
                studentId = em.merge(studentId);
            }
            em.remove(introductiontosoftwareenginnering);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Introductiontosoftwareenginnering> findIntroductiontosoftwareenginneringEntities() {
        return findIntroductiontosoftwareenginneringEntities(true, -1, -1);
    }

    public List<Introductiontosoftwareenginnering> findIntroductiontosoftwareenginneringEntities(int maxResults, int firstResult) {
        return findIntroductiontosoftwareenginneringEntities(false, maxResults, firstResult);
    }

    private List<Introductiontosoftwareenginnering> findIntroductiontosoftwareenginneringEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Introductiontosoftwareenginnering.class));
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

    public Introductiontosoftwareenginnering findIntroductiontosoftwareenginnering(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Introductiontosoftwareenginnering.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntroductiontosoftwareenginneringCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Introductiontosoftwareenginnering> rt = cq.from(Introductiontosoftwareenginnering.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
