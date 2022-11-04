import hacs.ClassCourseList;
import hacs.CourseIterator;

import static org.junit.jupiter.api.Assertions.*;

class CourseIteratorTest {

    ClassCourseList classCourseList = new ClassCourseList();
    CourseIterator courseIterator = new CourseIterator(classCourseList);

    @org.junit.jupiter.api.Test
    public void hasNextTest() {
        assertTrue (courseIterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    public void nextTest() {
        assertTrue (courseIterator.next() == null);
    }

    @org.junit.jupiter.api.Test
    public void removeTest() {
        assertThrows (IndexOutOfBoundsException.class,()-> courseIterator.remove());
        //assertTrue (classCourseList.contains(currentCourseNumber));
    }

    @org.junit.jupiter.api.Test
    public void nextObjectTest() {
        String courseName = null;
        assertTrue (courseIterator.next(courseName) == null);
    }
}
