import hacs.Course;
import hacs.CourseMenu;
import hacs.Facade;
import hacs.Instructor;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InstructorTest {

    Instructor instructor = new Instructor();

    @org.junit.jupiter.api.Test
    public void verifyLevelTest(){
        int studentLevel = 0;
        assertTrue(instructor.type == studentLevel);
    }

    @org.junit.jupiter.api.Test
    public void CreateCourseMenuTest(){
        Course course = new Course();
        Facade facade = new Facade();
        int level = facade.nCourseLevel;
        CourseMenu courseMenu = instructor.createCourseMenu(course, level);
        assert (courseMenu != null);
    }
}
