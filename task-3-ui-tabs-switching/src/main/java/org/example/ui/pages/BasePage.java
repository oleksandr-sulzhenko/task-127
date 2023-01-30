package org.example.ui.pages;

import org.aeonbits.owner.ConfigFactory;
import org.example.settings.EnvironmentConfig;
import org.example.settings.GeneralConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage<T> {
    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected static final EnvironmentConfig ENVIRONMENT_CONFIG = ConfigFactory.create(EnvironmentConfig.class);
    protected static final GeneralConfig CONFIG = ConfigFactory.create(GeneralConfig.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, ENVIRONMENT_CONFIG.timeout());
        openPage();
    }

    public abstract T openPage();
}