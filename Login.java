/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deede
 */
public class Login {
    private String username;
    private String password;
    private String cellPhone;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() > 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    public boolean checkCellPhoneNumber(String cellPhone) {
        return cellPhone.matches("^\\+\\d{1,3}\\d{7,10}$");
    }

    public String registerUser(String username, String password, String cellPhone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(boolean success, String firstName, String lastName) {
        return success ? "Welcome " + firstName + ", " + lastName + " it is great to see you again!" :
                "Username or password incorrect, please try again.";
    }
}
   

