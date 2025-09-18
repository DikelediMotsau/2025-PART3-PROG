/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deede
 */

  import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    Login login = new Login();

    @Test
    public void testUsernameCorrectFormat() {
        assertTrue(login.checkUserName("kyel_1"));
    }

    @Test
    public void testPasswordComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCellPhoneFormat() {
        assertTrue(login.checkCellPhoneNumber("+27839869876"));
    }

    @Test
    public void testLoginSuccess() {
        login.registerUser("kyel_1", "Ch&&sec@ke99!", "+27839869876");
        assertTrue(login.loginUser("kyel_1", "Ch&&sec@ke99!"));
    }
}
  

