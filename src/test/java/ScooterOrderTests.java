import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.ConfirmAndSuccessOrderPopups;
import pageObject.MainPage;
import pageObject.OrderPagePersonalInfoScreen;
import pageObject.OrderPageRentInfoScreen;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTests {

    private WebDriver driver;
    private final String name;
    private final String secondName;
    private final String address;
    private final String phone;

    public ScooterOrderTests(String name, String secondName, String address, String phone) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
    }


    @Parameterized.Parameters
    public static Object[][] setOrderData() {
        return new Object[][]{
                {"Имя","Фамилия","Санкт-Петербург","89045678584"},
                {"Анна","Николаева","Москва","89045670000"},
        };
    }

    @Before
    public void init() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void makeOrderUseTopOrderButtonTestSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickTopOrderButton();

        //заполняем первую страницу заказа
        OrderPagePersonalInfoScreen personalInfoPage = new OrderPagePersonalInfoScreen(driver);
        personalInfoPage.fillFields(name, secondName, address, phone);
        personalInfoPage.clickNextButton();

        //заполняем вторую страницу заказа
        OrderPageRentInfoScreen rentInfoPage = new OrderPageRentInfoScreen(driver);
        rentInfoPage.fillRequiredFields();
        rentInfoPage.clickOrderButton();

        //Подтвердить заказ, проверить, что есть заголовок попапа Заказ оформлен.
        ConfirmAndSuccessOrderPopups confirmOrder = new ConfirmAndSuccessOrderPopups(driver);
        confirmOrder.clickYesButton();
        String actual = confirmOrder.getSuccessPopupHeader();
        String expected = "Заказ оформлен";
        assertTrue(actual.contains(expected));
        confirmOrder.checkAndClickStatusButton();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}

