package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.MainPage;
import pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private boolean isTopButton;

    public OrderTest(boolean isTopButton) {
        this.isTopButton = isTopButton;
    }

    @Parameterized.Parameters
    public static Object[][] getButtons() {
        return new Object[][]{
                {true},
                {false}
        };
    }

    @Test
    public void checkOrderProcess() {

        MainPage mainPage = new MainPage(driver);

        // Проверяем обе кнопки
        if (isTopButton) {
            mainPage.clickOrderTop();
        } else {
            mainPage.clickOrderBottom();
        }

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
