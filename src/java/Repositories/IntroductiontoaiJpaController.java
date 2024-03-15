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
import Entities.Courses.Introductiontoai;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class IntroductiontoaiJpaController implements Serializable {

    public IntroductiontoaiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Introductiontoai introductiontoai) {
        EntityManager em = null;
        try {
            em = getEntityManager();
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
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Introductiontoai introductiontoai) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Introductiontoai persistentIntroductiontoai = em.find(Introductiontoai.class, introductiontoai.getId());
            Course0000 courseIdOld = persistentIntroductiontoai.getCourseId();
            Course0000 courseIdNew = introductiontoai.getCourseId();
            Student0000 studentIdOld = persistentIntroductiontoai.getStudentId();
            Student0000 studentIdNew = introductiontoai.getStudentId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                introductiontoai.setCourseId(courseIdNew);
            }
            if (studentIdNew != null) {
                studentIdNew = em.getReference(studentIdNew.getClass(), studentIdNew.getId());
                introductiontoai.setStudentId(studentIdNew);
            }
            introductiontoai = em.merge(introductiontoai);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getIntroductiontoaiList().remove(introductiontoai);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getIntroductiontoaiList().add(introductiontoai);
                courseIdNew = em.merge(courseIdNew);
            }
            if (studentIdOld != null && !studentIdOld.equals(studentIdNew)) {
                studentIdOld.getIntroductiontoaiList().remove(introductiontoai);
                studentIdOld = em.merge(studentIdOld);
            }
            if (studentIdNew != null && !studentIdNew.equals(studentIdOld)) {
                studentIdNew.getIntroductiontoaiList().add(introductiontoai);
                studentIdNew = em.merge(studentIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = introductiontoai.getId();
                if (findIntroductiontoai(id) == null) {
                    throw new NonexistentEntityException("The introductiontoai with id " + id + " no longer exists.");
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
            Introductiontoai introductiontoai;
            try {
                introductiontoai = em.getReference(Introductiontoai.class, id);
                introductiontoai.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The introductiontoai with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = introductiontoai.getCourseId();
            if (courseId != null) {
                courseId.getIntroductiontoaiList().remove(introductiontoai);
                courseId = em.merge(courseId);
            }
            Student0000 studentId = introductiontoai.getStudentId();
            if (studentId != null) {
                studentId.getIntroductiontoaiList().remove(introductiontoai);
                studentId = em.merge(studentId);
            }
            em.remove(introductiontoai);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Introductiontoai> findIntroductiontoaiEntities() {
        return findIntroductiontoaiEntities(true, -1, -1);
    }

    public List<Introductiontoai> findIntroductiontoaiEntities(int maxResults, int firstResult) {
        return findIntroductiontoaiEntities(false, maxResults, firstResult);
    }

    private List<Introductiontoai> findIntroductiontoaiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Introductiontoai.class));
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

    public Introductiontoai findIntroductiontoai(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Introductiontoai.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntroductiontoaiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Introductiontoai> rt = cq.from(Introductiontoai.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
