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
import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class Marksofintroductiontoaicourse9999JpaController implements Serializable {

    public Marksofintroductiontoaicourse9999JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course0000 courseId = marksofintroductiontoaicourse9999.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                marksofintroductiontoaicourse9999.setCourseId(courseId);
            }
            Student0000 studentId = marksofintroductiontoaicourse9999.getStudentId();
            if (studentId != null) {
                studentId = em.getReference(studentId.getClass(), studentId.getId());
                marksofintroductiontoaicourse9999.setStudentId(studentId);
            }
            em.persist(marksofintroductiontoaicourse9999);
            if (courseId != null) {
                courseId.getMarksofintroductiontoaicourse9999List().add(marksofintroductiontoaicourse9999);
                courseId = em.merge(courseId);
            }
            if (studentId != null) {
                studentId.getMarksofintroductiontoaicourse9999List().add(marksofintroductiontoaicourse9999);
                studentId = em.merge(studentId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Marksofintroductiontoaicourse9999 persistentMarksofintroductiontoaicourse9999 = em.find(Marksofintroductiontoaicourse9999.class, marksofintroductiontoaicourse9999.getId());
            Course0000 courseIdOld = persistentMarksofintroductiontoaicourse9999.getCourseId();
            Course0000 courseIdNew = marksofintroductiontoaicourse9999.getCourseId();
            Student0000 studentIdOld = persistentMarksofintroductiontoaicourse9999.getStudentId();
            Student0000 studentIdNew = marksofintroductiontoaicourse9999.getStudentId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                marksofintroductiontoaicourse9999.setCourseId(courseIdNew);
            }
            if (studentIdNew != null) {
                studentIdNew = em.getReference(studentIdNew.getClass(), studentIdNew.getId());
                marksofintroductiontoaicourse9999.setStudentId(studentIdNew);
            }
            marksofintroductiontoaicourse9999 = em.merge(marksofintroductiontoaicourse9999);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getMarksofintroductiontoaicourse9999List().add(marksofintroductiontoaicourse9999);
                courseIdNew = em.merge(courseIdNew);
            }
            if (studentIdOld != null && !studentIdOld.equals(studentIdNew)) {
                studentIdOld.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999);
                studentIdOld = em.merge(studentIdOld);
            }
            if (studentIdNew != null && !studentIdNew.equals(studentIdOld)) {
                studentIdNew.getMarksofintroductiontoaicourse9999List().add(marksofintroductiontoaicourse9999);
                studentIdNew = em.merge(studentIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = marksofintroductiontoaicourse9999.getId();
                if (findMarksofintroductiontoaicourse9999(id) == null) {
                    throw new NonexistentEntityException("The marksofintroductiontoaicourse9999 with id " + id + " no longer exists.");
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
            Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999;
            try {
                marksofintroductiontoaicourse9999 = em.getReference(Marksofintroductiontoaicourse9999.class, id);
                marksofintroductiontoaicourse9999.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The marksofintroductiontoaicourse9999 with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = marksofintroductiontoaicourse9999.getCourseId();
            if (courseId != null) {
                courseId.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999);
                courseId = em.merge(courseId);
            }
            Student0000 studentId = marksofintroductiontoaicourse9999.getStudentId();
            if (studentId != null) {
                studentId.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999);
                studentId = em.merge(studentId);
            }
            em.remove(marksofintroductiontoaicourse9999);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Marksofintroductiontoaicourse9999> findMarksofintroductiontoaicourse9999Entities() {
        return findMarksofintroductiontoaicourse9999Entities(true, -1, -1);
    }

    public List<Marksofintroductiontoaicourse9999> findMarksofintroductiontoaicourse9999Entities(int maxResults, int firstResult) {
        return findMarksofintroductiontoaicourse9999Entities(false, maxResults, firstResult);
    }

    private List<Marksofintroductiontoaicourse9999> findMarksofintroductiontoaicourse9999Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Marksofintroductiontoaicourse9999.class));
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

    public Marksofintroductiontoaicourse9999 findMarksofintroductiontoaicourse9999(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Marksofintroductiontoaicourse9999.class, id);
        } finally {
            em.close();
        }
    }

    public int getMarksofintroductiontoaicourse9999Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Marksofintroductiontoaicourse9999> rt = cq.from(Marksofintroductiontoaicourse9999.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
