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

    private By question1 = By.id("accordion__heading-0");
    private By question2 = By.id("accordion__heading-1");
    private By question3 = By.id("accordion__heading-2");
    private By question4 = By.id("accordion__heading-3");
    private By question5 = By.id("accordion__heading-4");
    private By question6 = By.id("accordion__heading-5");
    private By question7 = By.id("accordion__heading-6");
    private By question8 = By.id("accordion__heading-7");

    private By answer1 = By.id("accordion__panel-0");
    private By answer2 = By.id("accordion__panel-1");
    private By answer3 = By.id("accordion__panel-2");
    private By answer4 = By.id("accordion__panel-3");
    private By answer5 = By.id("accordion__panel-4");
    private By answer6 = By.id("accordion__panel-5");
    private By answer7 = By.id("accordion__panel-6");
    private By answer8 = By.id("accordion__panel-7");

    public void clickOrderTop() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottom() {
        driver.findElement(orderBottomButton).click();
    }

    public void clickQuestion(int index) {
        driver.findElement(By.id("accordion__heading-" + index)).click();
    }

    public String getAnswerText(int index) {
        return driver.findElement(By.id("accordion__panel-" + index)).getText();
    }
}
