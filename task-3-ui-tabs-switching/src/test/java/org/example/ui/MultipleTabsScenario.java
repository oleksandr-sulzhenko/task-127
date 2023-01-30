package org.example.ui;

import org.example.ui.action.QuizAction;
import org.example.util.MultipleTabUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demonstrates the following task:
 * 3) Provide a code fragment that switches the current browser to another tab (consider there are only 2 tabs). Please comment on the code in detail.
 */
public class MultipleTabsScenario extends BaseTestScenario {
    private MultipleTabUtil multipleTabUtil;

    @BeforeEach
    public void initSetup() {
        initSetupDriver();
        new QuizAction(driver);
        multipleTabUtil = new MultipleTabUtil(driver);
    }

    @Test
    public void handleStaleElementReferenceExceptionTest() {
        multipleTabUtil.openNewTab();
        multipleTabUtil.switchTab();
        assertEquals("W3Schools Quizzes", driver.getTitle());
        multipleTabUtil.switchTab();
        assertEquals("", driver.getTitle());
        assertEquals(2, driver.getWindowHandles().size());
    }
}
