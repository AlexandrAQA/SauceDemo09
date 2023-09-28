package com.aqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.CartPage;
import org.pages.HeaderPage;
import org.pages.LoginPage;
import org.pages.ProductsPage;
import org.steps.LoginSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    HeaderPage headerPage;
    CartPage cartPage;
    LoginSteps loginSteps;

    @BeforeMethod
    public void setUp() {
        //initialize web driver and create driver instance
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Set up browser and waiting
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        headerPage = new HeaderPage(driver);
        cartPage = new CartPage(driver);
        loginSteps = new LoginSteps(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
       if (driver != null) {
           driver.quit();
        }
    }
}
