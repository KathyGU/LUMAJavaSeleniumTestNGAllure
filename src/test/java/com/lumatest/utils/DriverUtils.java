package com.lumatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverUtils {
    private static final ChromeOptions chromeOptions;
    private static final SafariOptions safariOptions;

    static {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        safariOptions = new SafariOptions();
    }

    public static WebDriver createChromeDriver(WebDriver driver) {
        if (driver == null) {
            return new ChromeDriver(chromeOptions);
        } else {
            driver.quit();
            return new ChromeDriver(chromeOptions);
        }
    }

    private static WebDriver createSafariDriver(WebDriver driver) {
        if (driver == null) {
            return new SafariDriver(safariOptions);
        } else {
            driver.quit();
            return new SafariDriver(safariOptions);
        }
    }

    public static WebDriver createDriver(String browser, WebDriver driver) {
        switch (browser) {
            case "chrome" -> {
                return createChromeDriver(driver);
            }
            case "safari" -> {
                return createSafariDriver(driver);
            }
            default -> {
                return null;
            }
        }
    }

}




