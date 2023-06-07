package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    // Кнопка Заказать-большая в нижней части страницы
    private By bigOrderButton = By.xpath
            (".//div[@class = \"Home_FinishButton__1_cWm\"]/button");

    //Картинка самоката - проверять загрузку страницы
    private By scooterImage = By.xpath(".//div[@class = \"Home_BluePrint__TGX2n\"]");

    // Заздел вопросов
    private By faqListOfQuestions = By.xpath(".//div[@class = \"accordion\"]/div");

    private By faqListOfAnswers = By.xpath(".//div[@class = \"accordion__heading\"]/div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage clickCookieButton() {
        if (driver.findElement(cookiePopupButton).isDisplayed()) {
            driver.findElement(cookiePopupButton).click();
        }
        return this;
    }

    public MainPage waitForLoadScooterImage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> (driver.findElement(scooterImage).isEnabled()));
        return this;
    }

    public OrderPagePersonalInfoScreen clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
        return new OrderPagePersonalInfoScreen(driver);
    }

    public OrderPagePersonalInfoScreen clickBigOrderButton() {
        WebElement element = driver.findElement(bigOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> (driver.findElement(bigOrderButton).isEnabled()));
        element.click();
        return new OrderPagePersonalInfoScreen(driver);
    }

    public MainPage navigateToFAQSection() {
        WebElement element = driver.findElement(faqListOfQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    /*   public void getListOfFAQQuestions(){
        List<WebElement> questionElements = driver.findElements(faqListOfQuestions);
        System.out.println("размер списка вопросов = " + questionElements.size());

        for (int i = 0; i<questionElements.size(); i++){
            driver.findElement(faqListOfQuestions).click();
            String text = driver.findElement(faqListOfQuestions).getText();
            System.out.println(text);
        }
    }*/

    public int getListOfFAQQuestionsCount() {
        return driver.findElements(faqListOfQuestions).size();
    }


}
