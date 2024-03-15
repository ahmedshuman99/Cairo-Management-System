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
import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import Entities.Courses.Course0000;
import Entities.Courses.Introductiontosoftwareenginnering;
import Repositories.exceptions.IllegalOrphanException;
import Repositories.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ahmed
 */
public class Course0000JpaController implements Serializable {

    public Course0000JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Course0000 course0000) {
        if (course0000.getIntroductiontoaiList() == null) {
            course0000.setIntroductiontoaiList(new ArrayList<Introductiontoai>());
        }
        if (course0000.getMarksofintroductiontoaicourse9999List() == null) {
            course0000.setMarksofintroductiontoaicourse9999List(new ArrayList<Marksofintroductiontoaicourse9999>());
        }
        if (course0000.getIntroductiontonetworkList() == null) {
            course0000.setIntroductiontonetworkList(new ArrayList<Introductiontonetwork>());
        }
        if (course0000.getIntroductiontoalgebraList() == null) {
            course0000.setIntroductiontoalgebraList(new ArrayList<Introductiontoalgebra>());
        }
        if (course0000.getIntroductiontopythonList() == null) {
            course0000.setIntroductiontopythonList(new ArrayList<Introductiontopython>());
        }
        if (course0000.getAssignedcoursestoteachers0000List() == null) {
            course0000.setAssignedcoursestoteachers0000List(new ArrayList<Assignedcoursestoteachers0000>());
        }
        if (course0000.getIntroductiontosoftwareenginneringList() == null) {
            course0000.setIntroductiontosoftwareenginneringList(new ArrayList<Introductiontosoftwareenginnering>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Introductiontoai> attachedIntroductiontoaiList = new ArrayList<Introductiontoai>();
            for (Introductiontoai introductiontoaiListIntroductiontoaiToAttach : course0000.getIntroductiontoaiList()) {
                introductiontoaiListIntroductiontoaiToAttach = em.getReference(introductiontoaiListIntroductiontoaiToAttach.getClass(), introductiontoaiListIntroductiontoaiToAttach.getId());
                attachedIntroductiontoaiList.add(introductiontoaiListIntroductiontoaiToAttach);
            }
            course0000.setIntroductiontoaiList(attachedIntroductiontoaiList);
            List<Marksofintroductiontoaicourse9999> attachedMarksofintroductiontoaicourse9999List = new ArrayList<Marksofintroductiontoaicourse9999>();
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach : course0000.getMarksofintroductiontoaicourse9999List()) {
                marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach = em.getReference(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach.getClass(), marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach.getId());
                attachedMarksofintroductiontoaicourse9999List.add(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999ToAttach);
            }
            course0000.setMarksofintroductiontoaicourse9999List(attachedMarksofintroductiontoaicourse9999List);
            List<Introductiontonetwork> attachedIntroductiontonetworkList = new ArrayList<Introductiontonetwork>();
            for (Introductiontonetwork introductiontonetworkListIntroductiontonetworkToAttach : course0000.getIntroductiontonetworkList()) {
                introductiontonetworkListIntroductiontonetworkToAttach = em.getReference(introductiontonetworkListIntroductiontonetworkToAttach.getClass(), introductiontonetworkListIntroductiontonetworkToAttach.getId());
                attachedIntroductiontonetworkList.add(introductiontonetworkListIntroductiontonetworkToAttach);
            }
            course0000.setIntroductiontonetworkList(attachedIntroductiontonetworkList);
            List<Introductiontoalgebra> attachedIntroductiontoalgebraList = new ArrayList<Introductiontoalgebra>();
            for (Introductiontoalgebra introductiontoalgebraListIntroductiontoalgebraToAttach : course0000.getIntroductiontoalgebraList()) {
                introductiontoalgebraListIntroductiontoalgebraToAttach = em.getReference(introductiontoalgebraListIntroductiontoalgebraToAttach.getClass(), introductiontoalgebraListIntroductiontoalgebraToAttach.getId());
                attachedIntroductiontoalgebraList.add(introductiontoalgebraListIntroductiontoalgebraToAttach);
            }
            course0000.setIntroductiontoalgebraList(attachedIntroductiontoalgebraList);
            List<Introductiontopython> attachedIntroductiontopythonList = new ArrayList<Introductiontopython>();
            for (Introductiontopython introductiontopythonListIntroductiontopythonToAttach : course0000.getIntroductiontopythonList()) {
                introductiontopythonListIntroductiontopythonToAttach = em.getReference(introductiontopythonListIntroductiontopythonToAttach.getClass(), introductiontopythonListIntroductiontopythonToAttach.getId());
                attachedIntroductiontopythonList.add(introductiontopythonListIntroductiontopythonToAttach);
            }
            course0000.setIntroductiontopythonList(attachedIntroductiontopythonList);
            List<Assignedcoursestoteachers0000> attachedAssignedcoursestoteachers0000List = new ArrayList<Assignedcoursestoteachers0000>();
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach : course0000.getAssignedcoursestoteachers0000List()) {
                assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach = em.getReference(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach.getClass(), assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach.getCourseassignedId());
                attachedAssignedcoursestoteachers0000List.add(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000ToAttach);
            }
            course0000.setAssignedcoursestoteachers0000List(attachedAssignedcoursestoteachers0000List);
            List<Introductiontosoftwareenginnering> attachedIntroductiontosoftwareenginneringList = new ArrayList<Introductiontosoftwareenginnering>();
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach : course0000.getIntroductiontosoftwareenginneringList()) {
                introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach = em.getReference(introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach.getClass(), introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach.getId());
                attachedIntroductiontosoftwareenginneringList.add(introductiontosoftwareenginneringListIntroductiontosoftwareenginneringToAttach);
            }
            course0000.setIntroductiontosoftwareenginneringList(attachedIntroductiontosoftwareenginneringList);
            em.persist(course0000);
            for (Introductiontoai introductiontoaiListIntroductiontoai : course0000.getIntroductiontoaiList()) {
                Course0000 oldCourseIdOfIntroductiontoaiListIntroductiontoai = introductiontoaiListIntroductiontoai.getCourseId();
                introductiontoaiListIntroductiontoai.setCourseId(course0000);
                introductiontoaiListIntroductiontoai = em.merge(introductiontoaiListIntroductiontoai);
                if (oldCourseIdOfIntroductiontoaiListIntroductiontoai != null) {
                    oldCourseIdOfIntroductiontoaiListIntroductiontoai.getIntroductiontoaiList().remove(introductiontoaiListIntroductiontoai);
                    oldCourseIdOfIntroductiontoaiListIntroductiontoai = em.merge(oldCourseIdOfIntroductiontoaiListIntroductiontoai);
                }
            }
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 : course0000.getMarksofintroductiontoaicourse9999List()) {
                Course0000 oldCourseIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 = marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999.getCourseId();
                marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999.setCourseId(course0000);
                marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 = em.merge(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999);
                if (oldCourseIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 != null) {
                    oldCourseIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999);
                    oldCourseIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999 = em.merge(oldCourseIdOfMarksofintroductiontoaicourse9999ListMarksofintroductiontoaicourse9999);
                }
            }
            for (Introductiontonetwork introductiontonetworkListIntroductiontonetwork : course0000.getIntroductiontonetworkList()) {
                Course0000 oldCourseIdOfIntroductiontonetworkListIntroductiontonetwork = introductiontonetworkListIntroductiontonetwork.getCourseId();
                introductiontonetworkListIntroductiontonetwork.setCourseId(course0000);
                introductiontonetworkListIntroductiontonetwork = em.merge(introductiontonetworkListIntroductiontonetwork);
                if (oldCourseIdOfIntroductiontonetworkListIntroductiontonetwork != null) {
                    oldCourseIdOfIntroductiontonetworkListIntroductiontonetwork.getIntroductiontonetworkList().remove(introductiontonetworkListIntroductiontonetwork);
                    oldCourseIdOfIntroductiontonetworkListIntroductiontonetwork = em.merge(oldCourseIdOfIntroductiontonetworkListIntroductiontonetwork);
                }
            }
            for (Introductiontoalgebra introductiontoalgebraListIntroductiontoalgebra : course0000.getIntroductiontoalgebraList()) {
                Course0000 oldCourseIdOfIntroductiontoalgebraListIntroductiontoalgebra = introductiontoalgebraListIntroductiontoalgebra.getCourseId();
                introductiontoalgebraListIntroductiontoalgebra.setCourseId(course0000);
                introductiontoalgebraListIntroductiontoalgebra = em.merge(introductiontoalgebraListIntroductiontoalgebra);
                if (oldCourseIdOfIntroductiontoalgebraListIntroductiontoalgebra != null) {
                    oldCourseIdOfIntroductiontoalgebraListIntroductiontoalgebra.getIntroductiontoalgebraList().remove(introductiontoalgebraListIntroductiontoalgebra);
                    oldCourseIdOfIntroductiontoalgebraListIntroductiontoalgebra = em.merge(oldCourseIdOfIntroductiontoalgebraListIntroductiontoalgebra);
                }
            }
            for (Introductiontopython introductiontopythonListIntroductiontopython : course0000.getIntroductiontopythonList()) {
                Course0000 oldCourseIdOfIntroductiontopythonListIntroductiontopython = introductiontopythonListIntroductiontopython.getCourseId();
                introductiontopythonListIntroductiontopython.setCourseId(course0000);
                introductiontopythonListIntroductiontopython = em.merge(introductiontopythonListIntroductiontopython);
                if (oldCourseIdOfIntroductiontopythonListIntroductiontopython != null) {
                    oldCourseIdOfIntroductiontopythonListIntroductiontopython.getIntroductiontopythonList().remove(introductiontopythonListIntroductiontopython);
                    oldCourseIdOfIntroductiontopythonListIntroductiontopython = em.merge(oldCourseIdOfIntroductiontopythonListIntroductiontopython);
                }
            }
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListAssignedcoursestoteachers0000 : course0000.getAssignedcoursestoteachers0000List()) {
                Course0000 oldCourseIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000 = assignedcoursestoteachers0000ListAssignedcoursestoteachers0000.getCourseId();
                assignedcoursestoteachers0000ListAssignedcoursestoteachers0000.setCourseId(course0000);
                assignedcoursestoteachers0000ListAssignedcoursestoteachers0000 = em.merge(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000);
                if (oldCourseIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000 != null) {
                    oldCourseIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000ListAssignedcoursestoteachers0000);
                    oldCourseIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000 = em.merge(oldCourseIdOfAssignedcoursestoteachers0000ListAssignedcoursestoteachers0000);
                }
            }
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListIntroductiontosoftwareenginnering : course0000.getIntroductiontosoftwareenginneringList()) {
                Course0000 oldCourseIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering = introductiontosoftwareenginneringListIntroductiontosoftwareenginnering.getCourseId();
                introductiontosoftwareenginneringListIntroductiontosoftwareenginnering.setCourseId(course0000);
                introductiontosoftwareenginneringListIntroductiontosoftwareenginnering = em.merge(introductiontosoftwareenginneringListIntroductiontosoftwareenginnering);
                if (oldCourseIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering != null) {
                    oldCourseIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginneringListIntroductiontosoftwareenginnering);
                    oldCourseIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering = em.merge(oldCourseIdOfIntroductiontosoftwareenginneringListIntroductiontosoftwareenginnering);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Course0000 course0000) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course0000 persistentCourse0000 = em.find(Course0000.class, course0000.getCourseId());
            List<Introductiontoai> introductiontoaiListOld = persistentCourse0000.getIntroductiontoaiList();
            List<Introductiontoai> introductiontoaiListNew = course0000.getIntroductiontoaiList();
            List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999ListOld = persistentCourse0000.getMarksofintroductiontoaicourse9999List();
            List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999ListNew = course0000.getMarksofintroductiontoaicourse9999List();
            List<Introductiontonetwork> introductiontonetworkListOld = persistentCourse0000.getIntroductiontonetworkList();
            List<Introductiontonetwork> introductiontonetworkListNew = course0000.getIntroductiontonetworkList();
            List<Introductiontoalgebra> introductiontoalgebraListOld = persistentCourse0000.getIntroductiontoalgebraList();
            List<Introductiontoalgebra> introductiontoalgebraListNew = course0000.getIntroductiontoalgebraList();
            List<Introductiontopython> introductiontopythonListOld = persistentCourse0000.getIntroductiontopythonList();
            List<Introductiontopython> introductiontopythonListNew = course0000.getIntroductiontopythonList();
            List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000ListOld = persistentCourse0000.getAssignedcoursestoteachers0000List();
            List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000ListNew = course0000.getAssignedcoursestoteachers0000List();
            List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringListOld = persistentCourse0000.getIntroductiontosoftwareenginneringList();
            List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringListNew = course0000.getIntroductiontosoftwareenginneringList();
            List<String> illegalOrphanMessages = null;
            for (Introductiontoai introductiontoaiListOldIntroductiontoai : introductiontoaiListOld) {
                if (!introductiontoaiListNew.contains(introductiontoaiListOldIntroductiontoai)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontoai " + introductiontoaiListOldIntroductiontoai + " since its courseId field is not nullable.");
                }
            }
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListOldMarksofintroductiontoaicourse9999 : marksofintroductiontoaicourse9999ListOld) {
                if (!marksofintroductiontoaicourse9999ListNew.contains(marksofintroductiontoaicourse9999ListOldMarksofintroductiontoaicourse9999)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Marksofintroductiontoaicourse9999 " + marksofintroductiontoaicourse9999ListOldMarksofintroductiontoaicourse9999 + " since its courseId field is not nullable.");
                }
            }
            for (Introductiontonetwork introductiontonetworkListOldIntroductiontonetwork : introductiontonetworkListOld) {
                if (!introductiontonetworkListNew.contains(introductiontonetworkListOldIntroductiontonetwork)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontonetwork " + introductiontonetworkListOldIntroductiontonetwork + " since its courseId field is not nullable.");
                }
            }
            for (Introductiontoalgebra introductiontoalgebraListOldIntroductiontoalgebra : introductiontoalgebraListOld) {
                if (!introductiontoalgebraListNew.contains(introductiontoalgebraListOldIntroductiontoalgebra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontoalgebra " + introductiontoalgebraListOldIntroductiontoalgebra + " since its courseId field is not nullable.");
                }
            }
            for (Introductiontopython introductiontopythonListOldIntroductiontopython : introductiontopythonListOld) {
                if (!introductiontopythonListNew.contains(introductiontopythonListOldIntroductiontopython)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontopython " + introductiontopythonListOldIntroductiontopython + " since its courseId field is not nullable.");
                }
            }
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListOldAssignedcoursestoteachers0000 : assignedcoursestoteachers0000ListOld) {
                if (!assignedcoursestoteachers0000ListNew.contains(assignedcoursestoteachers0000ListOldAssignedcoursestoteachers0000)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Assignedcoursestoteachers0000 " + assignedcoursestoteachers0000ListOldAssignedcoursestoteachers0000 + " since its courseId field is not nullable.");
                }
            }
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListOldIntroductiontosoftwareenginnering : introductiontosoftwareenginneringListOld) {
                if (!introductiontosoftwareenginneringListNew.contains(introductiontosoftwareenginneringListOldIntroductiontosoftwareenginnering)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Introductiontosoftwareenginnering " + introductiontosoftwareenginneringListOldIntroductiontosoftwareenginnering + " since its courseId field is not nullable.");
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
            course0000.setIntroductiontoaiList(introductiontoaiListNew);
            List<Marksofintroductiontoaicourse9999> attachedMarksofintroductiontoaicourse9999ListNew = new ArrayList<Marksofintroductiontoaicourse9999>();
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach : marksofintroductiontoaicourse9999ListNew) {
                marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach = em.getReference(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach.getClass(), marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach.getId());
                attachedMarksofintroductiontoaicourse9999ListNew.add(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999ToAttach);
            }
            marksofintroductiontoaicourse9999ListNew = attachedMarksofintroductiontoaicourse9999ListNew;
            course0000.setMarksofintroductiontoaicourse9999List(marksofintroductiontoaicourse9999ListNew);
            List<Introductiontonetwork> attachedIntroductiontonetworkListNew = new ArrayList<Introductiontonetwork>();
            for (Introductiontonetwork introductiontonetworkListNewIntroductiontonetworkToAttach : introductiontonetworkListNew) {
                introductiontonetworkListNewIntroductiontonetworkToAttach = em.getReference(introductiontonetworkListNewIntroductiontonetworkToAttach.getClass(), introductiontonetworkListNewIntroductiontonetworkToAttach.getId());
                attachedIntroductiontonetworkListNew.add(introductiontonetworkListNewIntroductiontonetworkToAttach);
            }
            introductiontonetworkListNew = attachedIntroductiontonetworkListNew;
            course0000.setIntroductiontonetworkList(introductiontonetworkListNew);
            List<Introductiontoalgebra> attachedIntroductiontoalgebraListNew = new ArrayList<Introductiontoalgebra>();
            for (Introductiontoalgebra introductiontoalgebraListNewIntroductiontoalgebraToAttach : introductiontoalgebraListNew) {
                introductiontoalgebraListNewIntroductiontoalgebraToAttach = em.getReference(introductiontoalgebraListNewIntroductiontoalgebraToAttach.getClass(), introductiontoalgebraListNewIntroductiontoalgebraToAttach.getId());
                attachedIntroductiontoalgebraListNew.add(introductiontoalgebraListNewIntroductiontoalgebraToAttach);
            }
            introductiontoalgebraListNew = attachedIntroductiontoalgebraListNew;
            course0000.setIntroductiontoalgebraList(introductiontoalgebraListNew);
            List<Introductiontopython> attachedIntroductiontopythonListNew = new ArrayList<Introductiontopython>();
            for (Introductiontopython introductiontopythonListNewIntroductiontopythonToAttach : introductiontopythonListNew) {
                introductiontopythonListNewIntroductiontopythonToAttach = em.getReference(introductiontopythonListNewIntroductiontopythonToAttach.getClass(), introductiontopythonListNewIntroductiontopythonToAttach.getId());
                attachedIntroductiontopythonListNew.add(introductiontopythonListNewIntroductiontopythonToAttach);
            }
            introductiontopythonListNew = attachedIntroductiontopythonListNew;
            course0000.setIntroductiontopythonList(introductiontopythonListNew);
            List<Assignedcoursestoteachers0000> attachedAssignedcoursestoteachers0000ListNew = new ArrayList<Assignedcoursestoteachers0000>();
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach : assignedcoursestoteachers0000ListNew) {
                assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach = em.getReference(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach.getClass(), assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach.getCourseassignedId());
                attachedAssignedcoursestoteachers0000ListNew.add(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000ToAttach);
            }
            assignedcoursestoteachers0000ListNew = attachedAssignedcoursestoteachers0000ListNew;
            course0000.setAssignedcoursestoteachers0000List(assignedcoursestoteachers0000ListNew);
            List<Introductiontosoftwareenginnering> attachedIntroductiontosoftwareenginneringListNew = new ArrayList<Introductiontosoftwareenginnering>();
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach : introductiontosoftwareenginneringListNew) {
                introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach = em.getReference(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach.getClass(), introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach.getId());
                attachedIntroductiontosoftwareenginneringListNew.add(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginneringToAttach);
            }
            introductiontosoftwareenginneringListNew = attachedIntroductiontosoftwareenginneringListNew;
            course0000.setIntroductiontosoftwareenginneringList(introductiontosoftwareenginneringListNew);
            course0000 = em.merge(course0000);
            for (Introductiontoai introductiontoaiListNewIntroductiontoai : introductiontoaiListNew) {
                if (!introductiontoaiListOld.contains(introductiontoaiListNewIntroductiontoai)) {
                    Course0000 oldCourseIdOfIntroductiontoaiListNewIntroductiontoai = introductiontoaiListNewIntroductiontoai.getCourseId();
                    introductiontoaiListNewIntroductiontoai.setCourseId(course0000);
                    introductiontoaiListNewIntroductiontoai = em.merge(introductiontoaiListNewIntroductiontoai);
                    if (oldCourseIdOfIntroductiontoaiListNewIntroductiontoai != null && !oldCourseIdOfIntroductiontoaiListNewIntroductiontoai.equals(course0000)) {
                        oldCourseIdOfIntroductiontoaiListNewIntroductiontoai.getIntroductiontoaiList().remove(introductiontoaiListNewIntroductiontoai);
                        oldCourseIdOfIntroductiontoaiListNewIntroductiontoai = em.merge(oldCourseIdOfIntroductiontoaiListNewIntroductiontoai);
                    }
                }
            }
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 : marksofintroductiontoaicourse9999ListNew) {
                if (!marksofintroductiontoaicourse9999ListOld.contains(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999)) {
                    Course0000 oldCourseIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 = marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.getCourseId();
                    marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.setCourseId(course0000);
                    marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 = em.merge(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999);
                    if (oldCourseIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 != null && !oldCourseIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.equals(course0000)) {
                        oldCourseIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999.getMarksofintroductiontoaicourse9999List().remove(marksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999);
                        oldCourseIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999 = em.merge(oldCourseIdOfMarksofintroductiontoaicourse9999ListNewMarksofintroductiontoaicourse9999);
                    }
                }
            }
            for (Introductiontonetwork introductiontonetworkListNewIntroductiontonetwork : introductiontonetworkListNew) {
                if (!introductiontonetworkListOld.contains(introductiontonetworkListNewIntroductiontonetwork)) {
                    Course0000 oldCourseIdOfIntroductiontonetworkListNewIntroductiontonetwork = introductiontonetworkListNewIntroductiontonetwork.getCourseId();
                    introductiontonetworkListNewIntroductiontonetwork.setCourseId(course0000);
                    introductiontonetworkListNewIntroductiontonetwork = em.merge(introductiontonetworkListNewIntroductiontonetwork);
                    if (oldCourseIdOfIntroductiontonetworkListNewIntroductiontonetwork != null && !oldCourseIdOfIntroductiontonetworkListNewIntroductiontonetwork.equals(course0000)) {
                        oldCourseIdOfIntroductiontonetworkListNewIntroductiontonetwork.getIntroductiontonetworkList().remove(introductiontonetworkListNewIntroductiontonetwork);
                        oldCourseIdOfIntroductiontonetworkListNewIntroductiontonetwork = em.merge(oldCourseIdOfIntroductiontonetworkListNewIntroductiontonetwork);
                    }
                }
            }
            for (Introductiontoalgebra introductiontoalgebraListNewIntroductiontoalgebra : introductiontoalgebraListNew) {
                if (!introductiontoalgebraListOld.contains(introductiontoalgebraListNewIntroductiontoalgebra)) {
                    Course0000 oldCourseIdOfIntroductiontoalgebraListNewIntroductiontoalgebra = introductiontoalgebraListNewIntroductiontoalgebra.getCourseId();
                    introductiontoalgebraListNewIntroductiontoalgebra.setCourseId(course0000);
                    introductiontoalgebraListNewIntroductiontoalgebra = em.merge(introductiontoalgebraListNewIntroductiontoalgebra);
                    if (oldCourseIdOfIntroductiontoalgebraListNewIntroductiontoalgebra != null && !oldCourseIdOfIntroductiontoalgebraListNewIntroductiontoalgebra.equals(course0000)) {
                        oldCourseIdOfIntroductiontoalgebraListNewIntroductiontoalgebra.getIntroductiontoalgebraList().remove(introductiontoalgebraListNewIntroductiontoalgebra);
                        oldCourseIdOfIntroductiontoalgebraListNewIntroductiontoalgebra = em.merge(oldCourseIdOfIntroductiontoalgebraListNewIntroductiontoalgebra);
                    }
                }
            }
            for (Introductiontopython introductiontopythonListNewIntroductiontopython : introductiontopythonListNew) {
                if (!introductiontopythonListOld.contains(introductiontopythonListNewIntroductiontopython)) {
                    Course0000 oldCourseIdOfIntroductiontopythonListNewIntroductiontopython = introductiontopythonListNewIntroductiontopython.getCourseId();
                    introductiontopythonListNewIntroductiontopython.setCourseId(course0000);
                    introductiontopythonListNewIntroductiontopython = em.merge(introductiontopythonListNewIntroductiontopython);
                    if (oldCourseIdOfIntroductiontopythonListNewIntroductiontopython != null && !oldCourseIdOfIntroductiontopythonListNewIntroductiontopython.equals(course0000)) {
                        oldCourseIdOfIntroductiontopythonListNewIntroductiontopython.getIntroductiontopythonList().remove(introductiontopythonListNewIntroductiontopython);
                        oldCourseIdOfIntroductiontopythonListNewIntroductiontopython = em.merge(oldCourseIdOfIntroductiontopythonListNewIntroductiontopython);
                    }
                }
            }
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 : assignedcoursestoteachers0000ListNew) {
                if (!assignedcoursestoteachers0000ListOld.contains(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000)) {
                    Course0000 oldCourseIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 = assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.getCourseId();
                    assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.setCourseId(course0000);
                    assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 = em.merge(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000);
                    if (oldCourseIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 != null && !oldCourseIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.equals(course0000)) {
                        oldCourseIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000.getAssignedcoursestoteachers0000List().remove(assignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000);
                        oldCourseIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000 = em.merge(oldCourseIdOfAssignedcoursestoteachers0000ListNewAssignedcoursestoteachers0000);
                    }
                }
            }
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering : introductiontosoftwareenginneringListNew) {
                if (!introductiontosoftwareenginneringListOld.contains(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering)) {
                    Course0000 oldCourseIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering = introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.getCourseId();
                    introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.setCourseId(course0000);
                    introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering = em.merge(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering);
                    if (oldCourseIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering != null && !oldCourseIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.equals(course0000)) {
                        oldCourseIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering.getIntroductiontosoftwareenginneringList().remove(introductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering);
                        oldCourseIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering = em.merge(oldCourseIdOfIntroductiontosoftwareenginneringListNewIntroductiontosoftwareenginnering);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = course0000.getCourseId();
                if (findCourse0000(id) == null) {
                    throw new NonexistentEntityException("The course0000 with id " + id + " no longer exists.");
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
            Course0000 course0000;
            try {
                course0000 = em.getReference(Course0000.class, id);
                course0000.getCourseId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The course0000 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Introductiontoai> introductiontoaiListOrphanCheck = course0000.getIntroductiontoaiList();
            for (Introductiontoai introductiontoaiListOrphanCheckIntroductiontoai : introductiontoaiListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course0000 (" + course0000 + ") cannot be destroyed since the Introductiontoai " + introductiontoaiListOrphanCheckIntroductiontoai + " in its introductiontoaiList field has a non-nullable courseId field.");
            }
            List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999ListOrphanCheck = course0000.getMarksofintroductiontoaicourse9999List();
            for (Marksofintroductiontoaicourse9999 marksofintroductiontoaicourse9999ListOrphanCheckMarksofintroductiontoaicourse9999 : marksofintroductiontoaicourse9999ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course0000 (" + course0000 + ") cannot be destroyed since the Marksofintroductiontoaicourse9999 " + marksofintroductiontoaicourse9999ListOrphanCheckMarksofintroductiontoaicourse9999 + " in its marksofintroductiontoaicourse9999List field has a non-nullable courseId field.");
            }
            List<Introductiontonetwork> introductiontonetworkListOrphanCheck = course0000.getIntroductiontonetworkList();
            for (Introductiontonetwork introductiontonetworkListOrphanCheckIntroductiontonetwork : introductiontonetworkListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course0000 (" + course0000 + ") cannot be destroyed since the Introductiontonetwork " + introductiontonetworkListOrphanCheckIntroductiontonetwork + " in its introductiontonetworkList field has a non-nullable courseId field.");
            }
            List<Introductiontoalgebra> introductiontoalgebraListOrphanCheck = course0000.getIntroductiontoalgebraList();
            for (Introductiontoalgebra introductiontoalgebraListOrphanCheckIntroductiontoalgebra : introductiontoalgebraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course0000 (" + course0000 + ") cannot be destroyed since the Introductiontoalgebra " + introductiontoalgebraListOrphanCheckIntroductiontoalgebra + " in its introductiontoalgebraList field has a non-nullable courseId field.");
            }
            List<Introductiontopython> introductiontopythonListOrphanCheck = course0000.getIntroductiontopythonList();
            for (Introductiontopython introductiontopythonListOrphanCheckIntroductiontopython : introductiontopythonListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course0000 (" + course0000 + ") cannot be destroyed since the Introductiontopython " + introductiontopythonListOrphanCheckIntroductiontopython + " in its introductiontopythonList field has a non-nullable courseId field.");
            }
            List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000ListOrphanCheck = course0000.getAssignedcoursestoteachers0000List();
            for (Assignedcoursestoteachers0000 assignedcoursestoteachers0000ListOrphanCheckAssignedcoursestoteachers0000 : assignedcoursestoteachers0000ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course0000 (" + course0000 + ") cannot be destroyed since the Assignedcoursestoteachers0000 " + assignedcoursestoteachers0000ListOrphanCheckAssignedcoursestoteachers0000 + " in its assignedcoursestoteachers0000List field has a non-nullable courseId field.");
            }
            List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringListOrphanCheck = course0000.getIntroductiontosoftwareenginneringList();
            for (Introductiontosoftwareenginnering introductiontosoftwareenginneringListOrphanCheckIntroductiontosoftwareenginnering : introductiontosoftwareenginneringListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course0000 (" + course0000 + ") cannot be destroyed since the Introductiontosoftwareenginnering " + introductiontosoftwareenginneringListOrphanCheckIntroductiontosoftwareenginnering + " in its introductiontosoftwareenginneringList field has a non-nullable courseId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(course0000);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Course0000> findCourse0000Entities() {
        return findCourse0000Entities(true, -1, -1);
    }

    public List<Course0000> findCourse0000Entities(int maxResults, int firstResult) {
        return findCourse0000Entities(false, maxResults, firstResult);
    }

    private List<Course0000> findCourse0000Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Course0000.class));
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

    public Course0000 findCourse0000(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Course0000.class, id);
        } finally {
            em.close();
        }
    }

    public int getCourse0000Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Course0000> rt = cq.from(Course0000.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
