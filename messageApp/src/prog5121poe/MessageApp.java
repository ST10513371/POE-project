/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog5121poe;

import java.util.Scanner; 

public class MessageApp {
  
    
    public static void main(String[] args) {
        //scanner
        Scanner input = new Scanner(System.in);
        
        // Registering the user 
        System.out.println("REGISTER");
        
        //Prompt the user for firstname
        //fn =firstname
        System.out.print("Enter your first name: ");
        String fn = input.nextLine(); 
        
        //Prompt the user for lastname
        //ln =lastname
        System.out.print("Enter your last name: ");
        String ln = input.nextLine();
        
        //Prompt the user for username
        //u = username
        System.out.print("Enter username: ");
        String u = input.nextLine(); 
        
        //Prompt the user for password
         //p =password
        System.out.print("Enter password: ");
        String p = input.nextLine();

        //Prompt the user for cell phone number 
         //cpn = cell phone number
        System.out.print("Enter cellphonenumber (+27...): ");
        String cpn = input.nextLine();
        
        
        Login user= new Login(u, p, cpn ,fn ,ln);
        
        //Registration message
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);
        
    
        System.out.println("\n LOGIN");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        boolean result = user.loginUser(username, password);

        System.out.println(user.returnLoginStatus(result));
         
        input.close();
    }         
}
 