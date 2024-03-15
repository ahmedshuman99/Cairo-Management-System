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
import Entities.Courses.Introductiontonetwork;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class IntroductiontonetworkJpaController implements Serializable {

    public IntroductiontonetworkJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Introductiontonetwork introductiontonetwork) {
        EntityManager em = null;
        try {
            em = getEntityManager();
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

    public void edit(Introductiontonetwork introductiontonetwork) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Introductiontonetwork persistentIntroductiontonetwork = em.find(Introductiontonetwork.class, introductiontonetwork.getId());
            Course0000 courseIdOld = persistentIntroductiontonetwork.getCourseId();
            Course0000 courseIdNew = introductiontonetwork.getCourseId();
            Student0000 studentIdOld = persistentIntroductiontonetwork.getStudentId();
            Student0000 studentIdNew = introductiontonetwork.getStudentId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                introductiontonetwork.setCourseId(courseIdNew);
            }
            if (studentIdNew != null) {
                studentIdNew = em.getReference(studentIdNew.getClass(), studentIdNew.getId());
                introductiontonetwork.setStudentId(studentIdNew);
            }
            introductiontonetwork = em.merge(introductiontonetwork);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getIntroductiontonetworkList().remove(introductiontonetwork);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getIntroductiontonetworkList().add(introductiontonetwork);
                courseIdNew = em.merge(courseIdNew);
            }
            if (studentIdOld != null && !studentIdOld.equals(studentIdNew)) {
                studentIdOld.getIntroductiontonetworkList().remove(introductiontonetwork);
                studentIdOld = em.merge(studentIdOld);
            }
            if (studentIdNew != null && !studentIdNew.equals(studentIdOld)) {
                studentIdNew.getIntroductiontonetworkList().add(introductiontonetwork);
                studentIdNew = em.merge(studentIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = introductiontonetwork.getId();
                if (findIntroductiontonetwork(id) == null) {
                    throw new NonexistentEntityException("The introductiontonetwork with id " + id + " no longer exists.");
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
            Introductiontonetwork introductiontonetwork;
            try {
                introductiontonetwork = em.getReference(Introductiontonetwork.class, id);
                introductiontonetwork.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The introductiontonetwork with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = introductiontonetwork.getCourseId();
            if (courseId != null) {
                courseId.getIntroductiontonetworkList().remove(introductiontonetwork);
                courseId = em.merge(courseId);
            }
            Student0000 studentId = introductiontonetwork.getStudentId();
            if (studentId != null) {
                studentId.getIntroductiontonetworkList().remove(introductiontonetwork);
                studentId = em.merge(studentId);
            }
            em.remove(introductiontonetwork);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Introductiontonetwork> findIntroductiontonetworkEntities() {
        return findIntroductiontonetworkEntities(true, -1, -1);
    }

    public List<Introductiontonetwork> findIntroductiontonetworkEntities(int maxResults, int firstResult) {
        return findIntroductiontonetworkEntities(false, maxResults, firstResult);
    }

    private List<Introductiontonetwork> findIntroductiontonetworkEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Introductiontonetwork.class));
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

    public Introductiontonetwork findIntroductiontonetwork(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Introductiontonetwork.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntroductiontonetworkCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Introductiontonetwork> rt = cq.from(Introductiontonetwork.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
