import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObject.ConfirmAndSuccessOrderPopups;
import pageObject.MainPage;
import pageObject.OrderPagePersonalInfoScreen;
import pageObject.OrderPageRentInfoScreen;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTests extends BaseTest {
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
                {"Иван", "Сергеев", "Санкт-Петербург", "89045678584"},
                {"Анна", "Николаева", "Москва", "89045670000"},
                {"Петр", "Данилов", "Нижний Новгород", "89788706545"},
        };
    }

    @Test
    public void makeOrderUseTopOrderButtonTestSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .clickCookieButton()
                .clickTopOrderButton();
        // Заполняем форму аренды
        fillAllRentDataAndConfirmRent();
    }

    @Test
    public void makeOrderUseBigOrderButtonTestSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .clickCookieButton()
                .clickBigOrderButton();
        // Заполняем форму аренды
        fillAllRentDataAndConfirmRent();
    }

    private void fillAllRentDataAndConfirmRent() {
        //заполняем первую страницу заказа
        OrderPagePersonalInfoScreen personalInfoPage = new OrderPagePersonalInfoScreen(driver);
        personalInfoPage
                .fillFields(name, secondName, address, phone)
                .clickNextButton();

        //заполняем вторую страницу заказа
        OrderPageRentInfoScreen rentInfoPage = new OrderPageRentInfoScreen(driver);
        rentInfoPage.fillDateField();
        rentInfoPage.fillRentTimeField();
        rentInfoPage.clickOrderButton();

        //Подтвердить заказ, проверить, что есть заголовок попапа Заказ оформлен.
        ConfirmAndSuccessOrderPopups confirmOrder = new ConfirmAndSuccessOrderPopups(driver);
        confirmOrder
                .clickYesButton()
                .checkStatusButtonDisplays();
        String actual = confirmOrder.getSuccessPopupHeader();
        String expected = "Заказ оформлен";
        assertTrue(actual.contains(expected));
    }
}

