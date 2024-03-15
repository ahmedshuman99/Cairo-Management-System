/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Identity.Doctor0000;
import Services.Course0000Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "course")
@ViewScoped
public class Course0000Controller  implements Serializable {

    
    //MARK :: ATTRIBUTES
    private Course0000Service service = new Course0000Service();
    private List<Course0000>list = new ArrayList<>();
    private List<Doctor0000> doctor0000List = new ArrayList<>();
    private Course0000 course = new Course0000();
    private Course0000 SearshCourse = new Course0000();   
    private Integer courseId;
    private String courseName;
    private Double coursePrice;
    private Date courseStartTime;
    private Date courseEndTime;   
    private int searchID;
    

    
    //MARK :: SETTERS && GETTERS
    public int getSearchID() {
        return searchID;
    }
    public void setSearchID(int searchID) {
        this.searchID = searchID;
    }
    public Course0000 getSearshCourse() {
        return SearshCourse;
    }
    public void setSearshCourse(Course0000 SearshCourse) {
        this.SearshCourse = SearshCourse;
    }
    public Course0000Service getService() {
        return service;
    }
    public void setService(Course0000Service service) {
        this.service = service;
    }
    public List<Course0000> getList() {
        return list;
    }
    public void setList(List<Course0000> list) {
        this.list = list;
    }
    public Course0000 getCourse() {
        return course;
    }
    public void setCourse(Course0000 course) {
        this.course = course;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Double getCoursePrice() {
        return coursePrice;
    }
    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }
    public Date getCourseStartTime() {
        return courseStartTime;
    }
    public void setCourseStartTime(Date courseStartTime) {
        this.courseStartTime = courseStartTime;
    }
    public Date getCourseEndTime() {
        return courseEndTime;
    }
    public void setCourseEndTime(Date courseEndTime) {
        this.courseEndTime = courseEndTime;
    }
    public List<Doctor0000> getDoctor0000List() {
        return doctor0000List;
    }
    public void setDoctor0000List(List<Doctor0000> doctor0000List) {
        this.doctor0000List = doctor0000List;
    }

    
    
    //MARK :: METHODS
    public List<Course0000> getAll() {
        list = service.getAll();
        return list;
    }

    public void create() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            course.setCourseName(courseName);
            course.setCoursePrice(coursePrice);
            course.setCoursePrice(coursePrice);
            course.setCourseStartTime(courseStartTime);
            course.setCourseEndTime(courseEndTime);
            course.setCourseStartTime(courseStartTime);

            service.create(course);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course added successfully"));
            course = new Course0000(); // Reset course object
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add course"));
        }
    }

    public Course0000 searsh() {
        SearshCourse = service.FindByID(SearshCourse, searchID);
        return SearshCourse;
    }

    public void delete(Course0000 course) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Call your service to delete the course
            service.delete(course);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course deleted successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to delete course"));
        }
    }

    public void edit() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Call your service to update the testInstance
            service.updateCourse(course);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Test updated successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update test"));
        }
    }

    

    //MARK :: CONSTRACTORS
    public Course0000Controller() {
    }
    
}
