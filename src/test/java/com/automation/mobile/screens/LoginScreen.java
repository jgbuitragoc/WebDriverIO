package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String LOGIN_CONTAINER = "button-login-container";
    private static final String SIGN_UP_CONTAINER = "button-sign-up-container";
    private static final String EMAIL_INPUT = "input-email";
    private static final String PASSWORD_INPUT = "input-password";
    private static final String REPEAT_PASSWORD_INPUT = "input-repeat-password";
    private static final String SIGN_UP_BUTTON = "button-SIGN UP";
    private static final String LOG_IN_ALERT = "android:id/alertTitle";
    private static final String LOG_IN_BUTTON = "button-LOGIN";

    @AndroidFindBy(accessibility = LOGIN_CONTAINER)
    private WebElement loginContainer;
    @AndroidFindBy(accessibility = SIGN_UP_CONTAINER)
    private WebElement signUpContainer;
    @AndroidFindBy(accessibility = EMAIL_INPUT)
    private WebElement emailInput;
    @AndroidFindBy(accessibility = PASSWORD_INPUT)
    private WebElement passwordInput;
    @AndroidFindBy(accessibility = REPEAT_PASSWORD_INPUT)
    private WebElement repeatPasswordInput;
    @AndroidFindBy(accessibility = SIGN_UP_BUTTON)
    private WebElement signUpBtn;
    @AndroidFindBy(id = LOG_IN_ALERT)
    private WebElement logInAlert;
    @AndroidFindBy(accessibility = LOG_IN_BUTTON)
    private WebElement logInBtn;


    public boolean isLoginContainerVisible() {
        waitElementVisibility(loginContainer);
        return loginContainer.isDisplayed();
    }

    public boolean isSignUpContainerVisible() {
        waitElementVisibility(signUpContainer);
        return signUpContainer.isDisplayed();
    }

    public void clickSignUpContainer() {
        signUpContainer.click();
    }

    public void fillSignUpData(String email, String password, String repeatPassword) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(repeatPassword);
    }

    public void clickSignUpBtn() {
        signUpBtn.click();
    }

    public boolean isSignedUpSuccessful() {
        waitElementVisibility(logInAlert);
        return logInAlert.getText().equals("Signed Up!");
    }

    public void clickLoginContainer() {
        loginContainer.click();
    }

    public void fillLogInData(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickLogInBtn() {
        logInBtn.click();
    }

    public boolean isLogInSuccessful() {
        waitElementVisibility(logInAlert);
        return logInAlert.getText().equals("Success");
    }
}
