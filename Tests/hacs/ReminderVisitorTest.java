import hacs.Facade;
import hacs.Reminder;
import hacs.ReminderVisitor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReminderVisitorTest {

    Reminder reminder = new Reminder();
    ReminderVisitor reminderVisitor = new ReminderVisitor(reminder);

    @org.junit.jupiter.api.Test
    void visitFacade() {
        Facade facade = new Facade();
        //assertNotNull(reminderVisitor.visitFacade(facade));
    }

    @Test
    void visitCourse() {
    }

    @Test
    void visitAssignment() {
    }
}