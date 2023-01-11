package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage {
    private WebDriver driver;

    public final static String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private By enterButton = By.xpath("//button[text()='Войти']");
    private By regButton = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    private By emailField = By.xpath("//label[text()='Email']//following-sibling::input");
    private By passwordField = By.xpath("//label[text()='Пароль']//following-sibling::input");
    private By incorrectPasswordMessage = By.xpath("//p[text()='Некорректный пароль']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public RegistrationPage clickRegistration(){
        driver.findElement(regButton).click();
        return new RegistrationPage(driver);
    }

    public LoginPage inputEmail(String email){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginRegisteredUser(String email, String password){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(LOGIN_URL));
        inputEmail(email);
        inputPassword(password);
        return this;
    }

    public MainPage enter(){
        driver.findElement(enterButton).click();
        return new MainPage(driver);
    }

    public void incorrectPasswordCheck(){
        assertTrue(driver.findElement(incorrectPasswordMessage).isDisplayed());
        assertEquals("Некорректный пароль", driver.findElement(incorrectPasswordMessage).getText());
    }
    public void isItLoginPageChek(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_URL));
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }
}
