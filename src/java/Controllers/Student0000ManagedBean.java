/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Configrations.Configrations;
import Entities.Courses.Course0000;
import Entities.Identity.Student0000;
import Repositories.exceptions.NonexistentEntityException;
import Services.Student0000Service;
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
@ManagedBean(name = "student")
@ViewScoped
public class Student0000ManagedBean   implements Serializable{

    //MARK :: ATTRIBUTES
    private Student0000Service service = new Student0000Service();
    private List<Student0000>list = new ArrayList<>();
    private Student0000 student = new Student0000 ();
    private Student0000 searshStudent = new Student0000();
    private Student0000 selectedStudent = new Student0000();
    private Configrations conf = new Configrations();
    private Course0000 course = new Course0000(); 
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String country;
    private Double balance;
    private String specialization;   
    private int searchID;
    private int courseId;
    private double mountPrice = 100.0;


    
    //MARK :: SETTERSS && GETTERS
    public Student0000Service getService() {
        return service;
    }
    public void setService(Student0000Service service) {
        this.service = service;
    }
    public double getMountPrice() {
        return mountPrice;
    }
    public void setMountPrice(double mountPrice) {
        this.mountPrice = mountPrice;
    }
    public List<Student0000> getList() {
        return list;
    }
    public void setList(List<Student0000> list) {
        this.list = list;
    }
    public Student0000 getStudent() {
        return student;
    }
    public void setStudent(Student0000 student) {
        this.student = student;
    }
    public Course0000 getCourse() {
        return course;
    }
    public void setCourse(Course0000 course) {
        this.course = course;
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
    public Student0000 getSearshStudent() {
        return searshStudent;
    }
    public void setSearshStudent(Student0000 searshStudent) {
        this.searshStudent = searshStudent;
    }
    public int getSearchID() {
        return searchID;
    }
    public void setSearchID(int searchID) {
        this.searchID = searchID;
    }
    public Student0000 getSelectedStudent() {
        return selectedStudent;
    }
    public void setSelectedStudent(Student0000 selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public Configrations getConf() {
        return conf;
    }
    public void setConf(Configrations conf) {
        this.conf = conf;
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
    public List<Student0000> getAll() {
        list = service.getAll();
        return list;
    }

    public void create() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            student.setName(name);
            student.setEmail(email);
            student.setPassword(password);
            student.setBalance(balance);
            student.setCountry(country);
            student.setDateOfBirth(dateOfBirth);
            student.setSpecialization(specialization);
            service.create(student);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course added successfully"));
            student = new Student0000(); // Reset course object     
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add course"));
        }
    }

    public void edit() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Call your service to update the student
            service.updateStudentActive(selectedStudent);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Student updated successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update student"));
        }
    }

    public void delete(Student0000 student) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Call your service to delete the course
            service.delete(student);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course deleted successfully"));
        } catch (NonexistentEntityException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to delete course"));
        }
    }

    public Student0000 searsh() {
        try {
            searshStudent = service.FindByID(searshStudent, searchID);

        } catch (Exception e) {
            System.out.println("Error: Unexpected exception");
        }
        return searshStudent;
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (email.isEmpty() || password.isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empty fields", "Please enter both email and password"));
            return null; // Stay on the same page
        }
        try {
            Student0000 user = service.getUserByEmailAndPassword(email, password);
            if (user != null) {
                return "STUDENT_HOME?faces-redirect=true";
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", "Invalid email or password"));
                return null;
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An error occurred during login"));
            return null;
        }
    }


    //MARK :: METHODS
    public Student0000ManagedBean() {
    }

    
    //__________________________________________________________________________
    // methods processing
    public void updateBalance(double amount) {
    FacesContext context = FacesContext.getCurrentInstance();
    try {
        double newBalance = searshStudent.getBalance() + amount;
        service.updateBalance(newBalance, searshStudent);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Balance updated successfully"));
    } catch (Exception e) {
        e.printStackTrace();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update balance"));
    }   
    }
     
}