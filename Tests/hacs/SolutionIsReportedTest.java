import hacs.Solution;

import static org.junit.jupiter.api.Assertions.*;

class SolutionIsReportedTest {
    @org.junit.jupiter.api.Test
    public void isReportedTest()
    {
        boolean isReported = false;
        Solution s = new Solution();
        assert (isReported == s.isReported());
    }
}
