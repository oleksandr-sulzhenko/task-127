package org.example.ui;

import org.aeonbits.owner.ConfigFactory;
import org.example.settings.EnvironmentConfig;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

abstract class BaseTestScenario {

    protected static final EnvironmentConfig ENVIRONMENT_CONFIG = ConfigFactory.create(EnvironmentConfig.class);

    protected WebDriver driver;

    public void initDriverSetup() {
        ChromeOptions options = new ChromeOptions();
        if (ENVIRONMENT_CONFIG.fullSize()) {
            options.addArguments("start-maximized");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        } else {
            options.addArguments("--window-size=" + ENVIRONMENT_CONFIG.resolution());
        }
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void clearUp() {
        driver.quit();
    }
}
