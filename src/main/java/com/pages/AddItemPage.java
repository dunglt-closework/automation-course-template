package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AddItemPage extends BasePage{

    public AddItemPage(WebDriver givendriver){
        super(givendriver);
    }
    
    public void Searching(String key){
        By bysearchField = By.xpath("//div[@class='col-xs-12 col-sm-6']//input[@id='s']");
        WebElement searchField = driver.findElement(bysearchField);
        searchField.sendKeys(key);
    }

    public void selectResult(String key2){
        By bySelect = By.xpath("//a[contains(@href,'" + key2 +"')]");
        WebElement resultProduct = driver.findElement(bySelect);
        resultProduct.click();
    }

    
    public void selectSourceOption(String nation){
        By bySelectSource = By.xpath("//select[@id='pa_xuat-xu']");
        By bySelectNation = By.xpath("//option[@value='" + nation +"']");

        WebElement SelectSource = driver.findElement(bySelectSource);
        SelectSource.click();
        WebElement SelectNation = driver.findElement(bySelectNation);
        SelectNation.click();
    }

    public void addToCart(){
        By byAddItem = By.xpath("//button[contains(@class,'add_to_cart')]");

        WebElement AddItem = driver.findElement(byAddItem);
        AddItem.click();

    }

    public void verifyAddSucess(int number){
        By byNumberOfItems = By.xpath("//div[contains(@class,'d-table-cell')]//b");

        WebElement numberOfItems = driver.findElement(byNumberOfItems);
        Assert.assertEquals(numberOfItems.getText(),  String.valueOf(number));

    }
}
