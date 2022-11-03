package hacs;
import static org.junit.jupiter.api.Assertions.*;


class GetSuggestedSolnTest {

    @org.junit.jupiter.api.Test
    public void getSugSolutionTest()
    {
        Solution suggestedSolution = new Solution();
        Assignment assignment = new Assignment();
        suggestedSolution = assignment.getSugSolution();
        assertTrue ((suggestedSolution.equals(assignment.suggestSolution)));
    }
}
