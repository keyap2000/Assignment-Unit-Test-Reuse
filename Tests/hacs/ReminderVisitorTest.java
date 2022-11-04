import hacs.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReminderVisitorTest {

    Reminder reminder = new Reminder();
    ReminderVisitor reminderVisitor = new ReminderVisitor(reminder);

    @org.junit.jupiter.api.Test
    void visitFacade() {
        Facade facade = new Facade();
        reminderVisitor.visitFacade(facade);
        //assertNotNull(reminderVisitor.visitFacade(facade));
    }

    @Test
    void visitCourse() {
        Course course = new Course();
        reminderVisitor.visitCourse(course);
    }

    @Test
    void visitAssignment() {
        Assignment assignment = new Assignment();
        reminderVisitor.visitAssignment(assignment);
    }
}
