package com.aqa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void userShouldLoginWithValidCredentials(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String products = driver.findElement(By.xpath(".//span[@class = 'title']")).getText();
        String urlProducts = "https://www.saucedemo.com/inventory.html";
        assertEquals(urlProducts, "https://www.saucedemo.com/inventory.html",
                "Products url is changed or user is not logged in");
        assertTrue(productsPage.getTitle()
                                .isDisplayed(),
                "The user is not logged in");
    }

    @Test
    public void passwordShouldBeRequiredForLogin(){
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getError(),
                "Epic sadface: Password is required",
                "The error Message is not correct");
    }

    @Test
    public void passwordShouldBeCorrectForSuccessLogin(){
        loginPage.open();
        loginPage.login("standard_user", "12345");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service",
                "The error Message is not correct");
    }
}
