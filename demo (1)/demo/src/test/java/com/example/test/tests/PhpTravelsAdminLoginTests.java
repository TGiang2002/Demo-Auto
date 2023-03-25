package com.example.test.tests;

import org.testng.annotations.Test;

import com.example.test.core.datadriven.phpAccount;
import com.example.test.pages.PhpTravelsAdminLoginPage;

public class PhpTravelsAdminLoginTests extends BaseTest {
    
    @Test(testName = "Verify The User Have Logged in Success")
    public void verifyTheUserHaveLoggedinSuccess(){
        //VerifyTitlePage
        PhpTravelsAdminLoginPage phpTravelsAdminLoginPage = new PhpTravelsAdminLoginPage(driver);
        phpTravelsAdminLoginPage.actionLoginAdminPhpTravels();
    }

    @Test(testName = "Verify The User Have Logged in Success", dataProviderClass = phpAccount.class, dataProvider = "accountLogin")
    public void verifyTheUserHaveLoggedinSuccessUsingDataProvider(String email, String password){
        //VerifyTitlePage
        PhpTravelsAdminLoginPage phpTravelsAdminLoginPage = new PhpTravelsAdminLoginPage(driver);
        phpTravelsAdminLoginPage.actionLoginAdminPhpTravelsUsingDataProvider(email, password);;
    }
}
