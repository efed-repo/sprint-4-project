package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class OrderPagePersonalInfoScreen {

    private WebDriver driver;

    //Поле Имя
    private By nameField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[1]/input");

    //Поле Фамилия
    private By secondNameField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[2]/input");

    //Поле Адрес:куда привезти заказ
    private By addressField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[3]/input");

    //Выпадающий список Станция метро
    private By metroStationField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[4]");

    //список станций метро
    private By metroStationsList = By.xpath(".//ul[@class = \"select-search__options\"]/li");

    //Поле Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath(".//div[@class = \"Order_Form__17u6u\"]/div[5]/input");

    //Кнопка Далее
    private By nextButton =
            By.xpath(".//button[text() = \"Далее\"]");


    public OrderPagePersonalInfoScreen(WebDriver driver) {
        this.driver = driver;
    }


    public void fillFields(String name, String secondName, String address, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneNumberField).sendKeys(phone);
        driver.findElement(metroStationField).click();

        List<WebElement> elements = driver.findElements(metroStationsList);
        int indexOfRandomElement = new Random()
                .ints(0, elements.size()-1)
                .findFirst()
                .getAsInt();
        elements.get(indexOfRandomElement).click();

    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
