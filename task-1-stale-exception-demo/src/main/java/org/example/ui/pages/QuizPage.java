package org.example.ui.pages;

import org.example.ui.pages.locator.QuizLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizPage extends BasePage<QuizPage> {

    private final static String PATH = "/quiztest";
    private final QuizLocators quizLocators = new QuizLocators();

    public QuizPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public QuizPage openPage() {
        driver.get(CONFIG.uiDomain() + PATH);
        return this;
    }

    public WebElement findQuiz(String name) {
        return driver.findElements(quizLocators.getQUIZ_CONTAINER())
                .stream()
                .filter(container -> container.findElement(
                        quizLocators.getQUIZ_HEADER()).getText().equals(name))
                .findFirst()
                .orElseThrow();
    }

    public void pressQuizStart(WebElement element) {
        refreshElementReference(element, quizLocators.getQUIZ_BUTTON());
    }
}
