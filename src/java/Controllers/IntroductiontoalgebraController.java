/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontoalgebra;
import Entities.Identity.Student0000;
import Services.IntroductiontoalgebraService;
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
@ManagedBean(name = "algebra")
@ViewScoped
public class IntroductiontoalgebraController  implements Serializable{

    
    private IntroductiontoalgebraService service = new IntroductiontoalgebraService();
    private List<Introductiontoalgebra>list = new ArrayList();
    private Introductiontoalgebra algebra = new Introductiontoalgebra();
    private Student0000Service student = new Student0000Service();
    
    private Integer id;
    private Course0000 courseId;
    private Student0000 studentId;
    private int idStudent;
    private final int idCourse = 1;

    public Student0000Service getStudent() {
        return student;
    }

    public void setStudent(Student0000Service student) {
        this.student = student;
    }

    
    
    
    
    public IntroductiontoalgebraService getService() {
        return service;
    }

    public void setService(IntroductiontoalgebraService service) {
        this.service = service;
    }

    public List<Introductiontoalgebra> getList() {
        return list;
    }

    public void setList(List<Introductiontoalgebra> list) {
        this.list = list;
    }

    public Introductiontoalgebra getAlgebra() {
        return algebra;
    }

    public void setAlgebra(Introductiontoalgebra algebra) {
        this.algebra = algebra;
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


    

    public List<Introductiontoalgebra> getAll() {
        list = service.getAll();
        return list;
    }

    public void addNewStudent() {   
        algebra.setStudentId(student.findStudent0000(idStudent));
        algebra.setCourseId(new Course0000(idCourse));
        service.create(algebra);
  
    }
   
    public IntroductiontoalgebraController() {
    }
    
}
