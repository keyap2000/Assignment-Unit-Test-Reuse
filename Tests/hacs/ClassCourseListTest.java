import hacs.ClassCourseList;
import hacs.Course;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {

    @org.junit.jupiter.api.Test
    public void InitializeFromFileTest() {
        String filename = "";
        ClassCourseList c = new ClassCourseList();
        assertThrows (IOException.class,()-> c.initializeFromFile(filename));
    }

    @org.junit.jupiter.api.Test
    public void findCourseTest() {
        ClassCourseList classCourseList = new ClassCourseList();
        String courseName = "";
        Course course = new Course();
        assertTrue (course == classCourseList.FindCourseByCourseName(courseName));
    }
}