package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai16_RegisterTest extends BasicTest {

    @Test()
    public void registerTest() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailField.sendKeys("testtest@gmail.com");

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='register']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertEquals(errorMessage.getText(), "Lỗi: An account is already registered with your email address. Please log in.");
    }
}
