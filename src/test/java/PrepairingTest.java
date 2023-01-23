import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import restpackage.User;
import restpackage.UserActions;
import restpackage.UserData;
import restpackage.UserGenerator;
import java.time.Duration;
abstract public class PrepairingTest {
    UserActions userActions;
    WebDriver driver;
    protected static final User user = UserGenerator.getRandomUser();

    @Before
    public void setUp(){
      driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      userActions = new UserActions();
      userActions.createUser(user);
    }

    @After
    public void tearDown(){
        UserData userData = new UserData(user.getEmail(), user.getPassword());
        Response response = userActions.login(userData);
        if (response.body().jsonPath().getString("accessToken") != null){
            userActions.delete(response);
        }
        driver.quit();
    }

}
