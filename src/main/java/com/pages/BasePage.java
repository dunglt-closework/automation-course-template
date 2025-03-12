package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    protected static WebDriverWait wait;
    public BasePage(WebDriver givendriver){
        this.driver = givendriver;
        
    }
}
