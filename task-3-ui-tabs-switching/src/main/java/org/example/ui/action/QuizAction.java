package org.example.ui.action;

import org.example.ui.pages.QuizPage;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class QuizAction extends BaseAction<QuizPage> {
    public QuizAction(WebDriver driver) {
        super(driver);
    }

    @Override
    protected QuizPage openProjectPage() {
        return new QuizPage(driver);
    }
}
