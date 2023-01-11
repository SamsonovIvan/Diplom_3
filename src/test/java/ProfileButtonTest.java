import org.junit.Test;
import pompackage.MainPage;

public class ProfileButtonTest extends PrepairingTest {

    @Test
    public void profileButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickLoginButton()
                .loginRegisteredUser(user.getEmail(), user.getPassword())
                .enter()
                .clickProfileButtonAfterAuth()
                .areWeOnProfilePage();
    }
}
