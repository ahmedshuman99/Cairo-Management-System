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
import Entities.Courses.Introductiontoai;
import java.util.ArrayList;
import java.util.List;
import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
import Entities.Courses.Introductiontonetwork;
import Entities.Courses.Introductiontoalgebra;
import Entities.Courses.Introductiontopython;
import Entities.Courses.Introductiontosoftwareenginnering;
import Entities.Identity.Student0000;
import Repositories.exceptions.IllegalOrphanException;
import Repositories.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class Student0000JpaController implements Serializable {

    public Student0000JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Student0000 student0000) {
        if (student0000.getIntroductiontoaiList() == null) {
            student0000.setIntroductiontoaiList(new ArrayList<Introductiontoai>());
        }
        if (student0000.getMarksofintroductiontoaicourse9999List() == null) {
            student0000.setMarksofintroductiontoaicourse9999List(new ArrayList<Marksofintroductiontoaicourse9999>());
        }
        if (student0000.getIntroductiontonetworkList() == null) {
            student0000.setIntroductiontonetworkList(new ArrayList<Introductiontonetwork>());
        }
        if (student0000.getIntroductiontoalgebraList() == null) {
            student0000.setIntroductiontoalgebraList(new ArrayList<Introductiontoalgebra>());
        }
        if (student0000.getIntroductiontopythonList() == null) {
            student0000.setIntroductiontopythonList(new ArrayList<Introductiontopython>());
        }
        if (student0000.getIntroductiontosoftwareenginneringList() == null) {
            student0000.setIntroductiontosoftwareenginneringList(new ArrayList<Introductiontosoftwareenginnering>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Introductiontoai> attachedIntroductiontoaiList = new ArrayList<Introductiontoai>();
            for (Introductiontoai introductiontoaiListIntroductiontoaiToAttach : student0000.getIntroductiontoaiList()) {
                introductiontoaiListIntroductiontoaiToAttach = em.getReference(introductiontoaiListIntroductiontoaiToAttach.getClass(), introductiontoaiListIntroductiontoaiToAttach.getId());
                attachedIntroductiontoaiList.add(introductiontoaiListIntroductiontoaiToAttach);
            }
            student0000.setIntroductiontoaiList(attachedIntroductiontoaiList);
            List<Marksofintroductiontoaicourse9999> attachedMarksofintroductiontoaicourse9999List = new ArrayList<Marksofintroductiontoaicourse9999>();
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach : student0000.getMarksofintroductiontoaicourse9999List()) {
                marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach = em.getReference(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach.getClass(), marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach.getId());
                attachedMarksofintroductiontoaicourse9999List.add(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach);
            }
            student0000.setMarksofintroductiontoaicourse9999List(attachedMarksofintroductiontoaicourse9999List);
            List<Introductiontonetwork> attachedIntroductiontonetworkList = new ArrayList<Introductiontonetwork>();
            for (Introductiontonetwork introductiontonetworkListIntroductiontonetworkToAttach : student0000.getIntroductiontonetworkList()) {
                introductiontonetworkListIntroductiontonetworkToAttach = em.getReference(introductiontonetworkListIntroductiontonetworkToAttach.getClass(), introductiontonetworkListIntroductiontonetworkToAttach.getId());
                attachedIntroductiontonetworkList.add(introductiontonetworkListIntroductiontonetworkToAttach);
            }
            student0000.setIntroductiontonetworkList(attachedIntroductiontonetworkList);
            List<Introductiontoalgebra> attachedIntroductiontoalgebraList = new ArrayList<Introductiontoalgebra>();
            for (Introductiontoalgebra introductiontoalgebraListIntroductiontoalgebraToAttach : student0000.getIntroductiontoalgebraList()) {
                introductiontoalgebraListIntroductiontoalgebraToAttach = em.getReference(introductiontoalgebraListIntroductiontoalgebraToAttach.getClass(), introductiontoalgebraListIntroductiontoalgebraToAttach.getId());
                attachedIntroductiontoalgebraList.add(introductiontoalgebraListIntroductiontoalgebraToAttach);
            }
            student0000.setIntroductiontoalgebraList(attachedIntroductiontoalgebraList);
            List<Introductiontopython> attachedIntroductiontopythonList = new ArrayList<Introductiontopython>();
            for (Introductiontopython introductiontopythonListIntroductiontopythonToAttach : student0000.getIntroductiontopythonList()) {
                introductiontopythonListIntroductiontopythonToAttach = em.getReference(introductiontopythonListIntroductiontopythonToAttach.getClass(), introductiontopythonListIntroductiontopythonToAttach.getId());
                attachedIntroductiontopythonList.add(introductiontopythonListIntroductiontopythonToAttach);
            }
            student0000.setIntroductiontopythonList(attachedIntroductiontopythonList);
            List<Introductiontosoftwareenginnering> attachedIntroductiontosoftwareenginneringList = new ArrayList<Introductiontosoftwareenginnering>();
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach : student0000.getIntroductiontosoftwareenginneringList()) {
                introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach = em.getReference(introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach.getClass(), introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach.getId());
                attachedIntroductiontosoftwareenginneringList.add(introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach);
            }
            student0000.setIntroductiontosoftwareenginneringList(attachedIntroductiontosoftwareenginneringList);
            em.persist(student0000);
            for (Introductiontoai introductiontoaiListIntroductiontoai : student0000.getIntroductiontoaiList()) {
                Student0000 oldStudentIdOfIntroductiontoaiListIntroductiontoai = introductiontoaiListIntroductiontoai.getStudentId();
                introductiontoaiListIntroductiontoai.setStudentId(student0000);
                introductiontoaiListIntroductiontoai = em.merge(introductiontoaiListIntroductiontoai);
                if (oldStudentIdOfIntroductiontoaiListIntroductiontoai != null) {
                    oldStudentIdOfIntroductiontoaiListIntroductiontoai.getIntroductiontoaiList().remove(introductiontoaiListIntroductiontoai);
                    oldStudentIdOfIntroductiontoaiListIntroductiontoai = em.merge(oldStudentIdOfIntroductiontoaiListIntroductiontoai);
                }
            }
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 : student0000.getMarksofintroductiontoaicourse9999List()) {
                Student0000 oldStudentIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 = marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999.getStudentId();
                marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999.setStudentId(student0000);
                marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 = em.merge(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999);
                if (oldStudentIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 != null) {
                    oldStudentIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999);
                    oldStudentIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 = em.merge(oldStudentIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999);
                }
            }
            for (Introductiontonetwork introductiontonetworkListIntroductiontonetwork : student0000.getIntroductiontonetworkList()) {
                Student0000 oldStudentIdOfIntroductiontonetworkListIntroductiontonetwork = introductiontonetworkListIntroductiontonetwork.getStudentId();
                introductiontonetworkListIntroductiontonetwork.setStudentId(student0000);
                introductiontonetworkListIntroductiontonetwork = em.merge(introductiontonetworkListIntroductiontonetwork);
                if (oldStudentIdOfIntroductiontonetworkListIntroductiontonetwork != null) {
                    oldStudentIdOfIntroductiontonetworkListIntroductiontonetwork.getIntroductiontonetworkList().remove(introductiontonetworkListIntroductiontonetwork);
                    oldStudentIdOfIntroductiontonetworkListIntroductiontonetwork = em.merge(oldStudentIdOfIntroductiontonetworkListIntroductiontonetwork);
                }
            }
            for (Introductiontoalgebra introductiontoalgebraListIntroductiontoalgebra : student0000.getIntroductiontoalgebraList()) {
                Student0000 oldStudentIdOfIntroductiontoalgebraListIntroductiontoalgebra = introductiontoalgebraListIntroductiontoalgebra.getStudentId();
                introductiontoalgebraListIntroductiontoalgebra.setStudentId(student0000);
                introductiontoalgebraListIntroductiontoalgebra = em.merge(introductiontoalgebraListIntroductiontoalgebra);
                if (oldStudentIdOfIntroductiontoalgebraListIntroductiontoalgebra != null) {
                    oldStudentIdOfIntroductiontoalgebraListIntroductiontoalgebra.getIntroductiontoalgebraList().remove(introductiontoalgebraListIntroductiontoalgebra);
                    oldStudentIdOfIntroductiontoalgebraListIntroductiontoalgebra = em.merge(oldStudentIdOfIntroductiontoalgebraListIntroductiontoalgebra);
                }
            }
            for (Introductiontopython introductiontopythonListIntroductiontopython : student0000.getIntroductiontopythonList()) {
                Student0000 oldStudentIdOfIntroductiontopythonListIntroductiontopython = introductiontopythonListIntroductiontopython.getStudentId();
                introductiontopythonListIntroductiontopython.setStudentId(student0000);
                introductiontopythonListIntroductiontopython = em.merge(introductiontopythonListIntroductiontopython);
                if (oldStudentIdOfIntroductiontopythonListIntroductiontopython != null) {
                    oldStudentIdOfIntroductiontopythonListIntroductiontopython.getIntroductiontopythonList().remove(introductiontopythonListIntroductiontopython);
                    oldStudentIdOfIntroductiontopythonListIntroductiontopython = em.merge(oldStudentIdOfIntroductiontopythonListIntroductiontopython);
                }
            }
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListIntroductiontosoftwareenginnering : student0000.getIntroductiontosoftwareenginneringList()) {
                Student0000 oldStudentIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering = introductiontosoftwareenginneringListIntroductiontosoftwareenginnering.getStudentId();
                introductiontosoftwareenginneringListIntroductiontosoftwareenginnering.setStudentId(student0000);
                introductiontosoftwareenginneringListIntroductiontosoftwareenginnering = em.merge(introductiontosoftwareenginneringListIntroductiontosoftwareenginnering);
                if (oldStudentIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering != null) {
                    oldStudentIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginneringListIntroductiontosoftwareenginnering);
                    oldStudentIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering = em.merge(oldStudentIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Student0000 student0000) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student0000 persistentStudent0000 = em.find(Student0000.class, student0000.getId());
            List<Introductiontoai> introductiontoaiListOld = persistentStudent0000.getIntroductiontoaiList();
            List<Introductiontoai> introductiontoaiListNew = student0000.getIntroductiontoaiList();
            List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999ListOld = persistentStudent0000.getMarksofintroductiontoaicourse9999List();
            List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999ListNew = student0000.getMarksofintroductiontoaicourse9999List();
            List<Introductiontonetwork> introductiontonetworkListOld = persistentStudent0000.getIntroductiontonetworkList();
            List<Introductiontonetwork> introductiontonetworkListNew = student0000.getIntroductiontonetworkList();
            List<Introductiontoalgebra> introductiontoalgebraListOld = persistentStudent0000.getIntroductiontoalgebraList();
            List<Introductiontoalgebra> introductiontoalgebraListNew = student0000.getIntroductiontoalgebraList();
            List<Introductiontopython> introductiontopythonListOld = persistentStudent0000.getIntroductiontopythonList();
            List<Introductiontopython> introductiontopythonListNew = student0000.getIntroductiontopythonList();
            List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringListOld = persistentStudent0000.getIntroductiontosoftwareenginneringList();
            List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringListNew = student0000.getIntroductiontosoftwareenginneringList();
            List<String> illegalOrphanMessages = null;
            for (Introductiontoai introductiontoaiListOldIntroductiontoai : introductiontoaiListOld) {
                if (!introductiontoaiListNew.contains(introductiontoaiListOldIntroductiontoai)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontoai " + introductiontoaiListOldIntroductiontoai + " since its studentId field is not nullable.");
                }
            }
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListOldMarksofintroductiontoaicourse9999 : marksofintroductiontoaicourse9999ListOld) {
                if (!marksofintroductiontoaicourse9999ListNew.contains(marksofintroductiontoaicourse9999ListOldMarksofintroductiontoaicourse9999)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Marksofintroductiontoaicourse9999 " + marksofintroductiontoaicourse9999ListOldMarksofintroductiontoaicourse9999 + " since its studentId field is not nullable.");
                }
            }
            for (Introductiontonetwork introductiontonetworkListOldIntroductiontonetwork : introductiontonetworkListOld) {
                if (!introductiontonetworkListNew.contains(introductiontonetworkListOldIntroductiontonetwork)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontonetwork " + introductiontonetworkListOldIntroductiontonetwork + " since its studentId field is not nullable.");
                }
            }
            for (Introductiontoalgebra introductiontoalgebraListOldIntroductiontoalgebra : introductiontoalgebraListOld) {
                if (!introductiontoalgebraListNew.contains(introductiontoalgebraListOldIntroductiontoalgebra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontoalgebra " + introductiontoalgebraListOldIntroductiontoalgebra + " since its studentId field is not nullable.");
                }
            }
            for (Introductiontopython introductiontopythonListOldIntroductiontopython : introductiontopythonListOld) {
                if (!introductiontopythonListNew.contains(introductiontopythonListOldIntroductiontopython)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontopython " + introductiontopythonListOldIntroductiontopython + " since its studentId field is not nullable.");
                }
            }
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListOldIntroductiontosoftwareenginnering : introductiontosoftwareenginneringListOld) {
                if (!introductiontosoftwareenginneringListNew.contains(introductiontosoftwareenginneringListOldIntroductiontosoftwareenginnering)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontosoftwareenginnering " + introductiontosoftwareenginneringListOldIntroductiontosoftwareenginnering + " since its studentId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Introductiontoai> attachedIntroductiontoaiListNew = new ArrayList<Introductiontoai>();
            for (Introductiontoai introductiontoaiListNewIntroductiontoaiToAttach : introductiontoaiListNew) {
                introductiontoaiListNewIntroductiontoaiToAttach = em.getReference(introductiontoaiListNewIntroductiontoaiToAttach.getClass(), introductiontoaiListNewIntroductiontoaiToAttach.getId());
                attachedIntroductiontoaiListNew.add(introductiontoaiListNewIntroductiontoaiToAttach);
            }
            introductiontoaiListNew = attachedIntroductiontoaiListNew;
            student0000.setIntroductiontoaiList(introductiontoaiListNew);
            List<Marksofintroductiontoaicourse9999> attachedMarksofintroductiontoaicourse9999ListNew = new ArrayList<Marksofintroductiontoaicourse9999>();
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach : marksofintroductiontoaicourse9999ListNew) {
                marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach = em.getReference(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach.getClass(), marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach.getId());
                attachedMarksofintroductiontoaicourse9999ListNew.add(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach);
            }
            marksofintroductiontoaicourse9999ListNew = attachedMarksofintroductiontoaicourse9999ListNew;
            student0000.setMarksofintroductiontoaicourse9999List(marksofintroductiontoaicourse9999ListNew);
            List<Introductiontonetwork> attachedIntroductiontonetworkListNew = new ArrayList<Introductiontonetwork>();
            for (Introductiontonetwork introductiontonetworkListNewIntroductiontonetworkToAttach : introductiontonetworkListNew) {
                introductiontonetworkListNewIntroductiontonetworkToAttach = em.getReference(introductiontonetworkListNewIntroductiontonetworkToAttach.getClass(), introductiontonetworkListNewIntroductiontonetworkToAttach.getId());
                attachedIntroductiontonetworkListNew.add(introductiontonetworkListNewIntroductiontonetworkToAttach);
            }
            introductiontonetworkListNew = attachedIntroductiontonetworkListNew;
            student0000.setIntroductiontonetworkList(introductiontonetworkListNew);
            List<Introductiontoalgebra> attachedIntroductiontoalgebraListNew = new ArrayList<Introductiontoalgebra>();
            for (Introductiontoalgebra introductiontoalgebraListNewIntroductiontoalgebraToAttach : introductiontoalgebraListNew) {
                introductiontoalgebraListNewIntroductiontoalgebraToAttach = em.getReference(introductiontoalgebraListNewIntroductiontoalgebraToAttach.getClass(), introductiontoalgebraListNewIntroductiontoalgebraToAttach.getId());
                attachedIntroductiontoalgebraListNew.add(introductiontoalgebraListNewIntroductiontoalgebraToAttach);
            }
            introductiontoalgebraListNew = attachedIntroductiontoalgebraListNew;
            student0000.setIntroductiontoalgebraList(introductiontoalgebraListNew);
            List<Introductiontopython> attachedIntroductiontopythonListNew = new ArrayList<Introductiontopython>();
            for (Introductiontopython introductiontopythonListNewIntroductiontopythonToAttach : introductiontopythonListNew) {
                introductiontopythonListNewIntroductiontopythonToAttach = em.getReference(introductiontopythonListNewIntroductiontopythonToAttach.getClass(), introductiontopythonListNewIntroductiontopythonToAttach.getId());
                attachedIntroductiontopythonListNew.add(introductiontopythonListNewIntroductiontopythonToAttach);
            }
            introductiontopythonListNew = attachedIntroductiontopythonListNew;
            student0000.setIntroductiontopythonList(introductiontopythonListNew);
            List<Introductiontosoftwareenginnering> attachedIntroductiontosoftwareenginneringListNew = new ArrayList<Introductiontosoftwareenginnering>();
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach : introductiontosoftwareenginneringListNew) {
                introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach = em.getReference(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach.getClass(), introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach.getId());
                attachedIntroductiontosoftwareenginneringListNew.add(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach);
            }
            introductiontosoftwareenginneringListNew = attachedIntroductiontosoftwareenginneringListNew;
            student0000.setIntroductiontosoftwareenginneringList(introductiontosoftwareenginneringListNew);
            student0000 = em.merge(student0000);
            for (Introductiontoai introductiontoaiListNewIntroductiontoai : introductiontoaiListNew) {
                if (!introductiontoaiListOld.contains(introductiontoaiListNewIntroductiontoai)) {
                    Student0000 oldStudentIdOfIntroductiontoaiListNewIntroductiontoai = introductiontoaiListNewIntroductiontoai.getStudentId();
                    introductiontoaiListNewIntroductiontoai.setStudentId(student0000);
                    introductiontoaiListNewIntroductiontoai = em.merge(introductiontoaiListNewIntroductiontoai);
                    if (oldStudentIdOfIntroductiontoaiListNewIntroductiontoai != null && !oldStudentIdOfIntroductiontoaiListNewIntroductiontoai.equals(student0000)) {
                        oldStudentIdOfIntroductiontoaiListNewIntroductiontoai.getIntroductiontoaiList().remove(introductiontoaiListNewIntroductiontoai);
                        oldStudentIdOfIntroductiontoaiListNewIntroductiontoai = em.merge(oldStudentIdOfIntroductiontoaiListNewIntroductiontoai);
                    }
                }
            }
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 : marksofintroductiontoaicourse9999ListNew) {
                if (!marksofintroductiontoaicourse9999ListOld.contains(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999)) {
                    Student0000 oldStudentIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 = marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.getStudentId();
                    marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.setStudentId(student0000);
                    marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 = em.merge(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999);
                    if (oldStudentIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 != null && !oldStudentIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.equals(student0000)) {
                        oldStudentIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999);
                        oldStudentIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 = em.merge(oldStudentIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999);
                    }
                }
            }
            for (Introductiontonetwork introductiontonetworkListNewIntroductiontonetwork : introductiontonetworkListNew) {
                if (!introductiontonetworkListOld.contains(introductiontonetworkListNewIntroductiontonetwork)) {
                    Student0000 oldStudentIdOfIntroductiontonetworkListNewIntroductiontonetwork = introductiontonetworkListNewIntroductiontonetwork.getStudentId();
                    introductiontonetworkListNewIntroductiontonetwork.setStudentId(student0000);
                    introductiontonetworkListNewIntroductiontonetwork = em.merge(introductiontonetworkListNewIntroductiontonetwork);
                    if (oldStudentIdOfIntroductiontonetworkListNewIntroductiontonetwork != null && !oldStudentIdOfIntroductiontonetworkListNewIntroductiontonetwork.equals(student0000)) {
                        oldStudentIdOfIntroductiontonetworkListNewIntroductiontonetwork.getIntroductiontonetworkList().remove(introductiontonetworkListNewIntroductiontonetwork);
                        oldStudentIdOfIntroductiontonetworkListNewIntroductiontonetwork = em.merge(oldStudentIdOfIntroductiontonetworkListNewIntroductiontonetwork);
                    }
                }
            }
            for (Introductiontoalgebra introductiontoalgebraListNewIntroductiontoalgebra : introductiontoalgebraListNew) {
                if (!introductiontoalgebraListOld.contains(introductiontoalgebraListNewIntroductiontoalgebra)) {
                    Student0000 oldStudentIdOfIntroductiontoalgebraListNewIntroductiontoalgebra = introductiontoalgebraListNewIntroductiontoalgebra.getStudentId();
                    introductiontoalgebraListNewIntroductiontoalgebra.setStudentId(student0000);
                    introductiontoalgebraListNewIntroductiontoalgebra = em.merge(introductiontoalgebraListNewIntroductiontoalgebra);
                    if (oldStudentIdOfIntroductiontoalgebraListNewIntroductiontoalgebra != null && !oldStudentIdOfIntroductiontoalgebraListNewIntroductiontoalgebra.equals(student0000)) {
                        oldStudentIdOfIntroductiontoalgebraListNewIntroductiontoalgebra.getIntroductiontoalgebraList().remove(introductiontoalgebraListNewIntroductiontoalgebra);
                        oldStudentIdOfIntroductiontoalgebraListNewIntroductiontoalgebra = em.merge(oldStudentIdOfIntroductiontoalgebraListNewIntroductiontoalgebra);
                    }
                }
            }
            for (Introductiontopython introductiontopythonListNewIntroductiontopython : introductiontopythonListNew) {
                if (!introductiontopythonListOld.contains(introductiontopythonListNewIntroductiontopython)) {
                    Student0000 oldStudentIdOfIntroductiontopythonListNewIntroductiontopython = introductiontopythonListNewIntroductiontopython.getStudentId();
                    introductiontopythonListNewIntroductiontopython.setStudentId(student0000);
                    introductiontopythonListNewIntroductiontopython = em.merge(introductiontopythonListNewIntroductiontopython);
                    if (oldStudentIdOfIntroductiontopythonListNewIntroductiontopython != null && !oldStudentIdOfIntroductiontopythonListNewIntroductiontopython.equals(student0000)) {
                        oldStudentIdOfIntroductiontopythonListNewIntroductiontopython.getIntroductiontopythonList().remove(introductiontopythonListNewIntroductiontopython);
                        oldStudentIdOfIntroductiontopythonListNewIntroductiontopython = em.merge(oldStudentIdOfIntroductiontopythonListNewIntroductiontopython);
                    }
                }
            }
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering : introductiontosoftwareenginneringListNew) {
                if (!introductiontosoftwareenginneringListOld.contains(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering)) {
                    Student0000 oldStudentIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering = introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.getStudentId();
                    introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.setStudentId(student0000);
                    introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering = em.merge(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering);
                    if (oldStudentIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering != null && !oldStudentIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.equals(student0000)) {
                        oldStudentIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering);
                        oldStudentIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering = em.merge(oldStudentIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = student0000.getId();
                if (findStudent0000(id) == null) {
                    throw new NonexistentEntityException("The student0000 with id " + id + " no longer exists.");
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
            Student0000 student0000;
            try {
                student0000 = em.getReference(Student0000.class, id);
                student0000.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The student0000 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Introductiontoai> introductiontoaiListOrphanCheck = student0000.getIntroductiontoaiList();
            for (Introductiontoai introductiontoaiListOrphanCheckIntroductiontoai : introductiontoaiListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Student0000 (" + student0000 + ") cannot be destroyed since the Introductiontoai " + introductiontoaiListOrphanCheckIntroductiontoai + " in its introductiontoaiList field has a non-nullable studentId field.");
            }
            List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999ListOrphanCheck = student0000.getMarksofintroductiontoaicourse9999List();
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListOrphanCheckMarksofintroductiontoaicourse9999 : marksofintroductiontoaicourse9999ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Student0000 (" + student0000 + ") cannot be destroyed since the Marksofintroductiontoaicourse9999 " + marksofintroductiontoaicourse9999ListOrphanCheckMarksofintroductiontoaicourse9999 + " in its marksofintroductiontoaicourse9999List field has a non-nullable studentId field.");
            }
            List<Introductiontonetwork> introductiontonetworkListOrphanCheck = student0000.getIntroductiontonetworkList();
            for (Introductiontonetwork introductiontonetworkListOrphanCheckIntroductiontonetwork : introductiontonetworkListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Student0000 (" + student0000 + ") cannot be destroyed since the Introductiontonetwork " + introductiontonetworkListOrphanCheckIntroductiontonetwork + " in its introductiontonetworkList field has a non-nullable studentId field.");
            }
            List<Introductiontoalgebra> introductiontoalgebraListOrphanCheck = student0000.getIntroductiontoalgebraList();
            for (Introductiontoalgebra introductiontoalgebraListOrphanCheckIntroductiontoalgebra : introductiontoalgebraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Student0000 (" + student0000 + ") cannot be destroyed since the Introductiontoalgebra " + introductiontoalgebraListOrphanCheckIntroductiontoalgebra + " in its introductiontoalgebraList field has a non-nullable studentId field.");
            }
            List<Introductiontopython> introductiontopythonListOrphanCheck = student0000.getIntroductiontopythonList();
            for (Introductiontopython introductiontopythonListOrphanCheckIntroductiontopython : introductiontopythonListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Student0000 (" + student0000 + ") cannot be destroyed since the Introductiontopython " + introductiontopythonListOrphanCheckIntroductiontopython + " in its introductiontopythonList field has a non-nullable studentId field.");
            }
            List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringListOrphanCheck = student0000.getIntroductiontosoftwareenginneringList();
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListOrphanCheckIntroductiontosoftwareenginnering : introductiontosoftwareenginneringListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Student0000 (" + student0000 + ") cannot be destroyed since the Introductiontosoftwareenginnering " + introductiontosoftwareenginneringListOrphanCheckIntroductiontosoftwareenginnering + " in its introductiontosoftwareenginneringList field has a non-nullable studentId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(student0000);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Student0000> findStudent0000Entities() {
        return findStudent0000Entities(true, -1, -1);
    }

    public List<Student0000> findStudent0000Entities(int maxResults, int firstResult) {
        return findStudent0000Entities(false, maxResults, firstResult);
    }

    private List<Student0000> findStudent0000Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Student0000.class));
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

    public Student0000 findStudent0000(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Student0000.class, id);
        } finally {
            em.close();
        }
    }

    public int getStudent0000Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Student0000> rt = cq.from(Student0000.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
