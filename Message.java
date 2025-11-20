/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Random;

public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private static int totalMessages = 0;

    public static ArrayList<String> sentMessages = new ArrayList<>();
    public static ArrayList<String> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();
    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();

    public boolean checkRecipientCell(String cell) {
        return cell.matches("^\\+\\d{1,3}\\d{7,10}$");
    }

    public String sendMessage(String recipient, String message, String flag) {
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        totalMessages++;

        String hash = createMessageHash();
        messageHashes.add(hash);
        messageIDs.add(messageID);

        switch (flag.toLowerCase()) {
            case "sent":
                sentMessages.add("Sender: You | Recipient: " + recipient + " | Message: " + message);
                return "Message successfully sent.";
            case "stored":
                storedMessages.add("Sender: You | Recipient: " + recipient + " | Message: " + message);
                return "Message stored.";
            case "disregard":
                disregardedMessages.add("Sender: You | Recipient: " + recipient + " | Message: " + message);
                return "Message disregarded.";
            default:
                return "Invalid flag.";
        }
    }

    public String createMessageHash() {
        String firstTwo = messageID.substring(0, 2);
        String lastTwo = messageID.substring(messageID.length() - 2);
        return (firstTwo + ":" + lastTwo + ":" + message.toUpperCase()).toUpperCase();
    }

    public String generateMessageID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    public String printMessage() {
        return "Message ID: " + messageID + "\nHash: " + createMessageHash() +
               "\nRecipient: " + recipient + "\nMessage: " + message;
    }

    public int returnTotalMessages() {
        return totalMessages;
    }

    public String searchByMessageID(String id) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(id)) {
                return sentMessages.get(i);
            }
        }
        return "Message ID not found.";
    }

    public String findLongestSentMessage() {
        String longest = "";
        for (String msg : sentMessages) {
            String content = msg.split("\\|")[2].trim().replace("Message: ", "");
            if (content.length() > longest.length()) {
                longest = content;
            }
        }
        return longest;
    }

    public ArrayList<String> searchMessagesByRecipient(String recipient) {
        ArrayList<String> results = new ArrayList<>();
        for (String msg : sentMessages) {
            if (msg.contains(recipient)) {
                results.add(msg);
            }
        }
        for (String msg : storedMessages) {
            if (msg.contains(recipient)) {
                results.add(msg);
            }
        }
        return results;
    }

    public boolean deleteMessageByHash(String hash) {
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hash)) {
                sentMessages.remove(i);
                messageHashes.remove(i);
                messageIDs.remove(i);
                return true;
            }
        }
        return false;
    }

    public void displayReport() {
        System.out.println("Sent Messages:");
        for (String msg : sentMessages) {
            System.out.println(msg);
        }

        System.out.println("\nMessage Hashes:");
        for (String hash : messageHashes) {
            System.out.println(hash);
        }

        System.out.println("\nMessage IDs:");
        for (String id : messageIDs) {
            System.out.println(id);
        }
    }
}
