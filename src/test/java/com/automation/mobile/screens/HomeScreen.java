package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private static final String SUBTITLE_TEXT = "new UiSelector().textContains(\"Demo app for the appium-boilerplate\")";


    @AndroidFindBy(uiAutomator = SUBTITLE_TEXT)
    private WebElement subtitleText;


    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSubtitleVisible() {
        waitElementVisibility(subtitleText);
        return subtitleText.isDisplayed();
    }

}
