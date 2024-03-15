package Entities.Identity;

import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
import Entities.Courses.Introductiontoai;
import Entities.Courses.Introductiontoalgebra;
import Entities.Courses.Introductiontonetwork;
import Entities.Courses.Introductiontopython;
import Entities.Courses.Introductiontosoftwareenginnering;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-13T09:38:43")
@StaticMetamodel(Student0000.class)
public class Student0000_ { 

    public static volatile SingularAttribute<Student0000, String> country;
    public static volatile ListAttribute<Student0000, Introductiontosoftwareenginnering> introductiontosoftwareenginneringList;
    public static volatile SingularAttribute<Student0000, Date> dateOfBirth;
    public static volatile ListAttribute<Student0000, Introductiontoalgebra> introductiontoalgebraList;
    public static volatile ListAttribute<Student0000, Introductiontonetwork> introductiontonetworkList;
    public static volatile SingularAttribute<Student0000, String> password;
    public static volatile ListAttribute<Student0000, Introductiontopython> introductiontopythonList;
    public static volatile SingularAttribute<Student0000, Double> balance;
    public static volatile ListAttribute<Student0000, Introductiontoai> introductiontoaiList;
    public static volatile SingularAttribute<Student0000, String> name;
    public static volatile SingularAttribute<Student0000, String> specialization;
    public static volatile SingularAttribute<Student0000, Integer> id;
    public static volatile ListAttribute<Student0000, Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999List;
    public static volatile SingularAttribute<Student0000, String> email;

}