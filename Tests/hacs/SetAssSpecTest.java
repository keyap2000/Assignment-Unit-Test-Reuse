class SetAssSpecTest {

    @org.junit.jupiter.api.Test
    public void SetAssSpecTest()
    {
        String assSpecification = "";
        hacs.Assignment assignment = new hacs.Assignment();
        assignment.SetAssSpec(assSpecification);
        assert (assSpecification.equals(assignment.assSpec));
    }
}
