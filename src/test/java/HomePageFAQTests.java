import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.MainPage;

import java.util.List;

public class HomePageFAQTests {


    private WebDriver driver;

    @Before
    public void init() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();

    }

    @Test
    public void checkFAQList() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadScooterImage();
        mainPage.clickCookieButton();
        mainPage.navigateToFAQSection();
        mainPage.list();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
