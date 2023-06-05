package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPagePersonalInfoScreen {

    private WebDriver driver;

    //Поле Имя
    private By nameField = By.xpath (".//div[@class = \"Order_Form__17u6u\"]/div[1]");

    //Поле Фамилия
    private By secondNameField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[2]");

    //Поле Адрес:куда привезти заказ
    private By addressField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[3]");

    //Выпадающий список Станция метро
    private By metroStationField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[4]");

    //Поле Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[5]");

    //Кнопка Далее
    private By nextButton =
            By.xpath(".//button[text() = \"Далее\"]");


    public OrderPagePersonalInfoScreen(WebDriver driver){
        this.driver = driver;
    }
}
