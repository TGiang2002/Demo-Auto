package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    ////#region Declare web element
    private String expectedMessage = "Product successfully added to your shopping cart";
    private String addToCart = "//p[@id='add_to_cart']";
    private String productSuccessfullyAdded = "//div[@id='layer_cart'] //i//ancestor::h2";
    private WebElement btnAddToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addToCart)));
    private WebElement messageProductSuccessfullyAdded = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productSuccessfullyAdded)));
    //#endregion


    //#region page actions 
    public void clickOnAddToCartButton() throws InterruptedException{
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.btnAddToCart);
        this.btnAddToCart.click();
    }

    public boolean isProductSuccessfullyAddedCorrect(){
        if(messageProductSuccessfullyAdded.getAttribute("innerText").equals(expectedMessage)){
            return true;
        }
        return false;
    }
    //#endregion
}
