/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Identity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed
 */
@Entity
@Table(name = "admin0000")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin0000.findAll", query = "SELECT a FROM Admin0000 a")
    , @NamedQuery(name = "Admin0000.findById", query = "SELECT a FROM Admin0000 a WHERE a.id = :id")
    , @NamedQuery(name = "Admin0000.findByName", query = "SELECT a FROM Admin0000 a WHERE a.name = :name")
    , @NamedQuery(name = "Admin0000.findByEmail", query = "SELECT a FROM Admin0000 a WHERE a.email = :email")
    , @NamedQuery(name = "Admin0000.findByPassword", query = "SELECT a FROM Admin0000 a WHERE a.password = :password")
    , @NamedQuery(name = "Admin0000.findByDateOfBirth", query = "SELECT a FROM Admin0000 a WHERE a.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Admin0000.findByCountry", query = "SELECT a FROM Admin0000 a WHERE a.country = :country")})
public class Admin0000 implements Serializable {

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

    public Admin0000() {
    }

    public Admin0000(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin0000)) {
            return false;
        }
        Admin0000 other = (Admin0000) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Admin0000[ id=" + id + " ]";
    }
    
}
