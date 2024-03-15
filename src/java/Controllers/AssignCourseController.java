/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Actions.Assigncourse;
import Entities.Courses.Course0000;
import Entities.Identity.Student0000;
import Services.AssignCouurseService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "assignCourse")
@RequestScoped
public class AssignCourseController {
    
    //MARK :: ATTRIBUTES    
    private AssignCouurseService service = new AssignCouurseService();
    private List<Assigncourse> list = new ArrayList<>();
    private Student0000 student = new Student0000();
    private Assigncourse course = new Assigncourse();
    private Integer id;
    private Course0000 courseId;
    private Student0000 studentId;
    private int idCourse;
    private int idStudent;

    
    
    //MARK :: SETTERS && GETTERS 
    public List<Assigncourse> getList() {
        return list;
    }
    public void setList(List<Assigncourse> list) {
        this.list = list;
    }
    public int getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }
    public int getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    public AssignCouurseService getService() {
        return service;
    }
    public void setService(AssignCouurseService service) {
        this.service = service;
    }
    public Assigncourse getCourse() {
        return course;
    }
    public void setCourse(Assigncourse course) {
        this.course = course;
    }
    public Student0000 getStudent() {
        return student;
    }
    public void setStudent(Student0000 student) {
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

    //MARK :: METHODS
    public List<Assigncourse> getAll() {
        list = service.getAll();
        return list;
    }
   
    public void create() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Course0000 course = new Course0000();
            course.setCourseId(idCourse);

            Student0000 student = new Student0000();
            student.setId(idStudent);

            this.course.setCourseId(course);
            this.course.setStudentId(student);

            service.create(this.course);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course added successfully"));
            this.course = new Assigncourse(); // Reset course object
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add course"));
        }
    }

    
    //MARK :: CONSTRACTORS
    public AssignCourseController() {
    }
    
}
