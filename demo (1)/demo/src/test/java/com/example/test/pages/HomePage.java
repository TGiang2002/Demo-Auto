package com.example.test.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public String getHomePageTitle = driver.getTitle();
}
