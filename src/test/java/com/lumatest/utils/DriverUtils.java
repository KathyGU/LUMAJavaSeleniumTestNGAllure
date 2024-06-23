package com.lumatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {
    private static final ChromeOptions chromeOptions;

    static{
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
    }

    public static WebDriver createChromeDriver(WebDriver driver) {
        if (driver == null) {
            return new ChromeDriver(chromeOptions);
        } else {
            driver.quit();
            return new ChromeDriver(chromeOptions);
        }
    }
}
