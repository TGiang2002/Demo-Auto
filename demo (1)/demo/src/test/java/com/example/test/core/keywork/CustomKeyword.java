package com.example.test.core.keywork;

import javax.lang.model.element.Element;
import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomKeyword {
    private WebDriver driver;
    private WebDriverWait wait;

    public CustomKeyword(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    /**
     * Keyword for open url with checking if the url valid or not
     * @param baseUrl
     * @throws Exception
     */
    public void openUrl(String baseUrl) throws Exception {
        if(baseUrl.startsWith("http://") || baseUrl.startsWith("https://"))
        {
            driver.get(baseUrl);
        }
        throw new Exception("url not start with http or http. Double check baseUrl");
    }

    /**
     * Scroll to element and find element by xpath
     * @param locator
     * @return
     */
    public WebElement findWebElementByXpath(String locator){
        try{
            scrollToElemtnIntoView(driver.findElement(By.xpath(locator)));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        } catch(WebDriverException ex ){
            throw new WebDriverException("Element not found!");
        }
    }

    /**
     * Scroll to element into View
     * @param element
     */
    public void scrollToElemtnIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement waitForElementDisplayed(WebElement element) {
        try{
            scrollToElemtnIntoView(element);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch(WebDriverException ex){
            throw new WebDriverException("Element not displayed");
        }
        
    }

    /**
     * Wait for Element displayed and input text
     * @param element
     * @param text
     */
    public void sendKeys(WebElement element, String text){
        try{
            waitForElementDisplayed(element).sendKeys(text);
        }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }

    /**
     * Scroll And Wait To Click
     * @param element
     * @return
     */
    public CustomKeyword scrollAndWaitToClick(WebElement element) {
        try{
            scrollToElemtnIntoView(element);
            waitForElementDisplayed(element);
            element.click();
            return new CustomKeyword(driver, wait);
        }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }

}
