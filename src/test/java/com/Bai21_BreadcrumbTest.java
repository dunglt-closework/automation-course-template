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

        WebElement menu1 = driver.findElement(By.xpath("//a[contains(text(),'Hệ thống truyền động, Khung gầm')]"));
        actions.moveToElement(menu1).perform();

        WebElement menu2 = driver.findElement(By.xpath("//a[contains(text(),'Hệ thống phanh')]"));
        actions.moveToElement(menu2).perform();


        WebElement menu3 = driver.findElement(By.xpath("//a[contains(text(),'Phanh tay ô tô')]"));
        actions.click(menu3).perform();
 

        WebElement breadcrumb1 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[1]"));
        Assert.assertEquals(breadcrumb1.getText(), "Trang chủ");

        WebElement breadcrumb2 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[2]"));
        Assert.assertEquals(breadcrumb2.getText(), "Sản phẩm");

        WebElement breadcrumb3 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[3]"));
        Assert.assertEquals(breadcrumb3.getText(), "Hệ thống truyền động, Khung gầm");

        WebElement breadcrumb4 = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']//a[4]"));
        Assert.assertEquals(breadcrumb4.getText(), "Hệ thống phanh");


    }
    
}
