/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontosoftwareenginnering;
import Entities.Identity.Student0000;
import Services.IntroductiontosoftwareenginneringService;
import Services.Student0000Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "softwareEngineering")
@ViewScoped
public class IntroductiontosoftwareenginneringController implements Serializable {
    private IntroductiontosoftwareenginneringService service = new IntroductiontosoftwareenginneringService();
    private List<Introductiontosoftwareenginnering>list = new ArrayList();
    private Introductiontosoftwareenginnering softwareEngineering = new Introductiontosoftwareenginnering();
    private Student0000Service student = new Student0000Service();
 
    
    private Integer id;
    private Course0000 courseId;
    private Student0000 studentId;
    private int idStudent;
    private final int idCourse = 4;

    public Student0000Service getStudent() {
        return student;
    }

    public void setStudent(Student0000Service student) {
        this.student = student;
    }
    
    
    

    public IntroductiontosoftwareenginneringService getService() {
        return service;
    }

    public void setService(IntroductiontosoftwareenginneringService service) {
        this.service = service;
    }

    public List<Introductiontosoftwareenginnering> getList() {
        return list;
    }

    public void setList(List<Introductiontosoftwareenginnering> list) {
        this.list = list;
    }

    public Introductiontosoftwareenginnering getSoftwareEngineering() {
        return softwareEngineering;
    }

    public void setSoftwareEngineering(Introductiontosoftwareenginnering softwareEngineering) {
        this.softwareEngineering = softwareEngineering;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course0000 getCourseId() {
        return courseId;
    }

    public void setCourseId(Course0000 courseId) {
        this.courseId = courseId;
    }

    public Student0000 getStudentId() {
        return studentId;
    }

    public void setStudentId(Student0000 studentId) {
        this.studentId = studentId;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public List<Introductiontosoftwareenginnering> getAll() {
        list = service.getAll();
        return list;
    }

    public void addNewStudent() {   
        softwareEngineering.setStudentId(student.findStudent0000(idStudent));
        softwareEngineering.setCourseId(new Course0000(idCourse));
        service.create(softwareEngineering);
  
    }
    
    
    public IntroductiontosoftwareenginneringController() {
    }
    
}
