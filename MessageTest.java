/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {
    Message msg = new Message();

    @Test
    public void testSendMessageValid() {
        String result = msg.sendMessage("+27834557896", "Did you get the cake?", "sent");
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testSendMessageInvalidFlag() {
        String result = msg.sendMessage("+27834557896", "Hello", "unknown");
        assertEquals("Invalid flag.", result);
    }

    @Test
    public void testLongestMessage() {
        msg.sendMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "sent");
        msg.sendMessage("+27838884567", "I am leaving without you.", "sent");
        String longest = msg.findLongestSentMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }
}
