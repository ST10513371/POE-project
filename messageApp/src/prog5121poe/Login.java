 
package prog5121poe;


public class Login {
    //Declaration of variables
   private String firstname;
   private String lastname;
   private String username;
   private String  password;
   private String cellphoneNumber;

    
    public Login(String u , String p , String cpn ,String fn ,String ln) {
        this.firstname = fn;
        this.lastname = ln;
        this.username = u;
        this.password = p;
        this.cellphoneNumber = cpn;
    }
   
    //Checks if Username is correctly inputed
   public boolean checkUsername() {
        if (username.contains("_") && username.length() <= 5) { // method checks if username contains an underscore and is less than or equal to 5
            return true;
        } else {
            return false;
        }
    }
    
    //Checks if Password is correctly inputed
    public boolean checkPasswordComplexity() {
        if (password.length() >= 8 &&               // checks if password is atleast 8 characters long
            password.matches(".*[A-Z].*") &&        //checks for atleast one capital letter
            password.matches(".*[0-9].*") &&        // checks for atleast one digit
            password.matches(".*[^a-zA-Z0-9].*")) {     //checks for atleats one special character

            return true;
        } else {
            return false;
        }
    }
    
    // Checks cellphone number using regular expression
    //ORACLE "using Regular Expressions"
    //https://www.oracle.com/webfolder/technetwork/tutorials/obe/db/10g/r2/prod/develop/regexp/regexp_otn.htm
    //Accessed on 25 march 2026
    //literal international country code =  \\+27
    //number of digits after the country code=  \\d{9}
    public boolean checkCellPhoneNumber() {
        return cellphoneNumber.matches("^\\+27\\d{9}$"); 
    }

    
    // Registering User
       public String registerUser() {

        if (!checkUsername()) {
            return  "Username is not correctly formatted; please ensure it contains an underscore '_' and is no more than 5 characters.";
       }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains atleast eight characters, a capital letter ,a number and a special character.";
       }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
       }
        return "Username successfully captured. \n password successfully captured. \n cell phone Number successfully captured.";
       }

       
    //Login check
    public boolean loginUser(String username, String password) {
        return username.equals(this.username) && password.equals(this.password); 
            
    }
    
     //Returns the Login message
    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + this.firstname + " " + this.lastname + ", it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
}   
   