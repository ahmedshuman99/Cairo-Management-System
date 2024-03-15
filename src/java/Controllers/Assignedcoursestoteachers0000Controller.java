/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import Entities.Courses.Course0000;
import Entities.Identity.Doctor0000;
import Services.Assignedcoursestoteachers0000Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "assign")
@ViewScoped
public class Assignedcoursestoteachers0000Controller  implements Serializable {

    //MARK :: ATTRIBUTES
    private Assignedcoursestoteachers0000Service service = new Assignedcoursestoteachers0000Service();
    private Assignedcoursestoteachers0000 assign = new Assignedcoursestoteachers0000();
    private List<Assignedcoursestoteachers0000> list = new ArrayList();
    private List<Course0000> selectedCourses = new ArrayList<>();
    private List<Doctor0000> selectedDoctor = new ArrayList<>();   
    private Integer courseassignedId;
    private Course0000 courseId;  
    private Doctor0000 doctorId;  
    private int idOfCourse;
    private int idOfDoctor;
    
        

    //MARK :: SETTERS && GETTERS
    public int getIdOfCourse() {
        return idOfCourse;
    }
    public void setIdOfCourse(int idOfCourse) {
        this.idOfCourse = idOfCourse;
    }
    public int getIdOfDoctor() {
        return idOfDoctor;
    }
    public void setIdOfDoctor(int idOfDoctor) {
        this.idOfDoctor = idOfDoctor;
    }
    public List<Doctor0000> getSelectedDoctor() {
        return selectedDoctor;
    }
    public void setSelectedDoctor(List<Doctor0000> selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }  
    public Assignedcoursestoteachers0000Service getService() {
        return service;
    }
    public void setService(Assignedcoursestoteachers0000Service service) {
        this.service = service;
    }
    public Assignedcoursestoteachers0000 getAssign() {
        return assign;
    }
    public void setAssign(Assignedcoursestoteachers0000 assign) {
        this.assign = assign;
    }
    public List<Assignedcoursestoteachers0000> getList() {
        return list;
    }
    public void setList(List<Assignedcoursestoteachers0000> list) {
        this.list = list;
    }
    public Integer getCourseassignedId() {
        return courseassignedId;
    }
    public void setCourseassignedId(Integer courseassignedId) {
        this.courseassignedId = courseassignedId;
    }
    public Course0000 getCourseId() {
        return courseId;
    }
    public void setCourseId(Course0000 courseId) {
        this.courseId = courseId;
    }
    public Doctor0000 getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(Doctor0000 doctorId) {
        this.doctorId = doctorId;
    }
    public List<Course0000> getSelectedCourses() {
        return selectedCourses;
    }
    public void setSelectedCourses(List<Course0000> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }
    
        

    //MARK :: METHODS
    public List<Assignedcoursestoteachers0000> getAll() {
        list = service.getAll();
        return list;
    } 
   
    public void addNewStudent() {
    
        assign.setCourseId(new Course0000(idOfCourse));
        assign.setDoctorId(new Doctor0000(idOfDoctor));
        service.create(assign);
    }
          
    
 
    //MARK :: CONSTRACTORS
    public Assignedcoursestoteachers0000Controller() {
    }

}
