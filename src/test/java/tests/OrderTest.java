package tests;

import org.junit.Test;
import pageobjects.MainPage;
import pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTest {

    @Test
    public void checkOrderProcess() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderTop();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.fillFirstPage(
                "Иван",
                "Иванов",
                "Москва",
                "89999999999"
        );

        orderPage.fillSecondPage("01.07.2026");

        assertTrue(orderPage.isOrderSuccessful());
    }
}
