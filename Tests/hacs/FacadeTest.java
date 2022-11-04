import hacs.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {

    Facade facade = new Facade();

    @org.junit.jupiter.api.Test
    public void AddAssignmentTest()
    {
        Course course = new Course();
        assertThrows (NullPointerException.class,()-> facade.addAssignment(course));
    }

    @org.junit.jupiter.api.Test
    public void ViewAssignmentTest()
    {
        Assignment assignment = new Assignment();
        assertThrows (NullPointerException.class,()-> facade.viewAssignment(assignment));
    }

    @org.junit.jupiter.api.Test
    public void GradeSolutionTest()
    {
        Solution solution = new Solution();
        facade.gradeSolution(solution);
        //assert (solution.theGrade);
    }

    @org.junit.jupiter.api.Test
    public void ReportSolutionTest() {
        Solution solution = new Solution();
        Assignment assignment = new Assignment();
        facade.reportSolutions(assignment);
        assertTrue(solution.isReported());
    }

    @org.junit.jupiter.api.Test
    public void SubmitSolutionTest() {
        Solution solution = new Solution();
        Assignment assignment = new Assignment();
        facade.submitSolution(assignment, solution);
        SolutionList solutionList = new SolutionList();
        assertTrue (solutionList.contains(solution));
    }

    @org.junit.jupiter.api.Test
    public void CreateUserTest() {
        UserInfoItem userInfoItem = new UserInfoItem();
        facade.createUser(userInfoItem);
        Student student = new Student();
        Instructor instructor = new Instructor();
        assertTrue((student.userName) != null || (instructor.userName) != null);
    }

    @org.junit.jupiter.api.Test
    public void CreateCourseListTest() {
        //UserInfoItem userInfoItem = new UserInfoItem();
        assertThrows (IOException.class,()-> facade.createCourseList());
        ClassCourseList classCourseList = new ClassCourseList();
        assertNotNull(classCourseList != null);
    }

    @org.junit.jupiter.api.Test
    public void AttachCourseToUserTest() {
        assertThrows (IOException.class,()-> facade.attachCourseToUser());
    }

    @org.junit.jupiter.api.Test
    public void GetUserNameTest() {
        String string = "";
        assertThrows (IndexOutOfBoundsException.class,()-> facade.getUserName(string));
    }

    @org.junit.jupiter.api.Test
    public void GetCourseNameTest() {
        String string = "";
        assertTrue (facade.getCourseName(string) == "");
    }

    @org.junit.jupiter.api.Test
    public void SelectCourseTest(){
        assertThrows (NullPointerException.class,() -> facade.selectCourse());
    }

    @org.junit.jupiter.api.Test
    public void CourseOperationTest(){
        assertThrows (NullPointerException.class,() -> facade.courseOperation());
    }

    @org.junit.jupiter.api.Test
    public void findCourseTest() {
        String courseName = "";
        assertThrows (NullPointerException.class,() -> facade.findCourseByCourseName(courseName));
    }
}
