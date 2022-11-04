import hacs.ClassCourseList;
import hacs.Course;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {

    ClassCourseList classCourseList = new ClassCourseList();

    @org.junit.jupiter.api.Test
    public void InitializeFromFileTest() {
        String filename = "";
        assertThrows (IOException.class,()-> classCourseList.initializeFromFile(filename));
    }

    @org.junit.jupiter.api.Test
    public void findCourseTest() {
        String courseName = "";
        Course course = new Course();
        assertTrue (course == classCourseList.FindCourseByCourseName(courseName));
    }
}
