package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;


public class Bai18_TabTest extends BasicTest{

    @Test()

    public void TabTest() throws Exception {

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Login

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("dunglt.bkhn@gmail.com");

        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        passField.sendKeys("dung1992@");

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        //verify Login success
        WebElement loginSuccess = driver.findElement(By.xpath("//li[contains(@class,'logout')]//a"));
        Assert.assertEquals(loginSuccess.getText(), "Thoát");

        Utils.hardWait();

        //Open a new tab
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank','_blank');");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Move to new tab
        driver.switchTo().window(tabs.get(1));

        // Open URL in the new tab
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait();


        // Close the old tab
        driver.switchTo().window(tabs.get(0));
        driver.close();

        // Verify user is still logged in
        driver.switchTo().window(tabs.get(1));
        WebElement loginSuccess2 = driver.findElement(By.xpath("//li[contains(@class,'logout')]//a"));
        Assert.assertEquals(loginSuccess2.getText(), "Thoát");
        

    }


    
}
