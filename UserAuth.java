/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deede
 */
import java.util.Scanner;
 public class UserAuth {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number: ");
        String cellPhone = scanner.nextLine();

        String registrationMessage = login.registerUser(username, password, cellPhone);
        System.out.println(registrationMessage);

        if (registrationMessage.equals("User successfully registered.")) {
            System.out.print("Login - Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Login - Enter password: ");
            String loginPassword = scanner.nextLine();

            boolean success = login.loginUser(loginUsername, loginPassword);
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();

            System.out.println(login.returnLoginStatus(success, firstName, lastName));
        }
    }
}
  

