package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class OrderPagePersonalInfoScreen {

    private WebDriver driver;

    //Поле Имя
    private By nameField = By.xpath(".//input[@placeholder = \"* Имя\"]");

    //Поле Фамилия
    private By secondNameField = By.xpath(".//input[@placeholder = \"* Фамилия\"]");

    //Поле Адрес:куда привезти заказ
    private By addressField = By.xpath(".//input[@placeholder = \"* Адрес: куда привезти заказ\"]");

    //Выпадающий список Станция метро
    private By metroStationField = By.xpath(".//input[@placeholder = \"* Станция метро\"]");

    //список станций метро
    private By metroStationsList = By.xpath(".//ul[@class = \"select-search__options\"]/li");

    //Поле Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath(".//input[@placeholder = \"* Телефон: на него позвонит курьер\"]");

    //Кнопка Далее
    private By nextButton =
            By.xpath(".//button[text() = \"Далее\"]");


    public OrderPagePersonalInfoScreen(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPagePersonalInfoScreen fillFields(String name, String secondName, String address, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneNumberField).sendKeys(phone);
        driver.findElement(metroStationField).click();

        List<WebElement> elements = driver.findElements(metroStationsList);
        int indexOfRandomElement = new Random()
                .ints(0, elements.size() - 1)
                .findFirst()
                .getAsInt();
        elements.get(indexOfRandomElement).click();
        return this;
    }

    public ConfirmAndSuccessOrderPopups clickNextButton() {
        driver.findElement(nextButton).click();
        return new ConfirmAndSuccessOrderPopups(driver);
    }

}
