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

public class MessageTest {
    Message msg = new Message();

    @Test
    public void testRecipientFormatValid() {
        assertTrue(msg.checkRecipientCell("+27718693002"));
    }

    @Test
    public void testRecipientFormatInvalid() {
        assertFalse(msg.checkRecipientCell("0857597889"));
    }

    @Test
    public void testMessageLengthValid() {
        String result = msg.sendMessage("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testMessageLengthInvalid() {
        String longMsg = "x".repeat(260);
        String result = msg.sendMessage("+27718693002", longMsg);
        assertTrue(result.contains("Message exceeds 250 characters"));
    }
}
 
