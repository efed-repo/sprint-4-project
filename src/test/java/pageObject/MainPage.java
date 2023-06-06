package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    private WebDriver driver;


    // Кнопка в сообщении о куках
    private By cookiePopupButton = By.xpath(".//button[text() = \"да все привыкли\"]");

    // Кнопка Заказать в верхней части страницы
    private By topOrderButton = By.xpath
            (".//button[@class = \"Button_Button__ra12g\"]");

    // Кнопка Заказать в нижней части страницы
    private By bigOrderButton = By.xpath
            (".//button[@class = \"Button_Button__ra12g Button_UltraBig__UU3Lp\"]");

    //Картинка самоката
    private By scooterImage = By.xpath(".//div[@class = \"Home_BluePrint__TGX2n\"]");

    // Список Вопросы о важном
    //private By faqListOfQuestions= By.xpath (".//div[@class = \"accordion\"]");

    private By faqListOfQuestions= By.xpath (".//div[@class = \"accordion\"]/div");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickTopOrderButton (){
        driver.findElement(topOrderButton).click();
    }

    public void clickBigOrderButton (){
        driver.findElement(bigOrderButton).click();
    }

    public void navigateToFAQSection () {
        WebElement element =  driver.findElement(faqListOfQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }


    //нужен ли метод?
    public void waitForLoadScooterImage (){
        new WebDriverWait(driver, Duration.ofSeconds (10))
                .until(driver -> (driver.findElement(scooterImage).isEnabled()));

    }

    public void clickCookieButton (){
        if (driver.findElement(cookiePopupButton).isDisplayed()) {
            driver.findElement(cookiePopupButton).click();
        }
    }

    public void list (){

        List<WebElement> elements = driver.findElements(faqListOfQuestions);
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
    }

}
