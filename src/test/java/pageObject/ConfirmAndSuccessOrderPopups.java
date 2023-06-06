package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmAndSuccessOrderPopups {

    private WebDriver driver;
    // Попап оформитьзаказ:
    // Кнопка Нет
    private By noButton = By.xpath(".//button[text() = \"Нет\"]");

    // Кнопка Да
    private By yesButton = By.xpath(".//button[text() = \"Да\"]");

    //Попап Заказ оформлен:
    //Кнопка Посмотреть статус
    private By checkStatusButton = By.xpath(".//button[text()= \"Посмотреть статус\"]");

    private By successPopupHeader = By.xpath(".//div[@class = \"Order_ModalHeader__3FDaJ\"]");


    public ConfirmAndSuccessOrderPopups(WebDriver driver) {
        this.driver = driver;
    }


    public void clickYesButton(){
        driver.findElement(yesButton).click();
    }

    public String getSuccessPopupHeader () {
        String header = driver.findElement(successPopupHeader).getText();
        return header;
    }

    public void checkAndClickStatusButton(){
        driver.findElement(checkStatusButton).isEnabled();
        driver.findElement(checkStatusButton).click();
    }
}
