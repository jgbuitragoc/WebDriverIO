package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.utils.test.BaseTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    private LoginScreen loginScreen;

    @BeforeMethod
    public void setLoginScreen() {
        HomeScreen homeScreen = returnHomeScreen();
        Assert.assertTrue(homeScreen.isSubtitleVisible());
        loginScreen = homeScreen.clickLoginMenuBtn();
        Assert.assertTrue(loginScreen.isSignUpContainerVisible());
    }

    @Test
    public void SignUpSuccessfully() {
        loginScreen.clickSignUpContainer();
        Faker faker = new Faker();
        String password = faker.internet().password();
        loginScreen.fillSignUpData(faker.internet().emailAddress(), password, password);
        loginScreen.clickSignUpBtn();
        Assert.assertTrue(loginScreen.isSignedUpSuccessful());
    }

}

