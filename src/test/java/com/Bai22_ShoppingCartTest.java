package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.seleniumhq.jetty9.util.preventers.LoginConfigurationLeakPreventer;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.pages.LoginPage;
import com.pages.AddItemPage;
import com.utils.Utils;


public class Bai22_ShoppingCartTest extends BasicTest{

    int newCartCount;
    @Test()
    public void shoppingCartTest() throws Exception {


        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPage loginPage = new LoginPage(driver);

        //Login
        loginPage.login("dunglt.bkhn@gmail.com", "dung1992@");

        //verify Login success
        loginPage.verifyLogin();

        // Get current number of items in cart
        newCartCount = loginPage.getNumberOfExistItems();

        // Search item
        AddItemPage additem = new AddItemPage(driver);
        additem.Searching("merc");
        Utils.hardWait();

        // Select the first item
        additem.selectResult("bom-nuoc-xe");
        Utils.hardWait();

        // Select source
        additem.selectSourceOption("england");

        // Add item into cart
        additem.addToCart();
        Utils.hardWait();

        // Verify Add success
        additem.verifyAddSucess(newCartCount);

    }  
}
