package hacs;

import static org.junit.jupiter.api.Assertions.*;

class CreateCourseMenuTest {

    @org.junit.jupiter.api.Test
    public void CreateCourseMenuTest(){
        Course c = new Course();
        Facade f = new Facade();
        int level = f.nCourseLevel;
        Instructor i = new Instructor();
        CourseMenu cm = i.CreateCourseMenu(c, level);
        assert (cm!=null);
    }
}
