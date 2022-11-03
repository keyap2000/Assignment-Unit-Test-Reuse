import hacs.ClassCourseList;
import hacs.Course;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {

    String filename = "";
    @org.junit.jupiter.api.Test
    public void InitializeFromFileTest() {
        ClassCourseList c = new ClassCourseList();
        assertThrows (IOException.class,()-> c.InitializeFromFile(filename));
    }
}