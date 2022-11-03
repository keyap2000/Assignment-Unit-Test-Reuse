import hacs.Assignment;
import hacs.Solution;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SolutionReportedTest {

    @org.junit.jupiter.api.Test
    public void setReportedTest()
    {
        boolean reported = false;
        Solution s = new Solution();
        s.setReported(reported);
        assertTrue (reported == s.reported);
    }
}
