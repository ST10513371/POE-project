/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog5121poe;


import org.junit.Test;
import static org.junit.Assert.*;

public class QuickChatTEST {
    
    //This tests if the message does not exceeded 250 characters.
    @Test
    public void testCheckMessageLengthSuccess() {

    QuickChat msg =new QuickChat("+27831234567","Hello Tumelo");

    String expected = "Message ready to send.";

    String actual = msg.checkMessageLength();

    assertEquals(expected, actual);   
}
    //This tests if the message has exceeded 250 characters.
  @Test
    public void testCheckMessageLengthFailure() {
    String longMessage ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    QuickChat msg = new QuickChat("+27831234567",longMessage);

    String actual = msg.checkMessageLength();

    assertTrue(actual.contains("Message exceeds 250 characters"));
}

    //This Tests and confirms if Cell phone number successfully captured.
    @Test
    public void testCheckRecipientCellSuccess() {
    QuickChat msg = new QuickChat("+27831234567","Hello");

    String expected = "Cell phone number successfully captured.";
    
    String actual = msg.checkRecipientCell();
 
    assertEquals(expected, actual);
}   
    //This Tests and confirms if Cell phone number successfully captured.
    @Test
    public void testCheckRecipientCellFailure() {

    QuickChat msg = new QuickChat("0831234567","Hello");

    String expected = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";

    String actual = msg.checkRecipientCell();

    assertEquals(expected, actual);
}
  //Tests the messageID Created.
    @Test
     public void testMessageIDCreated() {
        QuickChat msg =  new QuickChat("+27123456789", "Hello");
        assertEquals( "Message ID correctly formatted.", msg.checkmessageID());
    }  
    
    // Tests the messageHash created.
    @Test
    public void testMessageHashCreated() {
        QuickChat msg = new QuickChat("+27123456789", "Hi There");
        
        String hash = msg.createMessageHash();

        assertNotNull(hash);
    }

}
