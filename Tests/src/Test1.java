import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
//import Facade;

public class Test1 {
        @Test
        public void test_JUnit() {
            System.out.println("This is the testcase in this class");
            String str1="This is the testcase in this class";
            assertEquals("This is the testcase in this class", str1);
        }

        @Test
        public void verifyLogin(){
            //Facade f = new Facade();
        }
    }