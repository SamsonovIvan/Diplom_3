package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecovery {
    public static final String RCOVERY_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By fromRecoveryToLogin = By.xpath("//a[text()='Войти']");
    private WebDriver driver;
    public PasswordRecovery(WebDriver driver){
        this.driver = driver;
    }

    public PasswordRecovery open(){
        driver.get(RCOVERY_URL);
        return this;
    }

    public LoginPage clickLogin(){
        driver.findElement(fromRecoveryToLogin).click();
        return  new LoginPage(driver);
    }

}
