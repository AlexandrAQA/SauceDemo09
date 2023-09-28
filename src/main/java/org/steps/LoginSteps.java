package org.steps;

import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void loginAsStandardUser() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

    }
}
