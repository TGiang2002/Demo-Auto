package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo {
    public WebDriver driver;
    public String baseUrl = "http://automationpractice.com/index.php";
    
    @BeforeTest
    public void setupChromeDriver() {
        // setup driver
        System.setProperty("webdriver.chrome.driver",
        "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // call driver
        driver.get(baseUrl);
    }

    @Test(testName = "Verify The Homepage Is Loading Correct Without Any Error")
    public void verifyTheHomepageIsLoadingCorrectWithoutAnyError(){
        //VerifyTitlePage
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.equals("My Store"), "The actual title are not match with expected");
    }

    @Test(testName = "Verify The Product Are Added Into Cart")
    public void verifyTheProductAreAddedIntoCart() throws Exception{
        WebElement shortSleeveProduct = driver.findElement(By.xpath("//a[@class='product_img_link'] //img[@alt='Faded Short Sleeve T-shirts']"));
        shortSleeveProduct.click();
        Thread.sleep(5000);///* */
        WebElement addToCart = driver.findElement(By.xpath("//p[@id='add_to_cart']"));
        addToCart.click();
        Thread.sleep(5000);
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='layer_cart'] //i//ancestor::h2"));
        String expectedMessage = "Product successfully added to your shopping cart";
        String actualMessage = successMessage.getText();
        String actualMessage1 = successMessage.getAttribute("innerText");
        Assert.assertEquals(actualMessage, expectedMessage, "Actual message does not matched as expected message");
    }

    @AfterTest
    public void tearDownChromeDriver() {
        driver.quit();
    }
}
