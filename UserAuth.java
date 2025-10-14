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
            Message messageObj = new Message();
System.out.println("Welcome to QuickChat.");

int choice;
do {
    System.out.println("Choose an option:\n1) Send Message\n2) Show Recently Sent Messages\n3) Quit");
    choice = scanner.nextInt();
    scanner.nextLine(); // consume newline

    switch (choice) {
        case 1:
            System.out.println("How many messages would you like to send?");
            int count = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                System.out.println("Enter recipient number:");
                String recipient = scanner.nextLine();

                System.out.println("Enter message:");
                String msg = scanner.nextLine();

                String result = messageObj.sendMessage(recipient, msg);
                System.out.println(result);

                if (result.equals("Message successfully sent.")) {
                    System.out.println(messageObj.printMessage());
                }
            }
            System.out.println("Total messages sent: " + messageObj.returnTotalMessages());
            break;

        case 2:
            System.out.println("Coming Soon.");
            break;

        case 3:
            System.out.println("Exiting...");
            break;

        default:
            System.out.println("Invalid option.");
    }
} while (choice != 3);
        }
    }
}
  

