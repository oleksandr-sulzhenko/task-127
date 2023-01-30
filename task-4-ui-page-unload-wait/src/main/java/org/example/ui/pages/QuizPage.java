package org.example.ui.pages;

import org.example.ui.pages.locator.QuizLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizPage extends BasePage<QuizPage> {

    private final static String ENDPOINT = "/quiztest";
    private final QuizLocators quizLocators = new QuizLocators();

    public QuizPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public QuizPage openPage() {
        driver.get(CONFIG.uiDomain() + ENDPOINT);
        return this;
    }

    public WebElement findQuiz(String name) {
        return driver.findElements(quizLocators.getQUIZ_CONTAINER()).stream().filter(container -> container.findElement(quizLocators.getQUIZ_HEADER()).getText().equals(name)).findFirst().orElseThrow();
    }

    public void pressQuizStart(WebElement quizContainer) {
        quizContainer.findElement(quizLocators.getQUIZ_BUTTON()).click();
    }

    public QuizPage selectOption(int option) {
        driver.findElements(quizLocators.getQUIZ_OPTION()).get(option).click();
        return this;
    }

    public QuizPage submitAnswer() {
        driver.findElement(quizLocators.getQUIZ_ANSWER_BUTTON()).click();
        return this;
    }

    public String getQuestionHeader() {
        return driver.findElement(quizLocators.getQUESTION_COUNTER()).getText();
    }
}
