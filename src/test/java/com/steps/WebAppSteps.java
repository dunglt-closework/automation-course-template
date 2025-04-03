package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAppSteps {
    WebDriver driver;
    @Given("I am on register page")
    public void i_am_on_register_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @When("I enter a already registered email address {string}")
    public void i_enter_a_already_registered_email_address(String email){
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(email);

    }


    @And("I click register button")
    public void i_click_register_button(){
        driver.findElement(By.xpath("//button[@name='register']")).click();
    }

    @Then("The error message should be displayed {string}")
    public void the_error_message_should_be_displayed(String error_msg){
    //    Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText(), error_msg);
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertEquals(errorMessage.getText(), error_msg);
    }

}
