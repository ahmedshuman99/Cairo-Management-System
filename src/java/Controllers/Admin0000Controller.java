/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Identity.Admin0000;
import Services.Admin0000Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
@ManagedBean(name = "admin")
@ViewScoped
public class Admin0000Controller  implements Serializable{

    //MARK :: ATTRIBUTES 
    private Admin0000Service service = new Admin0000Service();
    private List<Admin0000>list = new ArrayList<>();
    private Admin0000 admin = new Admin0000 ();
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String country;
    
    
    
    //MARK :: SETTERS && GETTERS 
    public Admin0000Service getService() {
        return service;
    }
    public void setService(Admin0000Service service) {
        this.service = service;
    }
    public List<Admin0000> getList() {
        return list;
    }
    public void setList(List<Admin0000> list) {
        this.list = list;
    }
    public Admin0000 getAdmin() {
        return admin;
    }
    public void setAdmin(Admin0000 admin) {
        this.admin = admin;
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
    public List<String> getCountries() {
        List<String> countries = new ArrayList<>(Arrays.asList(
                "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda",
                "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain",
                "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia",
                "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso",
                "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic",
                "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Costa Rica", "Croatia",
                "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
                "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
                "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany",
                "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
                "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel",
                "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
                "Korea, North", "Korea, South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon",
                "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar",
                "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius",
                "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique",
                "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger",
                "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama",
                "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania",
                "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines",
                "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
                "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
                "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria",
                "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia",
                "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom",
                "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam",
                "Yemen", "Zambia", "Zimbabwe"
        ));
        return countries;
    }

    
    
    
    //MARK :: METHODS
    public List<Admin0000> getAll() {
        list = service.getAll();
        return list;
    }
   
    public void create() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            admin.setName(name);
            admin.setEmail(email);
            admin.setPassword(password);
            admin.setCountry(country);
            admin.setDateOfBirth(dateOfBirth);
            service.create(admin);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course added successfully"));
            admin = new Admin0000(); // Reset course object
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add course"));
        }
    }
    
    public void delete(Admin0000 admin) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Call your service to delete the course
            service.delete(admin);
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
            service.updateCourse(admin);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Test updated successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update test"));
        }
    }
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empty fields", "Please enter both email and password"));
            return null; // Stay on the same page
        }

        try {
            Admin0000 user = service.authenticate(email, password);

            if (user != null) {
                // Authentication successful
                // Redirect the user to the home page or any other page
                return "ADMIN_HOME?faces-redirect=true";
            } else {
                // Authentication failed
                // Display an error message
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", "Invalid email or password"));
                return null; // Stay on the same page
            }
        } catch (Exception e) {
            // Handle database query exceptions
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An error occurred during login"));
            // Log the exception for debugging
            return null; // Stay on the same page
        }
    }



    //MARK :: CONSTRACTORS 
    public Admin0000Controller() {
    }
}
