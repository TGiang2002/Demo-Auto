package com.example.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.test.core.keywork.CustomKeyword;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public CustomKeyword keyword;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.keyword = new CustomKeyword(driver, wait);
        driver.manage().window().maximize();
        //customkeyword
    }
    
}
