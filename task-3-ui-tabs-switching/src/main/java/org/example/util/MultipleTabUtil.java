package org.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class MultipleTabUtil {
    private WebDriver driver;
    private String activeTab;

    public MultipleTabUtil(WebDriver driver) {
        this.driver = driver;
        this.activeTab = driver.getWindowHandle();
    }

    public String openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        activeTab = driver.getWindowHandle();
        return activeTab;
    }

    public String switchTab() {
        Set<String> tabs = driver.getWindowHandles();
        tabs.remove(activeTab);
        driver.switchTo().window(tabs.iterator().next());
        activeTab = driver.getWindowHandle();
        return activeTab;
    }
}
