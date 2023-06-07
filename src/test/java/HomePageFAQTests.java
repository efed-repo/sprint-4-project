import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.MainPage;


import static org.junit.Assert.assertEquals;

public class HomePageFAQTests extends BaseTest {

    @Test
    public void checkFAQList() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadScooterImage()
                .clickCookieButton()
                .navigateToFAQSection();
        assertEquals("На главной странице должно быть 8 воросов",
                8, mainPage.getListOfFAQQuestionsCount());
    }
}
