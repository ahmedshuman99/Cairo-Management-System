/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Courses.Course0000;
import Entities.Identity.Doctor0000;
import Repositories.exceptions.NonexistentEntityException;
import Services.Doctor0000Service;
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
@ManagedBean(name = "doctor")
@ViewScoped
public class Doctor0000Controller  implements Serializable{

    //MARK :: ATTRIBUTES
    private Doctor0000Service service = new Doctor0000Service();
    private List<Doctor0000>list = new ArrayList<>();
    private List<Course0000> course0000List = new ArrayList<>();
    private Doctor0000 doctor = new Doctor0000();
    private Doctor0000 searshDoctor = new Doctor0000();
    private Integer doctorId;
    private String doctorName;
    private String doctorEmail;
    private String doctorPassword;
    private String doctorCountry;
    private Date doctorDateOfBirth;
    private String doctorSpecialization;
    private Integer searchID;
    

    //MARK :: SETTERS && GETTERS
    public Doctor0000Service getService() {
        return service;
    }
    public void setService(Doctor0000Service service) {
        this.service = service;
    }
    public List<Doctor0000> getList() {
        return list;
    }
    public void setList(List<Doctor0000> list) {
        this.list = list;
    }
    public Doctor0000 getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor0000 doctor) {
        this.doctor = doctor;
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
    public List<Course0000> getCourse0000List() {
        return course0000List;
    }
    public void setCourse0000List(List<Course0000> course0000List) {
        this.course0000List = course0000List;
    }
    public Integer getSearchID() {
        return searchID;
    }
    public void setSearchID(Integer searchID) {
        this.searchID = searchID;
    }
    public Doctor0000 getSearshDoctor() {
        return searshDoctor;
    }
    public void setSearshDoctor(Doctor0000 searshDoctor) {
        this.searshDoctor = searshDoctor;
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
    public List<Doctor0000> getAll() {
        list = service.getAll();
        return list;
    }

    public void create() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            doctor.setDoctorName(doctorName);
            doctor.setDoctorEmail(doctorEmail);
            doctor.setDoctorPassword(doctorPassword);
            doctor.setDoctorCountry(doctorCountry);
            doctor.setDoctorDateOfBirth(doctorDateOfBirth);
            doctor.setDoctorSpecialization(doctorSpecialization);
            service.create(doctor);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course added successfully"));
            doctor = new Doctor0000(); // Reset course object
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add course"));
        }
    }

    public void delete(Doctor0000 doctor) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Call your service to delete the doctor
            service.delete(doctor);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Doctor deleted successfully"));
        } catch (NonexistentEntityException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to delete doctor"));
        }
    }

    public void edit() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Call your service to update the testInstance
            service.updateCourse(doctor);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Test updated successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update test"));
        }
    }

    public Doctor0000 searsh() {
        try {
            searshDoctor = service.FindByID(searshDoctor, searchID);
            if (searshDoctor != null) {

            } else {
                System.out.println("Student not found");
            }
        } catch (Exception e) {
            System.out.println("Error: Unexpected exception");
        }
        return searshDoctor;
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (doctorEmail == null || doctorEmail.isEmpty() || doctorPassword == null || doctorPassword.isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empty fields", "Please enter both email and password"));
            return null; // Stay on the same page
        }

        try {
            Doctor0000 user = service.getUserByEmailAndPassword(doctorEmail, doctorPassword);

            if (user != null) {
                // Authentication successful
                // Redirect the user to the home page or any other page
                return "DOCTOR_HOME?faces-redirect=true";
            } else {
                // Authentication failed
                // Display an error message
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", "Invalid email or password"));
                return null; // Stay on the same page
            }
        } catch (IllegalArgumentException e) {
            // Handle database query exceptions
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An error occurred during login"));
            // Log the exception for debugging
            return null; // Stay on the same page
        }
    }

    
    
    //MARK :: CONSTRACTORS
    public Doctor0000Controller() {
        service = new Doctor0000Service();
    }
    
}
