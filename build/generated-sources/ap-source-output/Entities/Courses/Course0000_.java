package Entities.Courses;

import Entities.Courses.Actions.Assigncourse;
import Entities.Courses.Actions.Assignedcoursestoteachers0000;
import Entities.Courses.Actions.Marksofintroductiontoaicourse9999;
import Entities.Courses.Introductiontoai;
import Entities.Courses.Introductiontoalgebra;
import Entities.Courses.Introductiontonetwork;
import Entities.Courses.Introductiontopython;
import Entities.Courses.Introductiontosoftwareenginnering;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-13T09:38:43")
@StaticMetamodel(Course0000.class)
public class Course0000_ { 

    public static volatile SingularAttribute<Course0000, Date> courseEndTime;
    public static volatile ListAttribute<Course0000, Introductiontosoftwareenginnering> introductiontosoftwareenginneringList;
    public static volatile ListAttribute<Course0000, Assignedcoursestoteachers0000> assignedcoursestoteachers0000List;
    public static volatile SingularAttribute<Course0000, Date> courseStartTime;
    public static volatile ListAttribute<Course0000, Introductiontoalgebra> introductiontoalgebraList;
    public static volatile CollectionAttribute<Course0000, Assigncourse> assigncourseCollection;
    public static volatile ListAttribute<Course0000, Introductiontonetwork> introductiontonetworkList;
    public static volatile SingularAttribute<Course0000, String> courseName;
    public static volatile ListAttribute<Course0000, Introductiontopython> introductiontopythonList;
    public static volatile SingularAttribute<Course0000, Double> coursePrice;
    public static volatile ListAttribute<Course0000, Introductiontoai> introductiontoaiList;
    public static volatile ListAttribute<Course0000, Marksofintroductiontoaicourse9999> marksofintroductiontoaicourse9999List;
    public static volatile SingularAttribute<Course0000, Integer> courseId;

}