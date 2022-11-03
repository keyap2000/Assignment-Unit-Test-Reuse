import hacs.Assignment;
import hacs.Solution;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GetSuggestedSolnFailTest {

    @Test
    public void getSugSolutionTest()
    {
        Solution suggestedSolution = new Solution();
        Assignment assignment = new Assignment();
        suggestedSolution = assignment.getSugSolution();
        assertFalse((suggestedSolution.equals(assignment.suggestSolution)));
    }

}