package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends BaseScreen {

    private static final String TITLE_TXT = "new UiSelector().textContains(\"Next-gen browser and mobile automation test framework for Node.js\")";

    @AndroidFindBy(uiAutomator = TITLE_TXT)
    private WebElement titleTxt;

    public boolean isTitleVisible() {
        waitElementVisibility(titleTxt);
    return titleTxt.isDisplayed();
    }

    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }
}
