package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai16_LoginTest extends BasicTest {

    @Test()
    public void loginTestSuccess() throws Exception {

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("dunglt.bkhn@gmail.com");

        WebElement passField = driver.findElement(By.xpath("//input[@id='password']"));
        passField.sendKeys("dung1992@");

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        WebElement loginSuccess = driver.findElement(By.xpath("//li[contains(@class,'logout')]//a"));
        Assert.assertEquals(loginSuccess.getText(), "Thoát");

    }

    @Test()
    public void loginTestFail() throws Exception {

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("dunglt.bkhn@gmail.com");

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        WebElement ErrorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        FErrorMessage.getText(), "Lỗi: Mục nhập mật khẩu trống.");

    }
    
}
