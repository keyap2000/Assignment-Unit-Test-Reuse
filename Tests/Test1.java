import static org.junit.Assert.*;
import hacs.*;
import org.testng.annotations.Test;
import java.util.Date;

public class Test1 {

        @Test
        public void verifyLogin(){
            UserInfoItem u = new UserInfoItem();
            try {
                Facade f = new Facade();
                f.Login(u);
            }catch (Exception e){
                Throwable exception = assertThrows(RuntimeException.class, () -> hacs.Facade.Login(u));
                System.out.println("in catch");
                assertEquals("Invalid credentials", exception.getMessage());
            }
        }

        @Test
        public void AddAssignmentPassTest(){
            Date d = new Date(11/2/2022);
            Solution s = new Solution();

            Assignment a = new Assignment("1", d, s);
            Course c = new Course("CSE515", 1);
            c.AddAssignment(a);
        }
}