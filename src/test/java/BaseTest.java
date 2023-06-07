import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
