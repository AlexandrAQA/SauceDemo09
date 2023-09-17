package org.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public static final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
