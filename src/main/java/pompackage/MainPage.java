package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPage {
    public static String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By profileButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By makeOrderButton = By.xpath("//button[contains(text(),'Оформить заказ')]");
    private final By constructorHeader = By.xpath("//h1[text()='Соберите бургер']");
    private final By bunChapter = By.xpath("//div[span[text()='Булки']]");
    private final By bunHeader = By.xpath("//h2[text()='Булки']");
    private final By sauceChapter = By.xpath("//div[span[text()='Соусы']]");
    private final By sauceHeader = By.xpath("//h2[text()='Соусы']");
    private final By fillingsChapter = By.xpath("//*[text()='Начинки']");
    private final By fillingsHeader = By.xpath("//h2[text()='Начинки']");
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage open(){
        driver.get(MAIN_URL);
        return this;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickProfileButtonBeforeAuth(){
        driver.findElement(profileButton).click();
        return new LoginPage(driver);
    }

    public ProfilePage clickProfileButtonAfterAuth(){
        driver.findElement(profileButton).click();
        return new ProfilePage(driver);
    }

    public MainPage clickBunChapter(){
        driver.findElement(bunChapter).click();
        return this;
    }

    public MainPage scrollToBuns(){
        WebElement scroll = driver.findElement(bunHeader);
        new Actions(driver)
                .moveToElement(scroll)
                .perform();
        return this;
    }

    public void isBunHeaderIsDisplayed(){
        assertTrue(driver.findElement(bunHeader).isDisplayed());
    }

    public MainPage clickSauceChapter(){
        driver.findElement(sauceChapter).click();
        return this;
    }

    public MainPage scrollToSauce(){
        WebElement scroll = driver.findElement(sauceHeader);
        new Actions(driver)
                .moveToElement(scroll)
                .perform();
        return this;
    }

    public void isSauceHeaderIsDisplayed(){
        assertTrue(driver.findElement(sauceHeader).isDisplayed());
    }

    public MainPage clickFillingsChapter(){
        driver.findElement(fillingsChapter).click();
        return this;
    }

    public MainPage scrollToFillings(){
        WebElement scroll = driver.findElement(fillingsHeader);
        new Actions(driver)
                .moveToElement(scroll)
                .perform();
        return this;
    }

    public void isFillingsHeaderIsDisplayed(){
        assertTrue(driver.findElement(fillingsHeader).isDisplayed());
    }

    public void areWeOnMainPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(MAIN_URL));
        assertEquals(MAIN_URL, driver.getCurrentUrl());
        assertTrue(driver.findElement(makeOrderButton).isDisplayed());
        assertTrue(driver.findElement(constructorHeader).isDisplayed());
    }

}
