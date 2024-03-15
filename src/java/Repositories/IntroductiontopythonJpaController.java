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
import Entities.Courses.Introductiontopython;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class IntroductiontopythonJpaController implements Serializable {

    public IntroductiontopythonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Introductiontopython introductiontopython) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course0000 courseId = introductiontopython.getCourseId();
            if (courseId != null) {
                courseId = em.getReference(courseId.getClass(), courseId.getCourseId());
                introductiontopython.setCourseId(courseId);
            }
            Student0000 studentId = introductiontopython.getStudentId();
            if (studentId != null) {
                studentId = em.getReference(studentId.getClass(), studentId.getId());
                introductiontopython.setStudentId(studentId);
            }
            em.persist(introductiontopython);
            if (courseId != null) {
                courseId.getIntroductiontopythonList().add(introductiontopython);
                courseId = em.merge(courseId);
            }
            if (studentId != null) {
                studentId.getIntroductiontopythonList().add(introductiontopython);
                studentId = em.merge(studentId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Introductiontopython introductiontopython) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Introductiontopython persistentIntroductiontopython = em.find(Introductiontopython.class, introductiontopython.getId());
            Course0000 courseIdOld = persistentIntroductiontopython.getCourseId();
            Course0000 courseIdNew = introductiontopython.getCourseId();
            Student0000 studentIdOld = persistentIntroductiontopython.getStudentId();
            Student0000 studentIdNew = introductiontopython.getStudentId();
            if (courseIdNew != null) {
                courseIdNew = em.getReference(courseIdNew.getClass(), courseIdNew.getCourseId());
                introductiontopython.setCourseId(courseIdNew);
            }
            if (studentIdNew != null) {
                studentIdNew = em.getReference(studentIdNew.getClass(), studentIdNew.getId());
                introductiontopython.setStudentId(studentIdNew);
            }
            introductiontopython = em.merge(introductiontopython);
            if (courseIdOld != null && !courseIdOld.equals(courseIdNew)) {
                courseIdOld.getIntroductiontopythonList().remove(introductiontopython);
                courseIdOld = em.merge(courseIdOld);
            }
            if (courseIdNew != null && !courseIdNew.equals(courseIdOld)) {
                courseIdNew.getIntroductiontopythonList().add(introductiontopython);
                courseIdNew = em.merge(courseIdNew);
            }
            if (studentIdOld != null && !studentIdOld.equals(studentIdNew)) {
                studentIdOld.getIntroductiontopythonList().remove(introductiontopython);
                studentIdOld = em.merge(studentIdOld);
            }
            if (studentIdNew != null && !studentIdNew.equals(studentIdOld)) {
                studentIdNew.getIntroductiontopythonList().add(introductiontopython);
                studentIdNew = em.merge(studentIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = introductiontopython.getId();
                if (findIntroductiontopython(id) == null) {
                    throw new NonexistentEntityException("The introductiontopython with id " + id + " no longer exists.");
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
            Introductiontopython introductiontopython;
            try {
                introductiontopython = em.getReference(Introductiontopython.class, id);
                introductiontopython.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The introductiontopython with id " + id + " no longer exists.", enfe);
            }
            Course0000 courseId = introductiontopython.getCourseId();
            if (courseId != null) {
                courseId.getIntroductiontopythonList().remove(introductiontopython);
                courseId = em.merge(courseId);
            }
            Student0000 studentId = introductiontopython.getStudentId();
            if (studentId != null) {
                studentId.getIntroductiontopythonList().remove(introductiontopython);
                studentId = em.merge(studentId);
            }
            em.remove(introductiontopython);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Introductiontopython> findIntroductiontopythonEntities() {
        return findIntroductiontopythonEntities(true, -1, -1);
    }

    public List<Introductiontopython> findIntroductiontopythonEntities(int maxResults, int firstResult) {
        return findIntroductiontopythonEntities(false, maxResults, firstResult);
    }

    private List<Introductiontopython> findIntroductiontopythonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Introductiontopython.class));
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

    public Introductiontopython findIntroductiontopython(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Introductiontopython.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntroductiontopythonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Introductiontopython> rt = cq.from(Introductiontopython.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
