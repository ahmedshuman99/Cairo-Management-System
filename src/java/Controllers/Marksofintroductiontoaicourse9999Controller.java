/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Identity.Doctor0000;
import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
import Entities.Identity.Student0000;
import Services.Assignedcoursestoteachers0000Service;
import Services.Course0000Service;
import Services.Doctor0000Service;
import Services.Marksofintroductiontoaicourse9999Service;
import Services.Student0000Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "markOfAi")
@ViewScoped
public class Marksofintroductiontoaicourse9999Controller  implements Serializable{

    private Marksofintroductiontoaicourse9999Service service = new Marksofintroductiontoaicourse9999Service();
    private List<Marksofintroductiontoaicourse9999>list = new ArrayList();
    private Marksofintroductiontoaicourse9999 markOfAi = new Marksofintroductiontoaicourse9999();
    private Student0000Service student = new Student0000Service();
    private List<Course0000> course = new ArrayList();
    private Doctor0000Service serviceDoctor = new Doctor0000Service();
    private Assignedcoursestoteachers0000Service assign = new Assignedcoursestoteachers0000Service();
    private Course0000Service so = new Course0000Service();
  
    
    private Integer id;
    private Course0000 courseId;
    private Student0000 studentId;
    private Doctor0000 doctorID;
    private int doctorId;
    private int mark;
    private int idStudent;
    private final int idCourse = 3;
        private List<Object[]> coursesByDoctorId = new ArrayList<>();
    
    
    

    public Doctor0000Service getServiceDoctor() {
        return serviceDoctor;
    }

    public void setServiceDoctor(Doctor0000Service serviceDoctor) {
        this.serviceDoctor = serviceDoctor;
    }

    public List<Object[]> getCoursesByDoctorId() {
        return coursesByDoctorId;
    }

    public void setCoursesByDoctorId(List<Object[]> coursesByDoctorId) {
        this.coursesByDoctorId = coursesByDoctorId;
    }
    

    public Course0000Service getSo() {
        return so;
    }

    public void setSo(Course0000Service so) {
        this.so = so;
    }
    
    

    public List<Course0000> getCourse() {
        return course;
    }

    public Doctor0000 getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Doctor0000 doctorID) {
        this.doctorID = doctorID;
    }

   

    

    public Assignedcoursestoteachers0000Service getAssign() {
        return assign;
    }

    public void setAssign(Assignedcoursestoteachers0000Service assign) {
        this.assign = assign;
    }

 
    

    
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    
    

    public void setCourse(List<Course0000> course) {
        this.course = course;
    }


    public Marksofintroductiontoaicourse9999Service getService() {
        return service;
    }

    public void setService(Marksofintroductiontoaicourse9999Service service) {
        this.service = service;
    }

    
    public List<Marksofintroductiontoaicourse9999> getList() {
        return list;
    }

    public void setList(List<Marksofintroductiontoaicourse9999> list) {
        this.list = list;
    }

    public Marksofintroductiontoaicourse9999 getMarkOfAi() {
        return markOfAi;
    }

    public void setMarkOfAi(Marksofintroductiontoaicourse9999 markOfAi) {
        this.markOfAi = markOfAi;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    
    
    
    public List<Marksofintroductiontoaicourse9999>getAll(){
    list = service.getAll();
    return list;
    
    }
    
     public void create() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {  
            markOfAi.setId(id);
            markOfAi.setCourseId(new Course0000(idCourse));
            markOfAi.setStudentId(studentId);
            service.create(markOfAi);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course added successfully"));
            markOfAi = new Marksofintroductiontoaicourse9999(); // Reset course object
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add course"));
        }
    }
  
    
    

   public void searchCoursesByDoctorId() {
        coursesByDoctorId = service.getCoursesByDoctorId(doctorId);
    }
       
       
    
    public Marksofintroductiontoaicourse9999Controller() {
    }
    
}
