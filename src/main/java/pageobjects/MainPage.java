package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By orderTopButton = By.className("Button_Button__ra12g");
    private By orderBottomButton = By.xpath(".//button[text()='Заказать']");

    public void clickOrderTop() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottom() {
        driver.findElement(orderBottomButton).click();
    }

    public void clickQuestion(int questionIndex) {
        By questionLocator = By.id("accordion__heading-" + questionIndex);
        driver.findElement(questionLocator).click();
    }

    public String getAnswerTextWithWait(int questionIndex) {
        By answerLocator = By.id("accordion__panel-" + questionIndex);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));

        return driver.findElement(answerLocator).getText();
    }
}
