/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Courses.Introductiontoai;
import Entities.Identity.Student0000;
import Services.IntroductionToAiService;
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
@ManagedBean(name = "ai")
@ViewScoped
public class IntroductionToAiController   implements Serializable{
    
    
    private IntroductionToAiService service = new IntroductionToAiService();
    private List<Introductiontoai>list = new ArrayList();
    private Introductiontoai ai = new Introductiontoai();
    private Student0000Service student = new Student0000Service();
    private Integer id;
    private Course0000 courseId;
    private Student0000 studentId;
    private int idStudent;
    private int idCourse; 

    public IntroductionToAiService getService() {
        return service;
    }

    public void setService(IntroductionToAiService service) {
        this.service = service;
    }

    public List<Introductiontoai> getList() {
        return list;
    }

    public void setList(List<Introductiontoai> list) {
        this.list = list;
    }

    public Introductiontoai getAi() {
        return ai;
    }

    public void setAi(Introductiontoai ai) {
        this.ai = ai;
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
    
    
    public List<Introductiontoai> getAll() {
        list = service.getAll();
        return list;
    }

    public void addNewStudent() {   
        ai.setStudentId(student.findStudent0000(idStudent));
        ai.setCourseId(new Course0000(idCourse));
        service.create(ai);

    }

    public List<Student0000> getAllStudents() {
        return student.getAll();
    }
    
    
    
     public List<String> getStudentNamesInAICourse() {
        List<String> studentNames = new ArrayList<>();
        list = service.getAll();
        for (Introductiontoai enrollment : list) {
            if (enrollment.getCourseId().getCourseId() == 3) { // Assuming 3 is the AI course ID
                Student0000 student = enrollment.getStudentId();
                studentNames.add(student.getName());
            }
        }
        return studentNames;
    }

    public void submit() {
        System.out.println("Selected student: " + student);
        // Add your logic here for further processing
    }    
    
    
    

    public IntroductionToAiController() {
    }
    
}
