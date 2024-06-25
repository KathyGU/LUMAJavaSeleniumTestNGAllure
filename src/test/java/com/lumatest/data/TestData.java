package com.lumatest.data;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class TestData {
    public static final String BASE_URL = "https://naveenautomationlabs.com/opencart";
    public static final String BASE_URL_TITLE = "Your Store";

    //NavBar Menu

    public static final String TABLETS_URL = BASE_URL + "/index.php?route=product/category&path=57";
    public static final By TABLETS_MENU = By.xpath("//nav//a[text() = 'Tablets']");
    public static final String TABLETS_TITLE = "Tablets";

    //other menus

    public static final By SOFTWARE_MENU = By.xpath("//nav//a[text() = 'Software']");
    public static final String SOFTWARE_URL = BASE_URL + "/index.php?route=product/category&path=17";
    public static final String SOFTWARE_TITLE = "Software";

    @DataProvider(name = "navigationData")
    public static Object[][] getNavMenuData() {
        return new Object[][] {
                {BASE_URL,TABLETS_MENU,TABLETS_URL,TABLETS_TITLE},
                {BASE_URL, SOFTWARE_MENU,SOFTWARE_URL,SOFTWARE_TITLE}
        };
    }
}
