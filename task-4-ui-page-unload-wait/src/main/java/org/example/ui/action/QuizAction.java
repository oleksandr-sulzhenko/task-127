package org.example.ui.action;

import org.example.ui.pages.QuizPage;
import org.openqa.selenium.By;
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

    public QuizAction startQuiz(String name) {
        page.pressQuizStart(page.findQuiz(name));
        return this;
    }

    public QuizAction answerAndGoNext(int option) {
        page.selectOption(option);
        page.submitAnswer();
        return this;
    }

    /**
     * Waits for page to unload using either JS or Selenium approach
     * Uses JS approach if {@param elements} is empty, the Selenium otherwise.
     * @param elements things to become invisible, checked by Selenium, not JS
     * @return this supposed to be the second page, the page that's just been loaded
     */
    public QuizAction waitToPageUnload(By... elements) {
        if (elements.length == 0) {
            page.waitToPageUnloadByDocumentReadyState();
        } else {
            Arrays.stream(elements).forEach(page::waitToElementUnload);
        }
        return this;
    }

    public int getQuestionNumber() {
        return Integer.parseInt(page.getQuestionHeader().split(" ")[1]);
    }
}
