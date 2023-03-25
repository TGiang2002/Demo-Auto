package com.example.test.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.test.core.helper.ReadConfigPropertyFile;
import com.example.test.core.keywork.CustomKeyword;


public class BaseTest {
    public WebDriver driver;
    public CustomKeyword keyword;
    
    @BeforeTest
    public void setUp() throws Exception{
        String pathChromeDriver = "src\\test\\java\\com\\example\\test\\core\\resources\\driver\\chromedriver.exe";
        String baseUrl = ReadConfigPropertyFile.getPropertyValue("url");
        System.setProperty("webdriver.chrome.driver",
        pathChromeDriver);
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
