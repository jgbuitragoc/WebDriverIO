package com.automation.mobile.utils.screens;

import com.automation.mobile.screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    private static final String WEB_VIEW_MENU_BUTTON = "Webview";
    private static final String LOGIN_MENU_BUTTON = "Login";
    private static final String FORM_MENU_BUTTON = "Forms";
    private static final String SWIPE_MENU_BUTTON = "Swipe";
    private static final String DRAG_MENU_BUTTON = "Drag";

    @AndroidFindBy(accessibility = WEB_VIEW_MENU_BUTTON)
    private WebElement webViewMenuBtn;
    @AndroidFindBy(accessibility = LOGIN_MENU_BUTTON)
    private WebElement loginMenuBtn;
    @AndroidFindBy(accessibility = FORM_MENU_BUTTON)
    private WebElement formMenuBtn;
    @AndroidFindBy(accessibility = SWIPE_MENU_BUTTON)
    private WebElement swipeMenuBtn;
    @AndroidFindBy(accessibility = DRAG_MENU_BUTTON)
    private WebElement dragMenuBtn;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebViewScreen clickWebViewMenuBtn() {
        webViewMenuBtn.click();
        return new WebViewScreen(driver);
    }

    public LoginScreen clickLoginMenuBtn() {
        loginMenuBtn.click();
        return new LoginScreen(driver);
    }

    public FormScreen clickFormMenuBtn() {
        formMenuBtn.click();
        return new FormScreen(driver);
    }

    public SwipeScreen clickSwipeMenuBtn() {
        swipeMenuBtn.click();
        return new SwipeScreen(driver);
    }

    public DragScreen clickDragMenuBtn() {
        dragMenuBtn.click();
        return new DragScreen(driver);
    }
}
