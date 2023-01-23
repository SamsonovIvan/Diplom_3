import org.junit.Test;
import pompackage.MainPage;

public class ExitButtonTest extends PrepairingTest {

    @Test
    public void exitButtonInProfileTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickLoginButton()
                .loginRegisteredUser(user.getEmail(), user.getPassword())
                .enter()
                .clickProfileButtonAfterAuth()
                .clickExit()
                .isItLoginPageChek();
    }
}
