import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pompackage.MainPage;
import restpackage.UserActions;
import restpackage.UserData;
import restpackage.UserGenerator;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    WebDriver driver;
    UserActions userActions;
    protected String name = UserGenerator.getRandomUser().getName();
    protected String email = UserGenerator.getRandomUser().getEmail();
    protected String password = UserGenerator.getRandomUser().getPassword();
    protected String incorrectPassword = "0123";


    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void registerUserTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickLoginButton()
                .clickRegistration()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirm()
                .loginRegisteredUser(email, password)
                .enter()
                .areWeOnMainPage();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://stellarburgers.nomoreparties.site/", currentUrl);
    }

    @Test
    public void incorrerctPasswordTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickLoginButton()
                .clickRegistration()
                .setName(name)
                .setEmail(email)
                .setPassword(incorrectPassword)
                .clickConfirm()
                .incorrectPasswordCheck();
    }


    @After
    public void tearDown(){
        userActions = new UserActions();
        UserData userData = new UserData(email, password);
        Response response = userActions.login(userData);
        if (response.body().jsonPath().getString("accessToken") != null){
            userActions.delete(response);
        }

        UserData incorrectData = new UserData(email, incorrectPassword);
        Response incorResponse = userActions.login(incorrectData);
        if (incorResponse.body().jsonPath().getString("accessToken") != null){
            userActions.delete(incorResponse);
        }
        driver.quit();
    }
}
