/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deede
 */
import java.util.Random;

public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private static int totalMessages = 0;

    public boolean checkMessageID(String id) {
        return id.length() <= 10;
    }

    public boolean checkRecipientCell(String cell) {
        return cell.matches("^\\+\\d{1,3}\\d{7,10}$");
    }

    public String createMessageHash() {
        String firstTwo = messageID.substring(0, 2);
        String lastTwo = messageID.substring(messageID.length() - 2);
        return (firstTwo + ":" + lastTwo + ":" + message.toUpperCase()).toUpperCase();
    }

    public String sendMessage(String recipient, String message) {
        if (!checkRecipientCell(recipient)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        if (message.length() > 250) {
            return "Message exceeds 250 characters by " + (message.length() - 250) + ", please reduce size.";
        }

        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        totalMessages++;

        return "Message successfully sent.";
    }

    public String printMessage() {
        return "Message ID: " + messageID + "\nHash: " + createMessageHash() +
               "\nRecipient: " + recipient + "\nMessage: " + message;
    }

    public int returnTotalMessages() {
        return totalMessages;
    }

    private String generateMessageID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }
}
    

