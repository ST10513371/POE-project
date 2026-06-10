   
package prog5121poe;

import java.util.Scanner; 

public class MessageApp {
  
    
    public static void main(String[] args) {
        //Part 1
        //scanner
        Scanner input = new Scanner(System.in);
        
        // Registering the user 
        System.out.println("REGISTER");
        
        //Prompts the user for firstname
        //fn =firstname
        System.out.print("Enter your first name: ");
        String fn = input.nextLine(); 
        
        //Prompts the user for lastname
        //ln =lastname
        System.out.print("Enter your last name: ");
        String ln = input.nextLine();
        
        //Prompts the user for username
        //u = username
        System.out.print("Enter username: ");
        String u = input.nextLine(); 
        
        //Prompts the user for password
         //p =password
        System.out.print("Enter password: ");
        String p = input.nextLine();

        //Prompts the user for cell phone number 
         //cpn = cell phone number
        System.out.print("Enter cellphonenumber (+27...): ");
        String cpn = input.nextLine();
        
         //I used the object to initialize the values in the the constructor inside the login class
        Login user= new Login(u, p, cpn ,fn ,ln);
        
        //Registration message
        //The object calls the register user method
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);
        
    
        System.out.println("\n ===LOGIN===");
        
        //promts the user for the username they used
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        //prompts the user for the password they used
        System.out.print("Enter password: ");
        String password = input.nextLine();

        boolean result = user.loginUser(username, password);//Compares entered username & password With the ones stored
        System.out.println(user.returnLoginStatus(result)); // displays out the welcome message
        
    
        //POE PART 2
        // Welcome message
        System.out.println("\n ===Welcome to QuickChat===");

        // only executes once the user has passed the loggin stage
        boolean loggedIn = true;

        if (loggedIn == true) {

            System.out.print("How many messages would you like to send? :");
            int numMessages = input.nextInt();
            input.nextLine();

            // ARRAY OF OBJECTS
            QuickChat[] messages = new QuickChat[numMessages];

            int choice = 0;
            int count = 0;

            while (choice != 3) {
                System.out.println("\n ===MENU=== ");
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");
                System.out.println("4. Message reports"); // part 3
                

                System.out.print("Choose option: "); 
                choice = input.nextInt();
                input.nextLine();

                // OPTION 1
                if (choice == 1){                                     
                  
                    if (count < numMessages) {
                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter message: ");
                        String messagetext = input.nextLine();
                        
                        // I used the object to initialize the values in the the constructor inside the QuickChat class
                        QuickChat msg = new QuickChat( recipient, messagetext);

                        // Store in array
                        messages[count] = msg;
                        
                        count++;
                          
                        //Outputs the generated messageID and also calling the generateMessageID Method
                        System.out.println("Generated MessageID :" + msg.generateMessageID());
                        
                        // Checks messageID and confirms if its correct
                        System.out.println(msg.checkmessageID());                        

                        // checks if the Recipient cellPhoneNumber is correct , it has an underscore 
                        //and starts with the international code  "+27"
                        System.out.println(msg.checkRecipientCell());

                        // Checks if the message length is less than 250 characters.
                        System.out.println(msg.checkMessageLength());                         

                        //Outputs the generated messageHash and also calling the createMessageHash Method
                        
                        // The correct first 2 numbers FROM the messageID in the messageHash will show after SENDING,STORING AND DISCARDING the messages!!
                        System.out.println("Message Hash: " + msg.createMessageHash());

                        // Send options
                        System.out.println("\nChoose option:");
                        System.out.println("1. Send Message");
                        System.out.println("2. Store Message");
                        System.out.println("3. Discard Message");

                        int sendChoice = input.nextInt();
                        input.nextLine();
                    
                        // Display result
                        System.out.println(msg.sentmessages(sendChoice));
                    
                        // Print full details
                        System.out.println("\nFULL MESSAGE DETAILS");
                        System.out.println(msg.printMessages());
                   } else { 
                        System.out.println("You reached the message limit.");
                    }
                }                
                        // OPTION 2
                        else if (choice == 2) {
                           // SHOW RECENTLY SENT MESSAGES                         
                            System.out.println("\n === RECENTLY SENT MESSAGES ===");
                            System.out.println(MessageStorage.getRecentMessages());
                        }
                        
          
                        // OPTION 3
                         else if (choice == 3) {
                        System.out.println("Total messages sent: "+ QuickChat.returnTotalMessages());
                         System.out.println("Goodbye!");
                         }
                         
                          //PART 3
                          // OPTION 4 ( Stored messages)
                         else if(choice == 4){
                            
                        System.out.println("\nREPORT MENU");
                        System.out.println("1. Sender & Recipient");
                        System.out.println("2. Longest Message");
                        System.out.println("3. Search by Message ID");
                        System.out.println("4. Search by Recipient");
                        System.out.println("5. Delete by Hash");
                        System.out.println("6. Full Report");

                        System.out.print("Choose Report option: "); 
                        int reportChoice = input.nextInt();
                        input.nextLine();

                        if(reportChoice == 1){
                            //output the sender and recipient
                            MessageStorage.displaySenderAndRecipient();
                        }
                        else if(reportChoice == 2){
                            //outputs the longests message stored
                            MessageStorage.displayLongestMessage();
                        }
                        else if(reportChoice == 3){
                            System.out.print("Enter Message ID: ");
                            String id = input.nextLine();
                            
                            //output the message and recipient number searched using the messageID
                            MessageStorage.searchByMessageID(id);
                        }
                        else if(reportChoice == 4){

                            System.out.print("Enter recipient: ");
                            String rec = input.nextLine();
                            
                            //output the message found using the recipients number
                            System.out.print(MessageStorage.searchByRecipient(rec));
                        }
                        else if(reportChoice == 5){
                            System.out.print("Enter message hash: ");
                            String hash = input.nextLine();
                            
                            //outputs the confirmation that the message is successfully deleted using the mssageHASH
                            System.out.print(MessageStorage.deleteByHash(hash));
                        }
                        else if(reportChoice == 6){
                            
                            //outputs the full report which shows the messageHASH ,recipients number and the message
                           System.out.print( MessageStorage.displayReport());
                        }
                        else {
                            //outputs if the user does not choose an option between 1-6
                            System.out.println("Invalid report option.");
                        }
                        }
                         else {
                        System.out.println("Invalid option.");
                }
            }  
        }          
    }
}
          