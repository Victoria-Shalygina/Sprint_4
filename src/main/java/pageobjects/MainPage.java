package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void clickQuestion(int index) {
        By questionLocator = By.id("accordion__heading-" + index);
        driver.findElement(questionLocator).click();
    }

    public String getAnswerText(int index) {
        By answerLocator = By.id("accordion__panel-" + index);
        return driver.findElement(answerLocator).getText();
    }
}
