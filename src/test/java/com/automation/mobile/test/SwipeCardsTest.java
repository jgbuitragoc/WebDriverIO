package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.SwipeScreen;
import com.automation.mobile.utils.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {

    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void setLoginScreen() {
        HomeScreen homeScreen = returnHomeScreen();
        Assert.assertTrue(homeScreen.isSubtitleVisible());
        swipeScreen = homeScreen.clickSwipeMenuBtn();
        Assert.assertTrue(swipeScreen.isTitleVisible());
    }

    @Test
    public void SwipeCards() {
        int numberOfCards = 5;
        int currentCard = 0;
        while (numberOfCards > currentCard) {
            Assert.assertTrue(swipeScreen.verifyCardByNumber(currentCard));
            swipeScreen.rightSwipeSingleCard(currentCard);
            currentCard++;
        }
        swipeScreen.scrollDown();
        Assert.assertTrue(swipeScreen.isYouFindMeTxtVisible());
    }
}
