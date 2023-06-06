package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageRentInfoScreen {

    private WebDriver driver;

    // Календарь Когда привезти самокат
    private By pickDateField =
            By.xpath("//div[@class = \"react-datepicker__input-container\"]/input");

    // выбор в календаре понедельника 3-ей недели.
    private By thirdWeekFirstDay =
            By.xpath("//div[@class = \"react-datepicker__month\"]/div[3]/div[1]");

    // Выпадающий список Срок аренды
    private By rentTimeDropDown = By.xpath(".//div[@class = \"Dropdown-control\"]");

    //первый элемент выпадающего списка Срок Аренды
    private By firstElementRentTimeDropDown =
            By.xpath(".//div[@class = \"Dropdown-menu\"]/div[1]");

    // Чекбокс Черный жемчуг
    private By blackColourCheckbox = By.id("black");

    // Чекбокс Серая безысходность
    private By greyColourCheckbox = By.id("grey");

    // Поле Комментарий для курьера
    private By commentField = By.xpath
            (".//input[@class = \"Input_Input__1iN_Z Input_Filled__1rDxs Input_Responsible__1jDKN\"]");

    // Кнопка Заказать(рядом с Назад)
    private By orderButton =
            By.xpath(".//div[@class = \"Order_Buttons__1xGrp\"]/button[text() = \"Заказать\"]");

    // Кнопка Назад
    private By backButton = By.xpath(".//button[text() = \"Назад\"]");


    public OrderPageRentInfoScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRequiredFields() {
        driver.findElement(pickDateField).click();
        driver.findElement(thirdWeekFirstDay).click();
        driver.findElement(rentTimeDropDown).click();
        driver.findElement(firstElementRentTimeDropDown).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

}
