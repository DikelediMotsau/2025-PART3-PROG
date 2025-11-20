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
        Message messageObj = new Message();

        System.out.println("Welcome to QuickChat!");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number: ");
        String cell = scanner.nextLine();

        String registrationMessage = login.registerUser(username, password, cell);
        System.out.println(registrationMessage);

        if (registrationMessage.equals("User successfully registered.")) {
            System.out.print("Login - Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Login - Enter password: ");
            String loginPassword = scanner.nextLine();

            boolean success = login.loginUser(loginUsername, loginPassword);

            if (success) {
                System.out.println("Login successful!");

                System.out.print("Enter your first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter your last name: ");
                String lastName = scanner.nextLine();

                System.out.println(login.returnLoginStatus(true, firstName, lastName));

                System.out.print("How many messages would you like to send? ");
                int count = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < count; i++) {
                    System.out.print("Enter recipient number: ");
                    String recipient = scanner.nextLine();

                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();

                    System.out.print("Enter message flag (sent/stored/disregard): ");
                    String flag = scanner.nextLine().toLowerCase();

                    String result = messageObj.sendMessage(recipient, message, flag);
                    System.out.println(result);

                    if (!result.equals("Invalid flag.")) {
                        System.out.println("\n-- Message Details ---");
                        System.out.println(messageObj.printMessage());
                        System.out.println("Total messages sent: " + messageObj.returnTotalMessages());
                    }
                }

                System.out.println("\nWould you like to see a full message report? (yes/no)");
                String showReport = scanner.nextLine().toLowerCase();
                if (showReport.equals("yes")) {
                    messageObj.displayReport();
                }

            } else {
                System.out.println(login.returnLoginStatus(false, "", ""));
            }
        }
    }
}
