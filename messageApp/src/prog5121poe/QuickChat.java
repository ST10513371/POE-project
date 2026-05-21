  
package prog5121poe;

import java.util.Random;


public class QuickChat {
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    // Static variable for total messages
    private static int totalMessages = 0 ;
   
    
    
    public QuickChat(String messageID, String recipient, String messageText) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = messageHash;
        totalMessages++;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }
    
       // Generate random 10 digit message ID
    public String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L +
                (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }
    public boolean checkmessageID(){
        if (messageID.length()<= 10){
            return true;
        }else{
            return false;
        }
    }
    
    //Check recipient number
    public boolean checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() <= 13) {
            return true;
        } else {
            return false;
        }
    }
    
    // check message length
    public boolean checkMessageLength() {

        if (messageText.length() <= 250) {
            return true;
        } else {
            return false;
        }
    }

     // Create message hash
    public String createMessageHash() {

        String firstTwo = messageID.substring(0, 2);

        String[] words = messageText.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        messageHash = firstTwo + ":" + totalMessages + ":" +
                firstWord + lastWord;

        return messageHash.toUpperCase();
    }
    
    public String sentmasseges( int option){
        if(option == 1){
            return "message sent .";
        }
        else if(option == 2){
            return "coming soon";
        }
        else if(option == 3){
                return "Message discarded.";
            }
        else{
            return "Invalid option";
        }
    }
        
        // Print message
     public String printMessages(){

        return "Message ID: " + messageID +
                "\nMessage Hash: " + createMessageHash() +
                "\nRecipient: " + recipient +
                "\nMessage: " + messageText;
    }
    
     // Return total messages
    public static int returnTotalMessages() {
        return totalMessages;
        
    }

    
    
}
     