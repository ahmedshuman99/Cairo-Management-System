package Entities.Courses.Actions;

import Entities.Courses.Course0000;
import Entities.Identity.Student0000;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-13T09:38:43")
@StaticMetamodel(Assigncourse.class)
public class Assigncourse_ { 

    public static volatile SingularAttribute<Assigncourse, Student0000> studentId;
    public static volatile SingularAttribute<Assigncourse, Integer> id;
    public static volatile SingularAttribute<Assigncourse, Course0000> courseId;

}