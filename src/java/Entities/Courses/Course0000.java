/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Courses;

import Entities.Courses.Actions.Assigncourse;
import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed
 */
@Entity
@Table(name = "course0000")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course0000.findAll", query = "SELECT c FROM Course0000 c")
    , @NamedQuery(name = "Course0000.findByCourseId", query = "SELECT c FROM Course0000 c WHERE c.courseId = :courseId")
    , @NamedQuery(name = "Course0000.findByCourseName", query = "SELECT c FROM Course0000 c WHERE c.courseName = :courseName")
    , @NamedQuery(name = "Course0000.findByCoursePrice", query = "SELECT c FROM Course0000 c WHERE c.coursePrice = :coursePrice")
    , @NamedQuery(name = "Course0000.findByCourseStartTime", query = "SELECT c FROM Course0000 c WHERE c.courseStartTime = :courseStartTime")
    , @NamedQuery(name = "Course0000.findByCourseEndTime", query = "SELECT c FROM Course0000 c WHERE c.courseEndTime = :courseEndTime")})
public class Course0000 implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<Assigncourse> assigncourseCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseId")
    private Integer courseId;
    @Column(name = "courseName")
    private String courseName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coursePrice")
    private Double coursePrice;
    @Column(name = "courseStartTime")
    @Temporal(TemporalType.DATE)
    private Date courseStartTime;
    @Column(name = "courseEndTime")
    @Temporal(TemporalType.DATE)
    private Date courseEndTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Introductiontoai> introductiontoaiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Introductiontonetwork> introductiontonetworkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Introductiontoalgebra> introductiontoalgebraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Introductiontopython> introductiontopythonList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringList;

    public Course0000() {
    }

    public Course0000(Integer courseId) {
        this.courseId = courseId;
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

    @XmlTransient
    public List<Introductiontoai> getIntroductiontoaiList() {
        return introductiontoaiList;
    }

    public void setIntroductiontoaiList(List<Introductiontoai> introductiontoaiList) {
        this.introductiontoaiList = introductiontoaiList;
    }

    @XmlTransient
    public List<Marksofintroductiontoaicourse9999> getMarksofintroductiontoaicourse9999List() {
        return marksofintroductiontoaicourse9999List;
    }

    public void setMarksofintroductiontoaicourse9999List(List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999List) {
        this.marksofintroductiontoaicourse9999List = marksofintroductiontoaicourse9999List;
    }

    @XmlTransient
    public List<Introductiontonetwork> getIntroductiontonetworkList() {
        return introductiontonetworkList;
    }

    public void setIntroductiontonetworkList(List<Introductiontonetwork> introductiontonetworkList) {
        this.introductiontonetworkList = introductiontonetworkList;
    }

    @XmlTransient
    public List<Introductiontoalgebra> getIntroductiontoalgebraList() {
        return introductiontoalgebraList;
    }

    public void setIntroductiontoalgebraList(List<Introductiontoalgebra> introductiontoalgebraList) {
        this.introductiontoalgebraList = introductiontoalgebraList;
    }

    @XmlTransient
    public List<Introductiontopython> getIntroductiontopythonList() {
        return introductiontopythonList;
    }

    public void setIntroductiontopythonList(List<Introductiontopython> introductiontopythonList) {
        this.introductiontopythonList = introductiontopythonList;
    }

    @XmlTransient
    public List<Assignedcoursestoteachers0000> getAssignedcoursestoteachers0000List() {
        return assignedcoursestoteachers0000List;
    }

    public void setAssignedcoursestoteachers0000List(List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000List) {
        this.assignedcoursestoteachers0000List = assignedcoursestoteachers0000List;
    }

    @XmlTransient
    public List<Introductiontosoftwareenginnering> getIntroductiontosoftwareenginneringList() {
        return introductiontosoftwareenginneringList;
    }

    public void setIntroductiontosoftwareenginneringList(List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringList) {
        this.introductiontosoftwareenginneringList = introductiontosoftwareenginneringList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course0000)) {
            return false;
        }
        Course0000 other = (Course0000) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Course0000[ courseId=" + courseId + " ]";
    }

    @XmlTransient
    public Collection<Assigncourse> getAssigncourseCollection() {
        return assigncourseCollection;
    }

    public void setAssigncourseCollection(Collection<Assigncourse> assigncourseCollection) {
        this.assigncourseCollection = assigncourseCollection;
    }
    
}
