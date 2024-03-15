/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Entities.Identity.Admin0000;
import Repositories.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ahmed
 */
public class Admin0000JpaController implements Serializable {

    public Admin0000JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Admin0000 admin0000) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(admin0000);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Admin0000 admin0000) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            admin0000 = em.merge(admin0000);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = admin0000.getId();
                if (findAdmin0000(id) == null) {
                    throw new NonexistentEntityException("The admin0000 with id " + id + " no longer exists.");
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
            Admin0000 admin0000;
            try {
                admin0000 = em.getReference(Admin0000.class, id);
                admin0000.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The admin0000 with id " + id + " no longer exists.", enfe);
            }
            em.remove(admin0000);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Admin0000> findAdmin0000Entities() {
        return findAdmin0000Entities(true, -1, -1);
    }

    public List<Admin0000> findAdmin0000Entities(int maxResults, int firstResult) {
        return findAdmin0000Entities(false, maxResults, firstResult);
    }

    private List<Admin0000> findAdmin0000Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Admin0000.class));
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

    public Admin0000 findAdmin0000(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Admin0000.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdmin0000Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Admin0000> rt = cq.from(Admin0000.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
