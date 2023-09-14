package com.aqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void userShouldLoginWithValidCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).submit();
        String products = driver.findElement(By.xpath(".//span[@class = 'title']")).getText();
        String urlProducts = "https://www.saucedemo.com/inventory.html";
        assertEquals(urlProducts, "https://www.saucedemo.com/inventory.html",
                "Products url is changed or user is not logged in");
        assertTrue(driver.findElement(By.xpath(".//span[@class = 'title']"))
                                .isDisplayed(), "The user is not logged in");
        assertEquals(products, "Products", "Element products is not displayed or changed");
    }

    @Test
    public void passwordShouldBeRequiredForLogin(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).submit();
        WebElement errorMessageWhenPswIsEmpty = driver.findElement(By.cssSelector("h3[data-test=error]"));
        assertEquals(errorMessageWhenPswIsEmpty.getText(),
                "Epic sadface: Password is required",
                "The error Message is not correct");
    }

    @Test
    public void passwordShouldBeCorrectForSuccessLogin(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("               ");
        driver.findElement(By.id("login-button")).submit();
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]"));
        assertEquals(errorMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "The error Message is not correct");
    }
}
