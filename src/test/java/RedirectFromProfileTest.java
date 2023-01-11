import org.junit.Test;
import pompackage.MainPage;

public class RedirectFromProfileTest extends PrepairingTest {

    @Test
    public void constructorButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickLoginButton()
                .loginRegisteredUser(user.getEmail(), user.getPassword())
                .enter()
                .clickProfileButtonAfterAuth()
                .clickConstructor()
                .areWeOnMainPage();
    }

    @Test
    public void logoClickTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickLoginButton()
                .loginRegisteredUser(user.getEmail(), user.getPassword())
                .enter()
                .clickProfileButtonAfterAuth()
                .clickLogo()
                .areWeOnMainPage();
    }
}
