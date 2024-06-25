package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(
            description = "TC-01 Open Base URL",
            groups = {"Smoke", "Regression"},
            testName = "NAVIGATION | Open Base URL"
    )
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("To verify that the base URL and title of the application are correct and as expected")
    @Link(TestData.BASE_URL)
    public void testOpenBaseURL() {
        Allure.step("SetUp expected results");
        final String expectedURL = TestData.BASE_URL + "/";
        final String expectedTitle = TestData.BASE_URL_TITLE;

        Allure.step("Open BaseURL");
        getDriver().get(TestData.BASE_URL);

        Allure.step("collect actualURL, actualTitle");
        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actualURL as expected");
        Assert.assertEquals(actualURL, expectedURL);
        Allure.step("Verify actualTitle as expected");
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(
            groups = {"Smoke", "Regression"},
            description = "TC-02 Top Menu Navigation",
            dataProvider = "navigationData",
            dataProviderClass = TestData.class,
            testName = "NAVIGATION | Navigate to top menu"
    )
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("To verify that the top menu navigation on the website functions correctly by ensuring that " +
    "clicking on menu items directs the user to the expected URL with the expected title")
    @Link(TestData.BASE_URL)
    public void testNavigationMenu(String baseUrl, By navbarMenu, String expectedURL, String expectedTitle) {
        Allure.step("Open Base Url");
        getDriver().get(baseUrl);

        Allure.step("Click on " + navbarMenu.toString());
        getDriver().findElement(navbarMenu).click();

        Allure.step("collect actualURL, actualTitle");
        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actualURL as expected");
        Assert.assertEquals(actualURL, expectedURL);
        Allure.step("Verify actualTitle as expected");
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
