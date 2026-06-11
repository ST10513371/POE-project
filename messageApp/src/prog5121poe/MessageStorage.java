
package prog5121poe;
 
import java.util.ArrayList;

public class MessageStorage {  
    public static ArrayList<QuickChat> sentMessages = new ArrayList<>();

    public static ArrayList<QuickChat> storedMessages = new ArrayList<>();

    public static ArrayList<QuickChat> disregardedMessages = new ArrayList<>();

    public static ArrayList<String> messageHashes = new ArrayList<>();

    public static ArrayList<String> messageIDs = new ArrayList<>();
    
       
    // 1. Display the Sender And Recipient from the Stored messages.
    public static void displaySenderAndRecipient(){
        
    for(QuickChat msg : MessageStorage.storedMessages){

        System.out.println("Sender: User");
        System.out.println("Recipient: " + msg.getRecipient());
        System.out.println("Message: " + msg.getMessageText());
    }
    
}
    //2. returns the longest stored message.
    public static QuickChat getLongestMessage() {

        if (storedMessages.isEmpty()) {
            return null;
        }
        QuickChat longest = storedMessages.get(0);

        for (QuickChat msg : storedMessages) {

            if (msg.getMessageText().length() >
                    longest.getMessageText().length()) {
                longest = msg;
            }
        }
        return longest;
    }
    
 // Display the longest message.
    public static void displayLongestMessage() {

        if (MessageStorage.storedMessages.isEmpty()) {
            System.out.println("No messages available.");
            return;
        }
        QuickChat longest = MessageStorage.storedMessages.get(0);

        for (QuickChat msg : MessageStorage.storedMessages) {

            if (msg.getMessageText().length() >
                longest.getMessageText().length()) {

                longest = msg;
            }
        }
        System.out.println("\n === LONGEST MESSAGE ===");
        System.out.println(longest.getMessageText());
    }
    
    

     // 3. Search by MessageID.
    public static void searchByMessageID(String id) {

        for (QuickChat msg : MessageStorage.storedMessages) {
            if (msg.getMessageID().equals(id)) {

                System.out.println("\n == MESSAGE FOUND == ");
                System.out.println("Recipient: " + msg.getRecipient());
                System.out.println("Message: " + msg.getMessageText());
                return;
            }
        }
        System.out.println("Message ID not found.");
    }
    
        // Search by Recipient.
    public static String searchByRecipient(String recipient){  
        String results = "";
        
        for (QuickChat msg : storedMessages) {

            if (msg.getRecipient().equals(recipient)) {
              
                results += msg.getMessageText() + "\n";
            }
        }
        if (results.equals("")) {
            return "No messages found.";
        }
        return results.trim();
    } 

    // Delete a message using a message hash.
    public static String deleteByHash(String hash) {

    for (int i = 0; i < storedMessages.size(); i++) {

        if (storedMessages.get(i).createMessageHash().equalsIgnoreCase(hash)) {

            String deletedMessage =storedMessages.get(i).getMessageText();

            storedMessages.remove(i);

            return "The Message: \"" + deletedMessage + "\"is successfully deleted.";
        }
    }
    return "Message not found.";
}
    
    //Display the full report.   
    public static String displayReport() {
    String report = "";

    for (QuickChat msg : storedMessages) {

        report +=
            "Hash: " + msg.createMessageHash()
            + "\nRecipient: " + msg.getRecipient()
            + "\nMessage: " + msg.getMessageText()
            + "\n\n";
    }
    return report;
}
    //Display the recently sent messages.
    public static String getRecentMessages() {

        if (sentMessages.isEmpty()) {
            return "No recently sent messages.";
        }
        String result = "";
        for (QuickChat msg : sentMessages) {
            result += msg.getMessageText() + "\n";
        }
    return result.trim();
}
}
