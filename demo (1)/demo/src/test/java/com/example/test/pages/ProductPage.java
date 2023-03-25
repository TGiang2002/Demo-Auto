package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    
    private String sleeveProduct = "//a[@class='product_img_link'] //img[@alt='Faded Short Sleeve T-shirts']";
    private WebElement shortSleeveProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sleeveProduct)));
    
   

     
    public void clickOnProductElement(){
        this.shortSleeveProduct.click();
    }
   

    
}
