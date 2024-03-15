/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Entities.Courses.Actions.Assigncourse;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Courses.Course0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class AssigncourseJpaController implements Serializable {

    public AssigncourseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Assigncourse assigncourse) {
        EntityManager em = null;
        try {
            em = getEntityManager();
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

    public void edit(Assigncourse assigncourse) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assigncourse persistentAssigncourse = em.find(Assigncourse.class, assigncourse.getId());
            Course0000 courseIdOld = persistentAssigncourse.getCourseId();
            Course0000 courseIdNew = assigncourse.getCourseId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                assigncourse.setCourseId(courseIdNew);
            }
            assigncourse = em.merge(assigncourse);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getAssigncourseCollection().remove(assigncourse);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getAssigncourseCollection().add(assigncourse);
                courseIdNew = em.merge(courseIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = assigncourse.getId();
                if (findAssigncourse(id) == null) {
                    throw new NonexistentEntityException("The assigncourse with id " + id + " no longer exists.");
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
            Assigncourse assigncourse;
            try {
                assigncourse = em.getReference(Assigncourse.class, id);
                assigncourse.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The assigncourse with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = assigncourse.getCourseId();
            if (courseId != null) {
                courseId.getAssigncourseCollection().remove(assigncourse);
                courseId = em.merge(courseId);
            }
            em.remove(assigncourse);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assigncourse> findAssigncourseEntities() {
        return findAssigncourseEntities(true, -1, -1);
    }

    public List<Assigncourse> findAssigncourseEntities(int maxResults, int firstResult) {
        return findAssigncourseEntities(false, maxResults, firstResult);
    }

    private List<Assigncourse> findAssigncourseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Assigncourse.class));
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

    public Assigncourse findAssigncourse(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Assigncourse.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssigncourseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Assigncourse> rt = cq.from(Assigncourse.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
