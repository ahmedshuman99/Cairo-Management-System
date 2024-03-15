/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontopython;
import Entities.Identity.Student0000;
import Services.IntroductionToPythonService;
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
@ManagedBean(name = "python")
@ViewScoped
public class IntroductionToPythonController implements Serializable {
    private IntroductionToPythonService service = new IntroductionToPythonService();
    private List<Introductiontopython>list = new ArrayList();
    private Introductiontopython python = new Introductiontopython();
    private Student0000Service student = new Student0000Service();
 
    
    private Integer id;
    private Course0000 courseId;
    private Student0000 studentId;
    private int idStudent;
    private final int idCourse = 6; 

    public IntroductionToPythonService getService() {
        return service;
    }

    public void setService(IntroductionToPythonService service) {
        this.service = service;
    }

    public List<Introductiontopython> getList() {
        return list;
    }

    public void setList(List<Introductiontopython> list) {
        this.list = list;
    }

    public Introductiontopython getPython() {
        return python;
    }

    public void setPython(Introductiontopython python) {
        this.python = python;
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
    
    
    
    public List<Introductiontopython> getAll() {
        list = service.getAll();
        return list;
    }

    public void addNewStudent() {   
        python.setStudentId(student.findStudent0000(idStudent));
        python.setCourseId(new Course0000(idCourse));
        service.create(python);
  
    }
    
    
   
 
     public IntroductionToPythonController() {
    }
}
