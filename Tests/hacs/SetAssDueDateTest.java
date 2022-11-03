import hacs.Assignment;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class SetAssDueDateTest {

    @org.junit.jupiter.api.Test
    public void setDueDatePassTest()
    {
        Date date = new Date();
        Assignment assignment = new Assignment();
        assignment.SetDueDate(date);
        assertTrue(date.equals(assignment.dueDate));
    }

}