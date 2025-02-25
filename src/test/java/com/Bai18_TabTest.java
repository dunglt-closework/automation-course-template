package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

//import io.github.bonigarcia.wdm.WebDriverManager;

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


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank','_blank');");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Chuyển sang tab mới
        driver.switchTo().window(tabs.get(1));

        // Mở lại URL trong tab mới
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        Utils.hardWait();
        driver.switchTo().window(tabs.get(0));

        Utils.hardWait();
        driver.close();

        //verify Login success
        driver.switchTo().window(tabs.get(1));
        WebElement loginSuccess2 = driver.findElement(By.xpath("//li[contains(@class,'logout')]//a"));
        Assert.assertEquals(loginSuccess2.getText(), "Thoát");

        Utils.hardWait();
        

    }


    
}
