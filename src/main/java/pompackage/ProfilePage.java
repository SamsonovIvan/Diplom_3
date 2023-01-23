package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfilePage {
    public final static String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private By profileButton = By.xpath("//a[text()='Профиль']");
    private By exitButton = By.xpath("//button[text()='Выход']");
    private By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    private WebDriver driver;
    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }



    public LoginPage clickExit(){
        driver.findElement(exitButton).click();
        return new LoginPage(driver);
    }

    public MainPage clickLogo(){
        driver.findElement(logo).click();
        return new MainPage(driver);
    }

    public MainPage clickConstructor(){
        driver.findElement(constructorButton).click();
        return new MainPage(driver);
    }

    public void areWeOnProfilePage(){
        assertEquals(PROFILE_URL, driver.getCurrentUrl());
        assertTrue(driver.findElement(profileButton).isDisplayed());
    }
}
