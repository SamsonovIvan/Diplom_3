
import org.junit.Test;
import pompackage.MainPage;
import pompackage.PasswordRecovery;
import pompackage.RegistrationPage;


public class AuthTest extends PrepairingTest {
   @Test
    public void mainPageAuthTest(){
       MainPage mainPage = new MainPage(driver);
       mainPage.open()
               .clickLoginButton()
               .inputEmail(user.getEmail())
               .inputPassword(user.getPassword())
               .enter()
               .areWeOnMainPage();
   }

   @Test
    public void profileButtonAuthTest() {
       MainPage mainPage = new MainPage(driver);
       mainPage.open()
               .clickProfileButtonBeforeAuth()
               .inputEmail(user.getEmail())
               .inputPassword(user.getPassword())
               .enter()
               .areWeOnMainPage();
   }

   @Test
    public void registerFormAuthTest(){
       RegistrationPage regPage = new RegistrationPage(driver);
       regPage.open()
               .clickLogin()
               .inputEmail(user.getEmail())
               .inputPassword(user.getPassword())
               .enter()
               .areWeOnMainPage();
   }

   @Test
    public void recoveryFormAuthTest(){
       PasswordRecovery passRec = new PasswordRecovery(driver);
       passRec.open()
               .clickLogin()
               .inputEmail(user.getEmail())
               .inputPassword(user.getPassword())
               .enter()
               .areWeOnMainPage();
   }


}
