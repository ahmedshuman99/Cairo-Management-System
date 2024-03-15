/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Courses.Actions;

import Entities.Courses.Course0000;
import Entities.Identity.Student0000;
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
@Table(name = "marksofintroductiontoaicourse9999")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marksofintroductiontoaicourse9999.findAll", query = "SELECT m FROM Marksofintroductiontoaicourse9999 m")
    , @NamedQuery(name = "Marksofintroductiontoaicourse9999.findById", query = "SELECT m FROM Marksofintroductiontoaicourse9999 m WHERE m.id = :id")
    , @NamedQuery(name = "Marksofintroductiontoaicourse9999.findByMarks", query = "SELECT m FROM Marksofintroductiontoaicourse9999 m WHERE m.marks = :marks")})
public class Marksofintroductiontoaicourse9999 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "marks")
    private int marks;
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Course0000 courseId;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Student0000 studentId;

    public Marksofintroductiontoaicourse9999() {
    }

    public Marksofintroductiontoaicourse9999(Integer id) {
        this.id = id;
    }

    public Marksofintroductiontoaicourse9999(Integer id, int marks) {
        this.id = id;
        this.marks = marks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marksofintroductiontoaicourse9999)) {
            return false;
        }
        Marksofintroductiontoaicourse9999 other = (Marksofintroductiontoaicourse9999) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Marksofintroductiontoaicourse9999[ id=" + id + " ]";
    }
    
}
