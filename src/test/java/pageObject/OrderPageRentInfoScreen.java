package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageRentInfoScreen {

    private WebDriver driver;

    // Календарь Когда привезти самокат
    private By pickDateField =
            By.xpath("..//input[@class = \"Input_Input__1iN_Z Input_Responsible__1jDKN\"]");

    // Выпадающий список Срок аренды
    private By rentTimeDropDown = By.xpath(".//div[@class = \"Dropdown-root\"]");

    // Чекбокс Черный жемчуг
    private By blackColourCheckbox = By.id("black");

    // Чекбокс Серая безысходность
    private By greyColourCheckbox = By.id("grey");

    // Поле Комментарий для курьера
    private By commentField = By.xpath
            (".//input[@class = \"Input_Input__1iN_Z Input_Filled__1rDxs Input_Responsible__1jDKN\"]");

    // Кнопка Назад
    private By orderButton =
            By.xpath(".//div[@class = \"Order_Buttons__1xGrp\"]/button[text() = \"Заказать\"]");

    // Кнопка Далее
    private By backButton = By.xpath(".//button[text() = \"Назад\"]");


    // Попап оформитьзаказ:

    // Кнопка Нет
    private By noButton = By.xpath(".//button[text() = \"Нет\"]");

    // Кнопка Да
    private By yesButton = By.xpath(".//button[text() = \"Да\"]");

    public OrderPageRentInfoScreen(WebDriver driver) {
        this.driver = driver;
    }

}
