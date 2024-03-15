/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Identity;

import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import java.io.Serializable;
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
@Table(name = "doctor0000")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor0000.findAll", query = "SELECT d FROM Doctor0000 d")
    , @NamedQuery(name = "Doctor0000.findByDoctorId", query = "SELECT d FROM Doctor0000 d WHERE d.doctorId = :doctorId")
    , @NamedQuery(name = "Doctor0000.findByDoctorName", query = "SELECT d FROM Doctor0000 d WHERE d.doctorName = :doctorName")
    , @NamedQuery(name = "Doctor0000.findByDoctorEmail", query = "SELECT d FROM Doctor0000 d WHERE d.doctorEmail = :doctorEmail")
    , @NamedQuery(name = "Doctor0000.findByDoctorPassword", query = "SELECT d FROM Doctor0000 d WHERE d.doctorPassword = :doctorPassword")
    , @NamedQuery(name = "Doctor0000.findByDoctorCountry", query = "SELECT d FROM Doctor0000 d WHERE d.doctorCountry = :doctorCountry")
    , @NamedQuery(name = "Doctor0000.findByDoctorDateOfBirth", query = "SELECT d FROM Doctor0000 d WHERE d.doctorDateOfBirth = :doctorDateOfBirth")
    , @NamedQuery(name = "Doctor0000.findByDoctorSpecialization", query = "SELECT d FROM Doctor0000 d WHERE d.doctorSpecialization = :doctorSpecialization")})
public class Doctor0000 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctorId")
    private Integer doctorId;
    @Column(name = "doctorName")
    private String doctorName;
    @Column(name = "doctorEmail")
    private String doctorEmail;
    @Column(name = "doctorPassword")
    private String doctorPassword;
    @Column(name = "doctorCountry")
    private String doctorCountry;
    @Column(name = "doctorDateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date doctorDateOfBirth;
    @Column(name = "doctorSpecialization")
    private String doctorSpecialization;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000List;

    public Doctor0000() {
    }

    public Doctor0000(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorCountry() {
        return doctorCountry;
    }

    public void setDoctorCountry(String doctorCountry) {
        this.doctorCountry = doctorCountry;
    }

    public Date getDoctorDateOfBirth() {
        return doctorDateOfBirth;
    }

    public void setDoctorDateOfBirth(Date doctorDateOfBirth) {
        this.doctorDateOfBirth = doctorDateOfBirth;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    @XmlTransient
    public List<Assignedcoursestoteachers0000> getAssignedcoursestoteachers0000List() {
        return assignedcoursestoteachers0000List;
    }

    public void setAssignedcoursestoteachers0000List(List<Assignedcoursestoteachers0000> assignedcoursestoteachers0000List) {
        this.assignedcoursestoteachers0000List = assignedcoursestoteachers0000List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor0000)) {
            return false;
        }
        Doctor0000 other = (Doctor0000) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Doctor0000[ doctorId=" + doctorId + " ]";
    }
    
}
