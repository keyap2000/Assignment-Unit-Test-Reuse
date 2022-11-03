import hacs.Assignment;
import hacs.SolutionIterator;
import hacs.SolutionList;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentGetSolutionIteratorTest {

    @org.junit.jupiter.api.Test
    public void GetSolutionIteratorTest() {
        Assignment a = new Assignment();
        SolutionList sl = new SolutionList();
        SolutionIterator s = new SolutionIterator(sl);
        assertTrue (s == a.GetSolutionIterator());
    }
}