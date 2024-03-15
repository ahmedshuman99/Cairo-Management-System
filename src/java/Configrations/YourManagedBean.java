/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configrations;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entities.Identity.Student0000;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
/**
 *
 * @author ahmed
 */
@ManagedBean
@RequestScoped
public class YourManagedBean implements Serializable{

    @PersistenceContext
    private EntityManager entityManager;

    private int courseId;
    private List<Student0000> studentsForCourse;

    @PostConstruct
    public void init() {
        // Load initial data when the bean is constructed
        // Here you can load the default course or do any other initialization
    }

    public void searchStudentsForCourse() {
        studentsForCourse = getStudentsForCourse(courseId);
    }

    public List<Student0000> getStudentsForCourse(int courseId) {
        TypedQuery<Student0000> query = entityManager.createQuery(
            "SELECT s FROM Assigncourse ac " +
            "JOIN Student0000 s ON ac.studentId = s.id " +
            "JOIN Course0000 c ON ac.courseId = c.courseId " +
            "WHERE c.courseId = :courseId", Student0000.class);

        query.setParameter("courseId", courseId);

        return query.getResultList();
    }

    // Getters and Setters for courseId and studentsForCourse

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<Student0000> getStudentsForCourse() {
        return studentsForCourse;
    }

    public void setStudentsForCourse(List<Student0000> studentsForCourse) {
        this.studentsForCourse = studentsForCourse;
    }
}
