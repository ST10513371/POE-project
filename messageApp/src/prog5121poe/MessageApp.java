   
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
         
        input.close();
    }         
} 
          