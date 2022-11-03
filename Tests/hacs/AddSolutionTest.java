import hacs.Assignment;
import hacs.Solution;
import hacs.SolutionList;

import static org.junit.jupiter.api.Assertions.*;

class AddSolutionTest {

    @org.junit.jupiter.api.Test
    public void AddSolutionTest() {
        Assignment a = new Assignment();
        Solution s = new Solution();
        SolutionList sl = new SolutionList();
        assertFalse (sl.contains(a.AddSolution()));
    }

}