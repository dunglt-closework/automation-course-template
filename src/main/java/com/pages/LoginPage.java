package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    By byEmailField = By.xpath("//input[@id='username']");
    By byPassField = By.xpath("//input[@id='password']");
    By byLoginButton = By.xpath("//button[@name='login']");
    By byLoginSucess = By.xpath("//li[contains(@class,'logout')]//a");
    By byNumberOfExistItems = By.xpath("//div[contains(@class,'d-table-cell')]//b");

    //Login
    public void login(String email, String password){
        WebElement emailField = driver.findElement(byEmailField);
        emailField.sendKeys(email);
    
        WebElement passField = driver.findElement(byPassField);
        passField.sendKeys(password);
    
        WebElement loginButton = driver.findElement(byLoginButton);
        loginButton.click();
    }

    //verify Login success
    public void verifyLogin(){
        WebElement loginSuccess = driver.findElement(byLoginSucess);
        Assert.assertEquals(loginSuccess.getText(), "Thoát");    
    }

    // Get current number of items in cart
    public int getNumberOfExistItems(){
        WebElement numberOfExistItems = driver.findElement(byNumberOfExistItems);
        int existCartCount = Integer.parseInt(numberOfExistItems.getText());
        return existCartCount + 1;
    }




    
}
