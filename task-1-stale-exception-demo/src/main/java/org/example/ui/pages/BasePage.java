package org.example.ui.pages;

import org.aeonbits.owner.ConfigFactory;
import org.example.settings.EnvironmentConfig;
import org.example.settings.GeneralConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;

public abstract class BasePage<T> {
    public static final int REFRESH_ATTEMPTS = 5;
    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected static final EnvironmentConfig ENVIRONMENT_CONFIG = ConfigFactory.create(EnvironmentConfig.class);
    protected static final GeneralConfig CONFIG = ConfigFactory.create(GeneralConfig.class);


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, ENVIRONMENT_CONFIG.timeout());
        openPage();
    }

    // Option 1. Refresh element reference
    public WebElement refreshElementReference(WebElement rootElement, By selector) {
        // TODO Consider to extract screenshoting to framework level
        int attempts = 0;
        while (attempts < REFRESH_ATTEMPTS) {
            try {
                // the refreshing itself:
                return driverWait.until(ExpectedConditions.elementToBeClickable(rootElement.findElement(selector)));
            } catch (StaleElementReferenceException exception) {
                takeScreenshotBecauseOfException(exception);
            }
            attempts++;
        }
        throw new StaleElementReferenceException("Could not refresh element reference by " + selector);
    }

    // Option 2 (RARE CASE). Constantly wait for required element.
    //           Warning: this approach can be used only if we are sure that the exact same element will be visible again
    public void waitFotElementConstantlyAndClick(WebElement element) {
        driverWait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    private void takeScreenshotBecauseOfException(StaleElementReferenceException causeException) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String projectHomeDir = System.getProperty("user.dir");
        String newFileName = projectHomeDir + File.separator + "logs" + File.separator
                + LocalDateTime.now() + ".png";
        if (!screenshotFile.renameTo(new File(newFileName))) {
            throw new RuntimeException("Could not move file \"" + screenshotFile + "\" to \""
                    + newFileName + "\"", causeException);
        }
    }

    // Option 3. Use selenide. The object returned by the $ command is called a "proxy-element".
    // At the moment of creation of proxy-element
    // the real search of element on the page is not initiated.
    // But on any subsequent action or condition check - the actual replica of the page element
    // will be acquired by the "proxy-element", and the corresponding action or condition check will be "proxied" to it.

    public abstract T openPage();
}
