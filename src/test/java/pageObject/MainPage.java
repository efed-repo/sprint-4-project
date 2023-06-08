package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    public MainPage clickOnEachFAQQuestionAndCheckText() {
        List<WebElement> questionElements = driver.findElements(faqListOfQuestions);

        String[] expectedTexts = new String[]{
                "Сколько это стоит? И как оплатить?\nСутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Хочу сразу несколько самокатов! Так можно?\nПока что у нас так: один заказ — один самокат. " +
                        "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Как рассчитывается время аренды?\nДопустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Можно ли заказать самокат прямо на сегодня?\n" +
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Можно ли продлить заказ или вернуть самокат раньше?\n" +
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Вы привозите зарядку вместе с самокатом?\n" +
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Можно ли отменить заказ?\n" +
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Я жизу за МКАДом, привезёте?\n" +
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."

        };

        for (int i = 0; i < questionElements.size(); i++) {
            WebElement element = questionElements.get(i);
            element.click();
            String actualText = element.getText();
            assertEquals(expectedTexts[i], actualText);
        }
        return this;
    }

    public int getListOfFAQQuestionsCount() {
        return driver.findElements(faqListOfQuestions).size();
    }

}
