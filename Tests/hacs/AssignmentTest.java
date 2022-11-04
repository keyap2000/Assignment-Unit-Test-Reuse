package hacs;

import org.junit.jupiter.api.Assertions;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssignmentTest {

    Assignment assignment = new Assignment();

    @org.junit.jupiter.api.Test
    public void getSugSolutionTest()
    {
        Solution suggestedSolution;
        suggestedSolution = assignment.getSugSolution();
        assertTrue ((suggestedSolution.equals(assignment.suggestSolution)));
    }

    @org.junit.jupiter.api.Test
    public void getSugSolutionFailTest()
    {
        Solution suggestedSolution;
        suggestedSolution = assignment.getSugSolution();
        assertFalse ((suggestedSolution.equals(assignment.suggestSolution)));
    }

    @org.junit.jupiter.api.Test
    void isOverDue() {
        Assertions.assertEquals (true, assignment.isOverDue());
    }

    @org.junit.jupiter.api.Test
    public void GetSolutionIteratorTest() {
        SolutionList sl = new SolutionList();
        SolutionIterator s = new SolutionIterator(sl);
        assertFalse (s == assignment.getSolutionIterator());
    }

    @org.junit.jupiter.api.Test
    public void getDueDateStringTest() {
        Date date = new Date();
        assertTrue (date.equals(assignment.getDueDateString()));
    }

    @org.junit.jupiter.api.Test
    void ToStringTest() {
        String input = "Keya Patel";
        assignment.strAssignmentFilename = input ;
        assert(input.equals(assignment.toString()));
    }

    @org.junit.jupiter.api.Test
    public void AddSolutionTest() {
        SolutionList solutionList = new SolutionList();
        assertFalse (solutionList.contains(assignment.addSolution()));
    }

    @org.junit.jupiter.api.Test
    public void setDueDateTest()
    {
        Date date = new Date();
        assignment.setDueDate(date);
        assertTrue (date.equals(assignment.dueDate));
    }

    @org.junit.jupiter.api.Test
    public void SetAssSpecTest()
    {
        String assSpecification = "";
        assignment.setAssSpec(assSpecification);
        assert (assSpecification.equals(assignment.assSpec));
    }

    @org.junit.jupiter.api.Test
    public void AddAssignmentSolutionTest() {
        Assignment assignment = new Assignment();
        Solution solution = new Solution();
        SolutionList solutionList = new SolutionList();
        assignment.addSolution(solution);
        assertTrue (solutionList.contains(solution));
    }

    @org.junit.jupiter.api.Test
    public void getSolutionIteratorTest()
    {
        Assignment a = new Assignment();
        SolutionList solutionList = new SolutionList();
        SolutionIterator solutionIterator = new SolutionIterator(solutionList);
        assertTrue (solutionIterator == a.getSolutionIterator());
    }
}
