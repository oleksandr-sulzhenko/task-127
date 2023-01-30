package org.example.ui.pages;

import org.openqa.selenium.WebDriver;

public class QuizPage extends BasePage<QuizPage> {

    private final static String ENDPOINT = "/quiztest";

    public QuizPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public QuizPage openPage() {
        driver.get(CONFIG.uiDomain() + ENDPOINT);
        return this;
    }
}
