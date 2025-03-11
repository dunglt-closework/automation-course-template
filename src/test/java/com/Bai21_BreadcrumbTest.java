package com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21_BreadcrumbTest extends BasicTest{
    @Test()
    public void breadcrumbTest() throws Exception{
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        String menu1 = "Hệ thống truyền động, Khung gầm";
        String menu2 = "Hệ thống phanh";
        String menu3 = "Phanh tay ô tô";

        hoverElement(menu1);
        hoverElement(menu2);


        // WebElement emlementMenu1 = driver.findElement(By.xpath("//a[contains(text()," + menu1+")]"));
        // actions.moveToElement(emlementMenu1).perform();

        // WebElement emlementMenu2 = driver.findElement(By.xpath("//a[contains(text()," + menu2 +")]"));
        // actions.moveToElement(emlementMenu2).perform();


        WebElement emlementMenu3 = driver.findElement(By.xpath("//a[contains(text(),'" + menu3 +"')]"));
        actions.click(emlementMenu3).perform();
 
        String expected = menu1 + " / " + menu2 + " / " + menu3;
        
        // Dynamic locator
        String locator = "//nav[@class='woocommerce-breadcrumb']";
        WebElement breadcrumb =  driver.findElement(By.xpath(locator));
        breadcrumb.getText();
        System.out.println(breadcrumb.getText());

        Assert.assertTrue(breadcrumb.getText().contains(expected));



        // WebElement breadcrumb1 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[1]"));
        // Assert.assertEquals(breadcrumb1.getText(), "Trang chủ");

        // WebElement breadcrumb2 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[2]"));
        // Assert.assertEquals(breadcrumb2.getText(), "Sản phẩm");

        // WebElement breadcrumb3 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[3]"));
        // Assert.assertEquals(breadcrumb3.getText(), "Hệ thống truyền động, Khung gầm");

        // WebElement breadcrumb4 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[4]"));
        // Assert.assertEquals(breadcrumb4.getText(), "Hệ thống phanh");


    }


    public void hoverElement (String menu){
        WebElement emlementMenu1 = driver.findElement(By.xpath("//a[contains(text(),'" + menu+"')]"));
        actions.moveToElement(emlementMenu1).perform();


    }
    
}
