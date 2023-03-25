package com.example.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.test.pages.HomePage;

public class HomePageTests extends BaseTest {
    @Test(testName = "Verify The Homepage Is Loading Correct Without Any Error")
    public void verifyTheHomepageIsLoadingCorrectWithoutAnyError(){
        //VerifyTitlePage
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getHomePageTitle.equals("My Store"), "The actual title are not match with expected");
    }
}
