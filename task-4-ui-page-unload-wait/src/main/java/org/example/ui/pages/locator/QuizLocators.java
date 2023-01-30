package org.example.ui.pages.locator;

import org.openqa.selenium.By;

public class QuizLocators {
    private final By QUIZ_CONTAINER = By.className("quizcontainer");
    private final By QUIZ_HEADER = By.className("quizheader");
    private final By QUIZ_DETAILS = By.className("quizbody");
    private final By QUIZ_BUTTON = By.className("ws-btn");
    private final By QUIZ_ANSWER_BUTTON = By.className("answerbutton");
    private final By QUIZ_OPTION = By.className("radiocontainer");
    private final By QUESTION_COUNTER = By.xpath("//div[@id='quizcontainer']/h3");

    public By getQUIZ_CONTAINER() {
        return QUIZ_CONTAINER;
    }

    public By getQUIZ_HEADER() {
        return QUIZ_HEADER;
    }

    public By getQUIZ_DETAILS() {
        return QUIZ_DETAILS;
    }

    public By getQUIZ_BUTTON() {
        return QUIZ_BUTTON;
    }

    public By getQUIZ_ANSWER_BUTTON() {
        return QUIZ_ANSWER_BUTTON;
    }

    public By getQUIZ_OPTION() {
        return QUIZ_OPTION;
    }

    public By getQUESTION_COUNTER() {
        return QUESTION_COUNTER;
    }
}
