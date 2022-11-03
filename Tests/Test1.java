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
}