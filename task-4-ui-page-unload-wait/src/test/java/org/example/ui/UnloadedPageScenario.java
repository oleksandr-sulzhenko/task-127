package org.example.ui;

import org.example.ui.action.QuizAction;
import org.example.ui.pages.locator.QuizLocators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnloadedPageScenario extends BaseTestScenario {

    /*
    4)  Imagine the following scenario: you click on a button that should redirect you to a new page,
    but the page URL stays the same and the DOM structure stays almost the same. Provide a code fragment to wait
    explicitly for the page to unload. Waiting for the page to load is not necessary (perhaps you want to gracefully
    handle some errors in case you are left on the same page).
     */

    private QuizAction quizAction;

    @BeforeEach
    public void initSetup() {
        initSetupDriver();
        quizAction = new QuizAction(driver);
    }

    @Test
    public void testPageUnload() {
        quizAction.startQuiz("Java");
        Assertions.assertEquals(quizAction.getQuestionNumber(), 1);
        quizAction.answerAndGoNext(0);
        quizAction.waitToPageUnload();
        Assertions.assertEquals(quizAction.getQuestionNumber(), 2);
    }

    @Test
    public void testPageUnloadByMainElements() {
        quizAction.startQuiz("Java");
        Assertions.assertEquals(quizAction.getQuestionNumber(), 1);
        quizAction.answerAndGoNext(0);
        quizAction.waitToPageUnload(new QuizLocators().getQUIZ_HEADER());
        Assertions.assertEquals(quizAction.getQuestionNumber(), 2);
    }
}
