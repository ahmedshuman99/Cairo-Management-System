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
import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import Entities.Identity.Doctor0000;
import Repositories.exceptions.IllegalOrphanException;
import Repositories.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class Doctor0000JpaController implements Serializable {

    public Doctor0000JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Doctor0000 doctor0000) {
        if (doctor0000.getAssignedcoursestoteachers0000List() == null) {
            doctor0000.setAssignedcoursestoteachers0000List(new ArrayList<Assignedcoursestoteachers0000>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Assignedcoursestoteachers0000> attachedAssignedcoursestoteachers0000List = new ArrayList<Assignedcoursestoteachers0000>();
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach : doctor0000.getAssignedcoursestoteachers0000List()) {
                assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach = em.getReference(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach.getClass(), assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach.getCourseassignedId());
                attachedAssignedcoursestoteachers0000List.add(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach);
            }
            doctor0000.setAssignedcoursestoteachers0000List(attachedAssignedcoursestoteachers0000List);
            em.persist(doctor0000);
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListAssignedcoursestoteachers0000 : doctor0000.getAssignedcoursestoteachers0000List()) {
                Doctor0000 oldDoctorIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000 = assignedcoursestoteachers0000ListAssignedcoursestoteachers0000.getDoctorId();
                assignedcoursestoteachers0000ListAssignedcoursestoteachers0000.setDoctorId(doctor0000);
                assignedcoursestoteachers0000ListAssignedcoursestoteachers0000 = em.merge(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000);
                if (oldDoctorIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000 != null) {
                    oldDoctorIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000);
                    oldDoctorIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000 = em.merge(oldDoctorIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Doctor0000 doctor0000) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor0000 persistentDoctor0000 = em.find(Doctor0000.class, doctor0000.getDoctorId());
            List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000ListOld = persistentDoctor0000.getAssignedcoursestoteachers0000List();
            List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000ListNew = doctor0000.getAssignedcoursestoteachers0000List();
            List<String> illegalOrphanMessages = null;
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListOldAssignedcoursestoteachers0000 : assignedcoursestoteachers0000ListOld) {
                if (!assignedcoursestoteachers0000ListNew.contains(assignedcoursestoteachers0000ListOldAssignedcoursestoteachers0000)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Assignedcoursestoteachers0000 " + assignedcoursestoteachers0000ListOldAssignedcoursestoteachers0000 + " since its doctorId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Assignedcoursestoteachers0000> attachedAssignedcoursestoteachers0000ListNew = new ArrayList<Assignedcoursestoteachers0000>();
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach : assignedcoursestoteachers0000ListNew) {
                assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach = em.getReference(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach.getClass(), assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach.getCourseassignedId());
                attachedAssignedcoursestoteachers0000ListNew.add(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach);
            }
            assignedcoursestoteachers0000ListNew = attachedAssignedcoursestoteachers0000ListNew;
            doctor0000.setAssignedcoursestoteachers0000List(assignedcoursestoteachers0000ListNew);
            doctor0000 = em.merge(doctor0000);
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 : assignedcoursestoteachers0000ListNew) {
                if (!assignedcoursestoteachers0000ListOld.contains(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000)) {
                    Doctor0000 oldDoctorIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 = assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.getDoctorId();
                    assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.setDoctorId(doctor0000);
                    assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 = em.merge(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000);
                    if (oldDoctorIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 != null && !oldDoctorIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.equals(doctor0000)) {
                        oldDoctorIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000);
                        oldDoctorIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 = em.merge(oldDoctorIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = doctor0000.getDoctorId();
                if (findDoctor0000(id) == null) {
                    throw new NonexistentEntityException("The doctor0000 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor0000 doctor0000;
            try {
                doctor0000 = em.getReference(Doctor0000.class, id);
                doctor0000.getDoctorId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The doctor0000 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000ListOrphanCheck = doctor0000.getAssignedcoursestoteachers0000List();
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListOrphanCheckAssignedcoursestoteachers0000 : assignedcoursestoteachers0000ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Doctor0000 (" + doctor0000 + ") cannot be destroyed since the Assignedcoursestoteachers0000 " + assignedcoursestoteachers0000ListOrphanCheckAssignedcoursestoteachers0000 + " in its assignedcoursestoteachers0000List field has a non-nullable doctorId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(doctor0000);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Doctor0000> findDoctor0000Entities() {
        return findDoctor0000Entities(true, -1, -1);
    }

    public List<Doctor0000> findDoctor0000Entities(int maxResults, int firstResult) {
        return findDoctor0000Entities(false, maxResults, firstResult);
    }

    private List<Doctor0000> findDoctor0000Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Doctor0000.class));
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

    public Doctor0000 findDoctor0000(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Doctor0000.class, id);
        } finally {
            em.close();
        }
    }

    public int getDoctor0000Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Doctor0000> rt = cq.from(Doctor0000.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
