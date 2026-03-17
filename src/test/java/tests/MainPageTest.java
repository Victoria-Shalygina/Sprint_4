package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.MainPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MainPageTest extends BaseTest {

    private int questionIndex;
    private String expectedText;

    public MainPageTest(int questionIndex, String expectedText) {
        this.questionIndex = questionIndex;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getFaqData() {
        return Arrays.asList(new Object[][]{
                {0, "Сутки — 400 рублей"},
                {1, "несколько самокатов"},
                {2, "только начиная с завтрашнего дня"},
                {3, "пока что нет"},
                {4, "продлить аренду"},
                {5, "самокат привезут"},
                {6, "Москва"},
                {7, "курьеру"}
        });
    }

    @Test
    public void checkFaqAnswers() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickQuestion(questionIndex);
        String answer = mainPage.getAnswerText(questionIndex);

        assertTrue(answer.contains(expectedText));
    }
}
