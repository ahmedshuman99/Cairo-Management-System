/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Courses.Actions;

import Entities.Courses.Course0000;
import Entities.Identity.Doctor0000;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed
 */
@Entity
@Table(name = "assignedcoursestoteachers0000")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignedcoursestoteachers0000.findAll", query = "SELECT a FROM Assignedcoursestoteachers0000 a")
    , @NamedQuery(name = "Assignedcoursestoteachers0000.findByCourseassignedId", query = "SELECT a FROM Assignedcoursestoteachers0000 a WHERE a.courseassignedId = :courseassignedId")})
public class Assignedcoursestoteachers0000 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseassignedId")
    private Integer courseassignedId;
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Course0000 courseId;
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doctor0000 doctorId;

    public Assignedcoursestoteachers0000() {
    }

    public Assignedcoursestoteachers0000(Integer courseassignedId) {
        this.courseassignedId = courseassignedId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseassignedId != null ? courseassignedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignedcoursestoteachers0000)) {
            return false;
        }
        Assignedcoursestoteachers0000 other = (Assignedcoursestoteachers0000) object;
        if ((this.courseassignedId == null && other.courseassignedId != null) || (this.courseassignedId != null && !this.courseassignedId.equals(other.courseassignedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Assignedcoursestoteachers0000[ courseassignedId=" + courseassignedId + " ]";
    }
    
}
