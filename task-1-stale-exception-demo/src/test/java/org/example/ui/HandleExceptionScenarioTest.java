package org.example.ui;

import org.example.ui.action.QuizAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test demonstrates:
 *   1) How would you handle a StaleElementReferenceException? Please provide a code fragment or fragments,
 *   if you know about several common ways of handling.
*/
public class HandleExceptionScenarioTest extends BaseTestScenario {

    private QuizAction quizAction;


    @BeforeEach
    public void initSetup() {
        initDriverSetup();
        quizAction = new QuizAction(driver);
    }

    @Test
    public void handleStaleElementReferenceExceptionTest() {
        Assertions.assertDoesNotThrow(() -> {
            quizAction.startQuiz("Java");
        });
    }
}
