package hacs;

import org.junit.jupiter.api.Assertions;

class AssignmentOverDueTest {

    @org.junit.jupiter.api.Test
    void isOverDue() {
        Assignment assignment = new Assignment();
        Assertions.assertEquals (true, assignment.IsOverDue());
    }
}
