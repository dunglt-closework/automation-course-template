package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;



public class Bai20_ShoppingCartTest extends BasicTest{

    @Test()
    public void shoppingCartTest() throws Exception {

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

        // Get current number of item in cart
        WebElement numberOfExistItems = driver.findElement(By.xpath("//div[contains(@class,'d-table-cell')]//b"));
        int existCartCount = Integer.parseInt(numberOfExistItems.getText());
        int newCartCount = existCartCount + 1;

        // searching
        WebElement searchField = driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6']//input[@id='s']"));
        searchField.sendKeys("merc");

        //Utils.hardWait();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'bom-nuoc-xe')]"))).click();

        // select first result
        //WebElement resultProduct = driver.findElement(By.xpath("//a[contains(@href,'bom-nuoc-xe')]"));
        //resultProduct.click();

        // select option England
        WebElement selectSource = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']"));
        selectSource.click();

        WebElement selectEngland = driver.findElement(By.xpath("//option[@value='england']"));
        selectEngland.click();

        // Click "Them vao gio hang"
        WebElement addToCart = driver.findElement(By.xpath("//button[contains(@class,'add_to_cart')]"));
        addToCart.click();

        // Verify item added to cart
        WebElement numberOfItems = driver.findElement(By.xpath("//div[contains(@class,'d-table-cell')]//b"));
        Assert.assertEquals(numberOfItems.getText(),  String.valueOf(newCartCount));

    }
}
