import hacs.Assignment;
import hacs.Course;
import hacs.Reminder;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course = new Course();

    @org.junit.jupiter.api.Test
    void AddAssignmentTest() {
        int expected = 1;
        Assignment assignment = new Assignment();
        course.addAssignment(assignment);
        assertEquals(expected, course.assignmentList.size());
    }

    @org.junit.jupiter.api.Test
    void ToStringTest() {
        String courseInStr = "";
        assertEquals(courseInStr, course.toString());
    }

    @org.junit.jupiter.api.Test
    void testAccept() {
        Reminder reminder = new Reminder();
        course.accept(new hacs.ReminderVisitor(reminder));
    }
}