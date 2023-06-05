package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    // Кнопка Заказать в верхней части страницы
    private By topOrderButton = By.xpath
            (".//button[@class = \"Button_Button__ra12g\"]");

    // Кнопка Заказать в нижней части страницы
    private By bigOrderButton = By.xpath
            (".//button[@class = \"Button_Button__ra12g Button_UltraBig__UU3Lp\"]");

    // Блок Вопросы о важном?

    // Список Вопросы о важном
    private By faqListOfQuestions= By.xpath (".//div[@class = \"accordion\"]");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
}
