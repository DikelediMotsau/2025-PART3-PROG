/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deede
 */
public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCell;

    public String registerUser(String username, String password, String cell) {
        if (!cell.matches("^\\+\\d{1,3}\\d{7,10}$")) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        registeredUsername = username;
        registeredPassword = password;
        registeredCell = cell;
        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    public String returnLoginStatus(boolean success, String firstName, String lastName) {
        if (success) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again!";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
