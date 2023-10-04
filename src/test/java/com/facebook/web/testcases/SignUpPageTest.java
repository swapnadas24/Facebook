package com.facebook.web.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.web.base.FacebookWebbase;
import com.facebook.web.pages.SignUpPage;

public class SignUpPageTest extends FacebookWebbase {

    SignUpPage signUpPage;

    public SignUpPageTest() {

        super();
    }

    @BeforeMethod
    public void setUp() {

        initialization();
        signUpPage = new SignUpPage();
    }

    @Test
    public void signUpPageTest() throws InterruptedException {

        signUpPage.click_CreateNewAccount_tab();

        signUpPage.first_LastName(props.getProperty("FirstName"), props.getProperty("LastName"));
        signUpPage.enter_emailOrMobile(props.getProperty("EmailORMobile"), props.getProperty("Password"));
        signUpPage.select_Date();
        signUpPage.select_Month();
        signUpPage.select_Year();
        signUpPage.select_Gender();

    }

    @AfterMethod()
    public void quit() {

        // driver.quit();
    }
}
