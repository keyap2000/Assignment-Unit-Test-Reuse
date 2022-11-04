import hacs.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student = new Student();

    @org.junit.jupiter.api.Test
    public void verifyLevelTest(){
        int studentLevel = 0;
        assertTrue(student.type == studentLevel);
    }

    @org.junit.jupiter.api.Test
    public void CreateCourseMenuTest(){
        Course course = new Course();
        Facade facade = new Facade();
        int level = facade.nCourseLevel;
        CourseMenu cm = student.CreateCourseMenu(course, level);
        assert (cm!=null);
    }
}