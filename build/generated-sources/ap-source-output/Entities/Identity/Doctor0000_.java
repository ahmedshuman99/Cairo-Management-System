package Entities.Identity;

import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-13T09:38:43")
@StaticMetamodel(Doctor0000.class)
public class Doctor0000_ { 

    public static volatile SingularAttribute<Doctor0000, String> doctorName;
    public static volatile SingularAttribute<Doctor0000, Date> doctorDateOfBirth;
    public static volatile SingularAttribute<Doctor0000, String> doctorSpecialization;
    public static volatile SingularAttribute<Doctor0000, Integer> doctorId;
    public static volatile SingularAttribute<Doctor0000, String> doctorEmail;
    public static volatile SingularAttribute<Doctor0000, String> doctorPassword;
    public static volatile SingularAttribute<Doctor0000, String> doctorCountry;
    public static volatile ListAttribute<Doctor0000, Assignedcoursestoteachers0000> assignedcoursestoteachers0000List;

}