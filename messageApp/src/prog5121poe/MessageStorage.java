
package prog5121poe;

import java.util.ArrayList;

public class MessageStorage {  
    public static ArrayList<QuickChat> sentMessages = new ArrayList<>();

    public static ArrayList<QuickChat> storedMessages = new ArrayList<>();

    public static ArrayList<QuickChat> disregardedMessages = new ArrayList<>();

    public static ArrayList<String> messageHashes = new ArrayList<>();

    public static ArrayList<String> messageIDs = new ArrayList<>();
    
    
    
    // 1. Display the Sender And Recipient from the Stored messages
    public static void displaySenderAndRecipient(){

    for(QuickChat msg : MessageStorage.storedMessages){

        System.out.println("Sender: User");
        System.out.println("Recipient: " + msg.getRecipient());
        System.out.println("Message: " + msg.getMessageText());
    }
}
    
 // 2. Display the longest message
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

        System.out.println("\n--- LONGEST MESSAGE ---");
        System.out.println(longest.getMessageText());
    }
    
     // 3. Search by MessageID
    public static void searchByMessageID(String id) {

        for (QuickChat msg : MessageStorage.storedMessages) {

            if (msg.getMessageID().equals(id)) {

                System.out.println("\n--- MESSAGE FOUND ---");
                System.out.println("Recipient: " + msg.getRecipient());
                System.out.println("Message: " + msg.getMessageText());
                return;
            }
        }

        System.out.println("Message ID not found.");
    }
    
    // 4. Search by Recipient
    public static void searchByRecipient(String recipient) {

        System.out.println("\n--- MESSAGES FOR RECIPIENT ---");

        for (QuickChat msg : MessageStorage.storedMessages) {

            if (msg.getRecipient().equals(recipient)) {

                System.out.println(msg.getMessageText());
            }
        }
    }
    
    // 5. Delete by Message Hash
    public static void deleteByHash(String hash) {

        for (int i = 0; i < MessageStorage.storedMessages.size(); i++) {

            if (MessageStorage.storedMessages.get(i)
                    .createMessageHash()
                    .equals(hash)) {

                MessageStorage.storedMessages.remove(i);

                System.out.println("Message successfully deleted.");
                return;
            }
        }

        System.out.println("Message not found.");
    }
    
    // 6. Full Report
    public static void displayReport() {

        System.out.println("\n FULL MESSAGE REPORT ");

        for (QuickChat msg : MessageStorage.storedMessages) {

            System.out.println(msg.printMessages());
        }
    }
}

