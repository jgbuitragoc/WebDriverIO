package com.automation.mobile.test;

import com.automation.mobile.screens.*;
import com.automation.mobile.utils.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BottomMenuNavigationTest extends BaseTest {

    private HomeScreen homeScreen;

    @BeforeMethod
    public void setHomeScreen(){
        homeScreen = returnHomeScreen();
        Assert.assertTrue(homeScreen.isSubtitleVisible());
    }

    @Test
    public void bottomMenuNavigation() {
        WebViewScreen webViewScreen = homeScreen.clickWebViewMenuBtn();
        Assert.assertTrue(webViewScreen.isTitleVisible());
        LoginScreen loginScreen = homeScreen.clickLoginMenuBtn();
        Assert.assertTrue(loginScreen.isLoginContainerVisible());
        FormScreen formScreen = loginScreen.clickFormMenuBtn();
        Assert.assertTrue(formScreen.isTitleVisible());
        SwipeScreen swipeScreen = formScreen.clickSwipeMenuBtn();
        Assert.assertTrue(swipeScreen.isTitleVisible());
        DragScreen dragScreen = swipeScreen.clickDragMenuBtn();
        Assert.assertTrue(dragScreen.isTitleVisible());
    }

}
