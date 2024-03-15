package Configrations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "conf")
@RequestScoped
public class Configrations {
   //MARK :: Attributes
    private int cofigKey;
    
    
   //MARK :: SETTER && GETTER
    public int getCofigKey() {
        return cofigKey;
    }
    public void setCofigKey(int cofigKey) {
        this.cofigKey = cofigKey;
    }
    
    
    //MARK :: INDEX_HOME
    public void checkConfig() {
        switch (cofigKey) {
            case 0000:
                try {
                    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                    externalContext.redirect("ADMIN_HOME.xhtml"); // Replace "ADMIN_HOME.xhtml" with the actual file name you want to navigate to
                } catch (IOException e) {
            // Handle exception appropriately

                }       break;
            case 1111:
                try {
                    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                    externalContext.redirect("DOCTOR_HOME.xhtml"); // Replace "DOCTOR_HOME.xhtml" with the actual file name you want to navigate to
                } catch (IOException e) {
            // Handle exception appropriately

                }       break;
        // Handle other cases
            default:
                break;
        }
}

    
    
    //MARK :: ADMIN_HOME
    public void showAllCourses() {
    try {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("CourseList_admin.xhtml"); // Replace "other.xhtml" with the actual file name you want to navigate to
    } catch (IOException e) {
        e.printStackTrace(); // Handle exception appropriately
    }
    }  
    public void showAllTeachers() {
    try {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("DoctorList.xhtml"); // Replace "other.xhtml" with the actual file name you want to navigate to
    } catch (IOException e) {
        e.printStackTrace(); // Handle exception appropriately
    }
    } 
    public void showAllStudents() {
    try {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("StudentList.xhtml"); // Replace "StudentsTableList.xhtml" with the actual file name you want to navigate to
    } catch (IOException e) {
        // Handle exception appropriately
        
    }
}   
    public void showAllPersonalInformation() {
    try {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("AboutAdmin.xhtml"); // Replace "StudentsTableList.xhtml" with the actual file name you want to navigate to
    } catch (IOException e) {
        // Handle exception appropriately
        
    }
    
    
    
}
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void assignAICourse(){
    try {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("AI.xhtml"); // Replace "other.xhtml" with the actual file name you want to navigate to
    } catch (IOException e) {
        e.printStackTrace(); // Handle exception appropriately
    }
    } 
    
    
    public Configrations() {
    }
    
}
