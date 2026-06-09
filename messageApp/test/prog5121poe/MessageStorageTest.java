
package prog5121poe;

import org.junit.Test;
import static org.junit.Assert.*;



public class MessageStorageTest {  

        //This tests if the sent messages array is correctly populated.
        @Test
        public void testSentMessagesArrayPopulated() {
            MessageStorage.sentMessages.clear();

            MessageStorage.sentMessages.add( new QuickChat("+27834557896", "Did you get the cake?") );

            MessageStorage.sentMessages.add(new QuickChat("+27838884567", "It is dinner time!"));

            assertEquals( "Did you get the cake?",MessageStorage.sentMessages.get(0).getMessageText());

            assertEquals( "It is dinner time!",MessageStorage.sentMessages.get(1).getMessageText());
        }
    
        //This tests if the DisplayLongestMessage method is  correct and the longest message is displayed.
        @Test
        public void testDisplayLongestMessage() {

        MessageStorage.storedMessages.clear();

        QuickChat message1 = new QuickChat("+27834557896", "Did you get the cake?" );

        QuickChat message2 = new QuickChat( "+27838884567", "Where are you? You are late! I have asked you to be on time." );

        MessageStorage.storedMessages.add(message1);
        MessageStorage.storedMessages.add(message2);

        QuickChat longest = MessageStorage.getLongestMessage();

        assertEquals( "Where are you? You are late! I have asked you to be on time.",longest.getMessageText());
    }

        //This tests if the SearchMessageID method is correct and the correct message is displayed using the messageID.
        @Test
        public void testSearchMessageID() {

        MessageStorage.sentMessages.clear();

        QuickChat msg4 =new QuickChat("+27838884567", "It is dinner time!");

        MessageStorage.sentMessages.add(msg4);

        assertEquals( "It is dinner time!", msg4.getMessageText() );
    }
        
        //This tests if the SearchByRecipient method is correct and the correct message is displayed using the Recipients number.
        @Test  
         public void testSearchByRecipient() {

        MessageStorage.storedMessages.clear();

        QuickChat msg2 = new QuickChat("+27838884567","Where are you? You are late! I have asked you to be on time.");

        QuickChat msg5 = new QuickChat("+27838884567", "Ok, I am leaving without you.");

        MessageStorage.storedMessages.add(msg2);
        MessageStorage.storedMessages.add(msg5);

        String expected ="Where are you? You are late! I have asked you to be on time.\n" + "Ok, I am leaving without you.";

        assertEquals(expected, MessageStorage.searchByRecipient("+27838884567"));
    }

         //This tests if the correct Message is deleted using the messageHASH.
        @Test
        public void testDeleteByHash() {

        MessageStorage.storedMessages.clear();

        QuickChat msg = new QuickChat("+27838884567","Where are you? You are late! I have asked you to be on time.");

        MessageStorage.storedMessages.add(msg);

        String hash = msg.createMessageHash();

        String expected ="The Message: \"Where are you? You are late! I have asked you to be on time.\"is successfully deleted.";

        assertEquals(expected, MessageStorage.deleteByHash(hash));

        assertEquals(0, MessageStorage.storedMessages.size());
        }
        
        //This tests if the DisplayReport method is correct and all the stored information is Displayed correctly.
        @Test
        public void testDisplayReport() {
            MessageStorage.storedMessages.clear();
            QuickChat msg1 =new QuickChat("+27834557896", "Did you get the cake?");

            QuickChat msg2 = new QuickChat("+27838884567", "Where are you? You are late! I have asked you to be on time.");

            MessageStorage.storedMessages.add(msg1);
            MessageStorage.storedMessages.add(msg2);

            String report = MessageStorage.displayReport();

            assertTrue(report.contains("Did you get the cake?"));

            assertTrue(report.contains("Where are you? You are late! I have asked you to be on time."));
        }
}
