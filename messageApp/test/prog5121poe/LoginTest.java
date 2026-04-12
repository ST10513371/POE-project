
package prog5121poe;


import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
   
@Test
     public void testcorrectUsername() {
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "kyle", "Smith");
     boolean result = user.checkUsername(); //Tests if the username is correct
     assertTrue(result);    //I used assert True/False becuase assertEquals only returns String methods not boolean
}

@Test
public void testIncorrectUsername() {
    Login user = new Login("kyle!!!!!!!", "password", "+27838968976", "Kyle", "Smith");
    boolean result = user.checkUsername(); //Tests if the username is incorrect
    assertFalse(result);       
}

@Test
public void testCorrectPassword() {
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

   boolean result = user.checkPasswordComplexity(); //Tests if the password is correct
    assertTrue(result);   
}

@Test
public void testIncorrectPassword() {
    Login user = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");

    boolean result = user.checkPasswordComplexity(); //Tests if the password is incorrect
    assertFalse(result);
    
}

@Test
public void testCorrectCellphoneNumber() {
    Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

   boolean result = user.checkCellPhoneNumber(); //Tests if the cellPhoneNumber is correct
    assertTrue(result);
}

@Test
public void testIncorrectCellphone() {
    Login user = new Login("kyl_1", "Password1!", "08966553", "Kyle", "Smith");

       boolean result = user.checkCellPhoneNumber();  //Tests if the cellPhoneNumber is incorrect
      assertFalse(result);
}
 

@Test
public void testLoginSuccessful() {
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

    boolean result = user.loginUser("kyl_1","Ch&&sec@ke99!"); //Tests if the user has successfully logged in with correct username and password
    assertTrue(result);
}

@Test
public void testLoginFailed() {
    Login user = new Login("kyle!!!!!!!", "Password1!", "+27838968976", "Kyle", "Smith");

    boolean result = user.loginUser("wrongUsername", "wrongPassword"); // Tests if the user has failed to log in using username and password
    assertFalse(result);
}

@Test
public void testUsernameCorrectlyFormatted() {
    Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");
    assertTrue(user.checkUsername());
}

@Test
public void testUsernameIncorrectlyFormatted() {
    Login user = new Login("kyle!!!!!!!", "Password1!", "+27838968976", "Kyle", "Smith");
    assertFalse(user.checkUsername());
}

@Test
public void testpasswordMeetsComplexity(){
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
    assertTrue(user.checkPasswordComplexity());
}
@Test
public void testpasswordDoesNotMeetsComplexity(){
    Login user = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
    assertFalse(user.checkPasswordComplexity());
}

@Test
public void testcellPhoneNumberCorrecctlyFormatted(){
    Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");
    assertTrue(user.checkCellPhoneNumber());
}

@Test
public void testcellPhoneNumberIncorrecctlyFormatted(){
    Login user = new Login("kyl_1", "Password1!", "08966553", "Kyle", "Smith");
    assertFalse(user.checkCellPhoneNumber());
}
}
 