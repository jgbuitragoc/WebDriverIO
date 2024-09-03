package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String TITLE_TXT = "new UiSelector().textContains(\"Drag and Drop\")";

    @AndroidFindBy(uiAutomator = TITLE_TXT)
    private WebElement titleTxt;

    public boolean isTitleVisible() {
        waitElementVisibility(titleTxt);
        return titleTxt.isDisplayed();
    }
}
