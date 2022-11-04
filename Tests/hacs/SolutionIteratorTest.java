import hacs.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionIteratorTest {

    SolutionList solutionList = new SolutionList();
    SolutionIterator solutionIterator = new SolutionIterator(solutionList);

    @org.junit.jupiter.api.Test
    public void hasNextTest() {
        assertTrue (solutionIterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    public void nextTest() {
        assertTrue (solutionIterator.next() == null);
    }

    @org.junit.jupiter.api.Test
    public void removeTest() {
        assertThrows (IndexOutOfBoundsException.class,()-> solutionIterator.remove());
        //assertTrue (classCourseList.contains(currentCourseNumber));
    }

    @org.junit.jupiter.api.Test
    public void nextObjectTest() {
        String courseName = null;
        assertTrue (solutionIterator.next(courseName) == null);
    }

    @org.junit.jupiter.api.Test
    public void moveToHeadTest() {
        solutionIterator.moveToHead();
        assertTrue (solutionIterator.currentSolutionNumber == -1);
    }
}
