import org.junit.Test;
import pompackage.MainPage;

public class ConstructorSectionsTest extends PrepairingTest {

    @Test
    public void sauceClickTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickSauceChapter()
                .isSauceHeaderIsDisplayed();
    }

    @Test
    public void bunClickTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickFillingsChapter()
                .clickBunChapter()
                .isBunHeaderIsDisplayed();
    }

    @Test
    public void fillingsClickTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickFillingsChapter()
                .isFillingsHeaderIsDisplayed();
    }

    @Test
    public void scrollToFillingsTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .scrollToFillings()
                .isFillingsHeaderIsDisplayed();
    }

    @Test
    public void scrollToSauceTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .scrollToFillings()
                .scrollToSauce()
                .isSauceHeaderIsDisplayed();
    }

    @Test
    public void scrollToBunsTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .scrollToFillings()
                .scrollToBuns()
                .isBunHeaderIsDisplayed();
    }
}
