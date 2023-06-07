package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class OrderPageRentInfoScreen {

    private WebDriver driver;

    // Календарь Когда привезти самокат
    private By pickDateField =
            By.xpath("//div[@class = \"react-datepicker__input-container\"]/input");

    private By calendar =
            By.xpath("//div[@class = \"react-datepicker__month\"]/div/div");

    // Выпадающий список Срок аренды
    private By rentTimeDropDown = By.xpath(".//div[@class = \"Dropdown-control\"]");

    //список поля Срок Аренды
    private By rentTimeValues =
            By.xpath(".//div[@class = \"Dropdown-option\"]");

    // Чекбокс Черный жемчуг
    //private By blackColourCheckbox = By.id("black");

    // Чекбокс Серая безысходность
    //private By greyColourCheckbox = By.id("grey");

    // Поле Комментарий для курьера
    // private By commentField = By.xpath(".//input[@class = \"Input_Input__1iN_Z Input_Filled__1rDxs Input_Responsible__1jDKN\"]");

    // Кнопка Заказать(рядом с Назад)
    private By orderButton =
            By.xpath(".//div[@class = \"Order_Buttons__1xGrp\"]/button[text() = \"Заказать\"]");

    // Кнопка Назад
    //private By backButton = By.xpath(".//button[text() = \"Назад\"]");


    public OrderPageRentInfoScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRentTimeField() {
        driver.findElement(rentTimeDropDown).click();
        List<WebElement> elements = driver.findElements(rentTimeValues);
        int indexOfRandomCalendarElement = new Random()
                .ints(0, elements.size() - 1)
                .findFirst()
                .getAsInt();
        elements.get(indexOfRandomCalendarElement).click();

    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void fillDateField() {
        driver.findElement(pickDateField).click();
        List<WebElement> elements = driver.findElements(calendar);
        int indexOfRandomCalendarElement = new Random()
                .ints(0, elements.size() - 1)
                .findFirst()
                .getAsInt();
        elements.get(indexOfRandomCalendarElement).click();

    }

}
