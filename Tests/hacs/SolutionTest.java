import hacs.Solution;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @org.junit.jupiter.api.Test
    public void GetGrades(){
        Solution s = new Solution();
        int grades = s.getGradeInt();
        assert (grades == s.theGrade);
    }

    @org.junit.jupiter.api.Test
    public void GetGradesString(){
        Solution s = new Solution();
        String grades = s.getGradeString();
        assertTrue (grades.equals(s.theGrade));
    }

    @org.junit.jupiter.api.Test
    public void isReportedTest()
    {
        boolean isReported = false;
        Solution s = new Solution();
        assert (isReported == s.isReported());
    }

    @org.junit.jupiter.api.Test
    public void setReportedTest()
    {
        boolean reported = false;
        Solution s = new Solution();
        s.setReported(reported);
        assertTrue (reported == s.reported);
    }
}
