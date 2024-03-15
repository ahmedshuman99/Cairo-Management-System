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
import Entities.Courses.Introductiontoalgebra;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class IntroductiontoalgebraJpaController implements Serializable {

    public IntroductiontoalgebraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Introductiontoalgebra introductiontoalgebra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
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
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Introductiontoalgebra introductiontoalgebra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Introductiontoalgebra persistentIntroductiontoalgebra = em.find(Introductiontoalgebra.class, introductiontoalgebra.getId());
            Course0000 courseIdOld = persistentIntroductiontoalgebra.getCourseId();
            Course0000 courseIdNew = introductiontoalgebra.getCourseId();
            Student0000 studentIdOld = persistentIntroductiontoalgebra.getStudentId();
            Student0000 studentIdNew = introductiontoalgebra.getStudentId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                introductiontoalgebra.setCourseId(courseIdNew);
            }
            if (studentIdNew != null) {
                studentIdNew = em.getReference(studentIdNew.getClass(), studentIdNew.getId());
                introductiontoalgebra.setStudentId(studentIdNew);
            }
            introductiontoalgebra = em.merge(introductiontoalgebra);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getIntroductiontoalgebraList().remove(introductiontoalgebra);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getIntroductiontoalgebraList().add(introductiontoalgebra);
                courseIdNew = em.merge(courseIdNew);
            }
            if (studentIdOld != null && !studentIdOld.equals(studentIdNew)) {
                studentIdOld.getIntroductiontoalgebraList().remove(introductiontoalgebra);
                studentIdOld = em.merge(studentIdOld);
            }
            if (studentIdNew != null && !studentIdNew.equals(studentIdOld)) {
                studentIdNew.getIntroductiontoalgebraList().add(introductiontoalgebra);
                studentIdNew = em.merge(studentIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = introductiontoalgebra.getId();
                if (findIntroductiontoalgebra(id) == null) {
                    throw new NonexistentEntityException("The introductiontoalgebra with id " + id + " no longer exists.");
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
            Introductiontoalgebra introductiontoalgebra;
            try {
                introductiontoalgebra = em.getReference(Introductiontoalgebra.class, id);
                introductiontoalgebra.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The introductiontoalgebra with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = introductiontoalgebra.getCourseId();
            if (courseId != null) {
                courseId.getIntroductiontoalgebraList().remove(introductiontoalgebra);
                courseId = em.merge(courseId);
            }
            Student0000 studentId = introductiontoalgebra.getStudentId();
            if (studentId != null) {
                studentId.getIntroductiontoalgebraList().remove(introductiontoalgebra);
                studentId = em.merge(studentId);
            }
            em.remove(introductiontoalgebra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Introductiontoalgebra> findIntroductiontoalgebraEntities() {
        return findIntroductiontoalgebraEntities(true, -1, -1);
    }

    public List<Introductiontoalgebra> findIntroductiontoalgebraEntities(int maxResults, int firstResult) {
        return findIntroductiontoalgebraEntities(false, maxResults, firstResult);
    }

    private List<Introductiontoalgebra> findIntroductiontoalgebraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Introductiontoalgebra.class));
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

    public Introductiontoalgebra findIntroductiontoalgebra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Introductiontoalgebra.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntroductiontoalgebraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Introductiontoalgebra> rt = cq.from(Introductiontoalgebra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
