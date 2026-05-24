  
package prog5121poe;

import java.util.Random;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class QuickChat {
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    // Static variable for total messages
    private static int totalMessages = 0 ;
   
      
    public QuickChat( String recipient, String messageText) {
        this.messageID = generateMessageID();
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
    
    
    
       //Generate 10 random digit for the message ID
    public String generateMessageID() {

        Random random = new Random();
        
        long number = 1000000000L +
                
                (long)(random.nextDouble() * 9000000000L);
        
        return String.valueOf(number);
    }
    
    //Check recipient number                                                     
    public String checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() <= 13) {
            
            return "Cell phone number successfully captured.";
            
        } else {
            
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    
    public String checkmessageID(){
        if (messageID.length()<= 10){
            return "Message ID correctly formatted.";
        }else{
            return "Message ID incorrectly formatted.";
        }
    }    
        // Create message hash
        public String createMessageHash(){
        String firstTwo = messageID.substring(0, 2);
        
        String[] words = messageText.split(" ");
        
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        messageHash = firstTwo + ":" + totalMessages+ ":" +
                firstWord + lastWord;
        
        return messageHash.toUpperCase();
    }
    
    // check message length
        public String checkMessageLength() {

        if (messageText.length() <= 250) {

        return "Message ready to send.";

        } else {

        int extraCharacters = messageText.length() - 250;

        return "Message exceeds 250 characters by "+ extraCharacters + ", please reduce the size.";
        //This methods checks if the message exceed 250 characters and if it exceeds 250 characters it will check by how many
        //characters the message exceeds.
    }
}
    
    public String sentmessages( int option){
        if(option == 1){
            return "message sent.";
        }
        else if(option == 2){
            
        storeMessageJSON();
            return "Message successfully stored.";
        }
        else if(option == 3){
                return "Press 0 to delete the message.";
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
    
    //This method stores the messages in a JSON file.
    //Jackson JSON Java Library. Available at:
    // https://mvnrepository.com/artifact/org.json/json
     //Accessed on 24 march 2026
    public void storeMessageJSON() {
    try {
        // Creates ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // Creates JSON file
        File file = new File("messages.json");
        // Stores this object into JSON file
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, this);

        //I made this part a comment beacause the message will print twice as the one on the sentmessages method "option 2"
        //System.out.println("Message successfully stored.");       
    } catch (IOException e) {
        System.out.println("Error!! storing messages.");
    }
}
}
     