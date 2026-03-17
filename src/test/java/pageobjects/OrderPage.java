package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath("//button[text()='Далее']");

    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By orderButton = By.xpath("//button[text()='Заказать']");
    private By confirmButton = By.xpath("//button[text()='Да']");
    private By successMessage = By.xpath("//div[contains(@class,'Order_ModalHeader')]");

    public void fillFirstPage(String name, String surname, String address, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    public void fillSecondPage(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(orderButton).click();
        driver.findElement(confirmButton).click();
    }

    public boolean isOrderSuccessful() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
