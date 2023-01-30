package org.example.ui.action;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;


public abstract class BaseAction<T extends BasePage> {
    protected WebDriver driver;
    protected final T page;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
        this.page = openProjectPage();
    }

    protected abstract T openProjectPage();
}
