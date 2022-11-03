package hacs;

class AddAssignmentTest {

    @org.junit.jupiter.api.Test
    public void AddAssignmentPassTest(){
        Assignment a = new Assignment();
        Course c = new Course();
        c.AddAssignment(a);
        assert(c.assignmentList.contains(a));
    }
}