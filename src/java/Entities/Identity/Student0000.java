/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Identity;

import Entities.Courses.Introductiontopython;
import Entities.Courses.Introductiontosoftwareenginnering;
import Entities.Courses.Introductiontonetwork;
import Entities.Courses.Introductiontoalgebra;
import Entities.Courses.Introductiontoai;
import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
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
@Table(name = "student0000")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student0000.findAll", query = "SELECT s FROM Student0000 s")
    , @NamedQuery(name = "Student0000.findById", query = "SELECT s FROM Student0000 s WHERE s.id = :id")
    , @NamedQuery(name = "Student0000.findByName", query = "SELECT s FROM Student0000 s WHERE s.name = :name")
    , @NamedQuery(name = "Student0000.findByEmail", query = "SELECT s FROM Student0000 s WHERE s.email = :email")
    , @NamedQuery(name = "Student0000.findByPassword", query = "SELECT s FROM Student0000 s WHERE s.password = :password")
    , @NamedQuery(name = "Student0000.findByDateOfBirth", query = "SELECT s FROM Student0000 s WHERE s.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Student0000.findByCountry", query = "SELECT s FROM Student0000 s WHERE s.country = :country")
    , @NamedQuery(name = "Student0000.findByBalance", query = "SELECT s FROM Student0000 s WHERE s.balance = :balance")
    , @NamedQuery(name = "Student0000.findBySpecialization", query = "SELECT s FROM Student0000 s WHERE s.specialization = :specialization")})
public class Student0000 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "Country")
    private String country;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Balance")
    private Double balance;
    @Column(name = "Specialization")
    private String specialization;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Introductiontoai> introductiontoaiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Introductiontonetwork> introductiontonetworkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Introductiontoalgebra> introductiontoalgebraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Introductiontopython> introductiontopythonList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringList;

    public Student0000() {
    }

    public Student0000(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
    public List<Introductiontosoftwareenginnering> getIntroductiontosoftwareenginneringList() {
        return introductiontosoftwareenginneringList;
    }

    public void setIntroductiontosoftwareenginneringList(List<Introductiontosoftwareenginnering> introductiontosoftwareenginneringList) {
        this.introductiontosoftwareenginneringList = introductiontosoftwareenginneringList;
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
        if (!(object instanceof Student0000)) {
            return false;
        }
        Student0000 other = (Student0000) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Student0000[ id=" + id + " ]";
    }
    
}
