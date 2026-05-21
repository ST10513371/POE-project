   
package prog5121poe;

import java.util.Scanner; 

public class MessageApp {
  
    
    public static void main(String[] args) {
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
        
    
        System.out.println("\n LOGIN");
        
        //promts the user for the username they used
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        //prompts the user for the password they used
        System.out.print("Enter password: ");
        String password = input.nextLine();

        boolean result = user.loginUser(username, password);//Compares entered username & password With the ones stored
        System.out.println(user.returnLoginStatus(result)); // displays out the welcome message
        
    
        //POE Part 2
        // Welcome message
        System.out.println("\nWelcome to QuickChat");

        // Asks if user logged in
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
                System.out.println("\nMENU");
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");

                System.out.print("Choose option: ");
                choice = input.nextInt();
                input.nextLine();

                // OPTION 1
                if (choice == 1){
                    if (count < numMessages) {
                        System.out.print("Enter Message ID: ");
                        String id = input.nextLine();

                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter message: ");
                        String text = input.nextLine();
                        
                    // Create object
                        QuickChat msg = new QuickChat(id, recipient, text);

                        // Store in array
                        messages[count] = msg;

                        count++;
                          
                        
                        // Check ID
                        if (msg.checkmessageID()) {
                            System.out.println("Message ID correctly formatted.");
                        } else {
                            System.out.println("Message ID incorrectly formatted.");
                        }

                        // Recipient result
                        System.out.println(msg.checkRecipientCell());

                        // Check message length
                        if (msg.checkMessageLength()) {
                            System.out.println("Message sent.");
                        } else {
                            System.out.println("Please enter a message of less than 250 characters.");
                        }

                        // Message hash
                        System.out.println("Message Hash: " + msg.createMessageHash());

                        // Send options
                        System.out.println("\nChoose option:");
                        System.out.println("1. Send Message");
                        System.out.println("2. Store Message");
                        System.out.println("3. Discard Message");

                        int sendChoice = input.nextInt();
                        input.nextLine();
                    
                        // Display result
                        System.out.println(msg.sentmasseges(sendChoice));
                    
                        // Print full details
                        System.out.println("\nFULL MESSAGE DETAILS");
                        System.out.println(msg.printMessages());
                    }

                    else {
                        System.out.println("You reached the message limit.");
                    }
                }                
                 // OPTION 2
            else if (choice == 2) {
                System.out.println("Coming Soon.");
            }
                
                // OPTION 3
            else if (choice == 3) {
                System.out.println("Total messages sent: "+ QuickChat.returnTotalMessages());
                System.out.println("Goodbye!");
            }
            else {

                System.out.println("Invalid option.");
            }
            }  
        }      
    }
}
          