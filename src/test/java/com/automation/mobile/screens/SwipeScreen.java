package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class SwipeScreen extends BaseScreen {
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String TITLE_TXT = "new UiSelector().textContains(\"Swipe horizontal\")";
    private static final String YOU_FIND_ME_TXT = "new UiSelector().text(\"You found me!!!\")";

    private static final String CARD_ZERO = "new UiSelector().resourceId(\"__CAROUSEL_ITEM_0_READY__\")";
    private static final String CARD_ONE = "new UiSelector().resourceId(\"__CAROUSEL_ITEM_1_READY__\")";
    private static final String CARD_TWO = "new UiSelector().resourceId(\"__CAROUSEL_ITEM_2_READY__\")";
    private static final String CARD_THREE = "new UiSelector().resourceId(\"__CAROUSEL_ITEM_3_READY__\")";
    private static final String CARD_FOUR = "new UiSelector().resourceId(\"__CAROUSEL_ITEM_4_READY__\")";
    private static final String CARD_FIVE = "new UiSelector().resourceId(\"__CAROUSEL_ITEM_5_READY__\")";


    @AndroidFindBy(uiAutomator = TITLE_TXT)
    private WebElement titleTxt;
    @AndroidFindBy(uiAutomator = YOU_FIND_ME_TXT)
    private WebElement youFindMeTxt;
    @AndroidFindBy(uiAutomator = CARD_ZERO)
    private WebElement cardZero;
    @AndroidFindBy(uiAutomator = CARD_ONE)
    private WebElement cardOne;
    @AndroidFindBy(uiAutomator = CARD_TWO)
    private WebElement cardTwo;
    @AndroidFindBy(uiAutomator = CARD_THREE)
    private WebElement cardThree;
    @AndroidFindBy(uiAutomator = CARD_FOUR)
    private WebElement cardFour;
    @AndroidFindBy(uiAutomator = CARD_FIVE)
    private WebElement cardFive;

    public boolean isTitleVisible() {
        waitElementVisibility(titleTxt);
        return titleTxt.isDisplayed();
    }

    public void rightSwipeSingleCard() {
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int startX = screenWidth - (screenWidth / 3);
        int startY = screenHeight - (screenHeight / 3);
        int endX = screenWidth - (screenWidth / 2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),
                endX, startY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(scroll));
    }

    public void scrollDown() {
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int startX = screenWidth / 2;
        int startY = screenHeight / 2;
        int endY = screenHeight / 16;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(70), PointerInput.Origin.viewport(),
                startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(scroll));
    }


    public boolean verifyCardByNumber(int number) {
        switch (number) {
            case 0:
                waitElementVisibility(cardZero);
                return cardZero.isDisplayed();
            case 1:
                waitElementVisibility(cardOne);
                try {
                    return !cardZero.isDisplayed();
                } catch (NoSuchElementException e) {
                    return true;
                }
            case 2:
                waitElementVisibility(cardTwo);
                try {
                    return !cardOne.isDisplayed();
                } catch (NoSuchElementException e) {
                    return true;
                }
            case 3:
                waitElementVisibility(cardThree);
                try {
                    return !cardTwo.isDisplayed();
                } catch (NoSuchElementException e) {
                    return true;
                }
            case 4:
                waitElementVisibility(cardFour);
                try {
                    return !cardThree.isDisplayed();
                } catch (NoSuchElementException e) {
                    return true;
                }
            case 5:
                waitElementVisibility(cardFive);
                try {
                    return !cardFour.isDisplayed();
                } catch (NoSuchElementException e) {
                    return true;
                }
            default:
                return false;
        }
    }

    public boolean isYouFindMeTxtVisible() {
        waitElementVisibility(youFindMeTxt);
        return youFindMeTxt.isDisplayed();
    }
}
