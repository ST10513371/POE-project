  
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
        
         //The object calls the login class in order to prompt the user for input
        Login user= new Login(u, p, cpn ,fn ,ln);
        
        //Registration message
        //The object calls the register user method
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);
        
    
        System.out.println(" LOGIN");
        
        //promts the user for the username they used
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        //prompts the user for the password they used
        System.out.print("Enter password: ");
        String password = input.nextLine();

        boolean result = user.loginUser(username, password);
        System.out.println(user.returnLoginStatus(result));
         
        input.close();
    }         
} 
         