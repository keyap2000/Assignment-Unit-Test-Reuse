import hacs.Solution;
import org.junit.jupiter.api.Test;

class GetGradesOfSolutionTest {

    @Test
    public void GetGrades(){
        Solution s = new Solution();
        int grades = s.getGradeInt();
        assert (grades == s.theGrade);
    }
}
