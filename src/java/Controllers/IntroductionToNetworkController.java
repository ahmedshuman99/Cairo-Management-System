/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontonetwork;
import Entities.Identity.Student0000;
import Services.IntroductionToNetworkService;
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
@ManagedBean(name = "network")
@ViewScoped
public class IntroductionToNetworkController  implements Serializable{
    private IntroductionToNetworkService service = new IntroductionToNetworkService();
    private List<Introductiontonetwork>list = new ArrayList();
    private Introductiontonetwork network = new Introductiontonetwork();
    private Student0000Service student = new Student0000Service();
 
    
    private Integer id;
    private Course0000 courseId;
    private Student0000 studentId;
    private int idStudent;
    private final int idCourse = 2; 

    public IntroductionToNetworkService getService() {
        return service;
    }

    public void setService(IntroductionToNetworkService service) {
        this.service = service;
    }

    public List<Introductiontonetwork> getList() {
        return list;
    }

    public void setList(List<Introductiontonetwork> list) {
        this.list = list;
    }

    public Introductiontonetwork getNetwork() {
        return network;
    }

    public void setNetwork(Introductiontonetwork network) {
        this.network = network;
    }

    public Student0000Service getStudent() {
        return student;
    }

    public void setStudent(Student0000Service student) {
        this.student = student;
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
    
    
    public List<Introductiontonetwork> getAll() {
        list = service.getAll();
        return list;
    }

    public void addNewStudent() {   
        network.setStudentId(student.findStudent0000(idStudent));
        network.setCourseId(new Course0000(idCourse));
        service.create(network);
  
    }
    
    
    
    
    
    
    public IntroductionToNetworkController() {
    }
    
}
