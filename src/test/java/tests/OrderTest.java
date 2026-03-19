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
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String date;

    public OrderTest(boolean isTopButton, String name, String surname, String address, String phone, String date) {
        this.isTopButton = isTopButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {true, "Иван", "Иванов", "Москва", "89999999999", "01.07.2026"},
                {false, "Петр", "Петров", "Санкт-Петербург", "88888888888", "02.07.2026"}
        };
    }

    @Test
    public void checkOrderProcess() {

        MainPage mainPage = new MainPage(driver);

        if (isTopButton) {
            mainPage.clickOrderTop();
        } else {
            mainPage.clickOrderBottom();
        }

        OrderPage orderPage = new OrderPage(driver);

        orderPage.fillFirstPage(
                name,
                surname,
                address,
                phone
        );

        orderPage.fillSecondPage(date);

        assertTrue(orderPage.isOrderSuccessful());
    }
}
