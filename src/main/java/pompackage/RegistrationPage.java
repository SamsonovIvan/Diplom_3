package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    public final static String REG_URL = "https://stellarburgers.nomoreparties.site/register";
    private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath("//*[text()='Пароль']/following-sibling::input");
    private By confirmButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginButton = By.xpath("//a[text()='Войти']");
    private By incorrectPasswordMessage = By.xpath("//p[text()='Некорректный пароль']");
    private WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public RegistrationPage open(){
        driver.get(REG_URL);
        return this;
    }

    public RegistrationPage setName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public RegistrationPage setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage clickConfirm(){
        driver.findElement(confirmButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickLogin(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
