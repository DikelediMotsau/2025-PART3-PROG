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
    @Test
    public void testRegisterUserValid() {
        Login login = new Login();
        String result = login.registerUser("dikeledi", "password123", "+27834557896");
        assertEquals("User successfully registered.", result);
    }

    @Test
    public void testRegisterUserInvalidCell() {
        Login login = new Login();
        String result = login.registerUser("dikeledi", "password123", "0834557896");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code.", result);
    }

    @Test
    public void testLoginUserSuccess() {
        Login login = new Login();
        login.registerUser("dikeledi", "password123", "+27834557896");
        boolean success = login.loginUser("dikeledi", "password123");
        assertTrue(success);
    }

    @Test
    public void testLoginUserFailure() {
        Login login = new Login();
        login.registerUser("dikeledi", "password123", "+27834557896");
        boolean success = login.loginUser("wrongUser", "wrongPass");
        assertFalse(success);
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        String status = login.returnLoginStatus(true, "Dikeledi", "Mokoena");
        assertEquals("Welcome Dikeledi, Mokoena it is great to see you again!", status);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login();
        String status = login.returnLoginStatus(false, "", "");
        assertEquals("Username or password incorrect, please try again.", status);
    }
}
 