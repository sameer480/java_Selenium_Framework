package utils;

import base.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtil {

    private static final int DEFAULT_TIMEOUT = 10;

    //  Generic wait object
    private static WebDriverWait getWait(int seconds) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
    }

    //  Wait for visibility
    public static WebElement waitForElementVisible(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //  Wait for clickable
    public static WebElement waitForElementClickable(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    //  Wait for presence
    public static WebElement waitForPresence(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //  Wait for invisibility
    public static boolean waitForInvisibility(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //  Wait for title
    public static boolean waitForTitleContains(String title) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.titleContains(title));
    }

    //  Wait for URL
    public static boolean waitForUrlContains(String url) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.urlContains(url));
    }
}