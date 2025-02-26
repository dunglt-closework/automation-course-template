package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;



public class Bai19_ICEHRM_LoginTest extends BasicTest{
    
    @Test(dataProvider = "login")
    public void loginTest(String user, String password, String result) throws Exception{
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement userField = driver.findElement(By.xpath("//input[@id='username']"));
        userField.sendKeys(user);

        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        passField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(@onclick,'submitLogin')]"));
        loginButton.click();

        if (result.equals("success")){
            WebElement loginSuccess = driver.findElement(By.xpath("//a[@class='logo']"));
            Assert.assertEquals(loginSuccess.getText(), "Home");
        }
        else{
            WebElement loginFail = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
            Assert.assertEquals(loginFail.getText(), "Login failed"); 
        }


    }

    @DataProvider(name= "login")
    public Object[][] testdata(){
        Object[][] testDataFeed = new Object[2][3];

        testDataFeed[0][0] = "admin";
        testDataFeed[0][1] = "admin";
        testDataFeed[0][2] = "success";

        testDataFeed[1][0] = "admin";
        testDataFeed[1][1] = "admin123";
        testDataFeed[1][2] = "error";



        return testDataFeed;

    }
}
