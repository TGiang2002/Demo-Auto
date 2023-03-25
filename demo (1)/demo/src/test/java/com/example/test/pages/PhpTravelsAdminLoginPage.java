package com.example.test.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.test.core.helper.ReadConfigPropertyFile;


public class PhpTravelsAdminLoginPage extends BasePage{

    public PhpTravelsAdminLoginPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Declare object
     */
    WebElement txtEmail = keyword.findWebElementByXpath("//input[@name='email']");
    WebElement txtPassword = keyword.findWebElementByXpath("//input[@name='password']");
    WebElement btnLogin = keyword.findWebElementByXpath("//button[@type='submit']");
    
   // WebElement txtEmail1 = driver.findElement(By.xpath("//input[@name='email']"));

   
    /**
     * Implement Function
     */
    public void actionLoginAdminPhpTravels(){
        keyword.sendKeys(txtEmail, ReadConfigPropertyFile.getPropertyValue("email"));
        keyword.sendKeys(txtPassword, ReadConfigPropertyFile.getPropertyValue("password"));
        keyword.scrollAndWaitToClick(btnLogin);
    }

    public void actionLoginAdminPhpTravelsUsingDataProvider(String email, String password){
        keyword.sendKeys(txtEmail, email);
        keyword.sendKeys(txtPassword, password);
        keyword.scrollAndWaitToClick(btnLogin);
    }
}
