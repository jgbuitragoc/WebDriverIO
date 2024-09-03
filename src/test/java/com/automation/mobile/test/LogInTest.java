package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.utils.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    private LoginScreen loginScreen;

    @BeforeMethod
    public void setLoginScreen(){
        HomeScreen homeScreen = returnHomeScreen();
        Assert.assertTrue(homeScreen.isSubtitleVisible());
        loginScreen = homeScreen.clickLoginMenuBtn();
        Assert.assertTrue(loginScreen.isSignUpContainerVisible());
    }

    @Test
    @Parameters({"email","password"})
    public void logInSuccessfully(String email,String password){
        loginScreen.clickLoginContainer();
        loginScreen.fillLogInData(email,password);
        loginScreen.clickLogInBtn();
        Assert.assertTrue(loginScreen.isLogInSuccessful());
    }

}
